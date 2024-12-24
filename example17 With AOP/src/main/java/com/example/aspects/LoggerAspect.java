package com.example.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

   //private static final Log log = LogFactory.getLog(LoggerAspect.class);
   private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

   @Around(value="execution(* com.example.services.*.*(..))")
   public void log(ProceedingJoinPoint joinPoint)throws Throwable{
      logger.info(joinPoint.getSignature().toString()+ " method exection start");
      Instant start = Instant.now();
      // before method exection code run
      joinPoint.proceed();
      // after method execution code run that the working of @Around
      Instant finish = Instant.now();
      long timeElasped = Duration.between(start,finish).toMillis();
      logger.info("Time took to execute the method"+timeElasped);
      logger.info(joinPoint.getSignature().toString()+ " method exection end");
   }

   @AfterThrowing(value = "execution(* com.example.services.*.*(..))",throwing = "ex")
   public void logException(JoinPoint joinPoint, Exception ex){
   logger.log(Level.SEVERE,joinPoint.getSignature()+"An Exception thrown with the help of @AroundThrowing which is happen "+
   "due to "+ex.getMessage());
   }

   @AfterReturning(value="execution(* com.example.services.*.*(..))",returning = "retVal")
   public void logStatus(JoinPoint joinPoint, Object retVal){
      logger.info(joinPoint.getSignature().toString()+ " method successfully exection proceed with the status "+
              retVal.toString());
   }

   // Second Approach for using Annotation only few method that we target to apply aspects
   // provide the custom  annotation path inside below annotation
   @Around("@annotation(com.example.interfaces.LogAspect)")
   public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
      // write non-funcational logic
      // to apply certain  method
      logger.info(joinPoint.toString()+"Method Exection start here");
      Instant start = Instant.now();

      // below line return Proxy Object
      joinPoint.proceed();  // this line call actual method where we apply the advice

      Instant finish = Instant.now();
      long timeElapsed = Duration.between(start,finish).toMillis();
      logger.info("Time took to execute the method "+timeElapsed);
      //This signature provides metadata about the join point
      //such as the name of the method, its return type, and the declaring type
      logger.info(joinPoint.getSignature()+ " method exection end");



   }

}
