package com.cg.tutorial.employeemanagement.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.cg.osce.logging.OSCELogger;
import com.cg.osce.logging.utils.Utils;
import com.cg.tutorial.employeemanagement.exception.EmployeeManagementException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAspect {

	 OSCELogger osceLogger = new OSCELogger();

	 Utils utils = new Utils();
	private final Logger slf4jLogger = Logger.getLogger(this.getClass());

	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.cg.tutorial.employeemanagement.service.EmployeeServiceImpl..*(..))")
	public void controllerLogging(JoinPoint joint) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	
		 osceLogger.log("1234", "localhost", "EmployeeManagementSystem", "Services",
		 joint.getStaticPart().getSignature().getName(), Level.INFO, joint.getArgs(),
		 "1234");
		slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
		try {
			slf4jLogger.info("Info Input Parameters -:\n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterReturning(pointcut = "execution(* com.cg.tutorial.employeemanagement.service.EmployeeServiceImpl.*(..))", returning = "result")
	public void serviceSetterMethodLogging(JoinPoint joint, Object result) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		 osceLogger.log("1234", "localhost", "EmployeeManagementSystem", "Services",
		 joint.getStaticPart().getSignature().getName(), Level.INFO, result, "1234",
		 200);

		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}
	}

}
