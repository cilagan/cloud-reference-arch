package gov.psm.primary.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogger {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* gov.psm.primary.service.*.*.*(..))")
    public void logMethodArguments(JoinPoint JoinPoint) {
    	LOGGER.debug("Method Invoked: {}.{}",
                JoinPoint.getSignature().getDeclaringType().getSimpleName(),
                JoinPoint.getSignature().getName());
    	for(Object args : JoinPoint.getArgs()){
    		String argument = (args == null) ? "argument is null" : args.toString();
    		LOGGER.debug("argument: " + argument + " | ");
    	}
    }
}
