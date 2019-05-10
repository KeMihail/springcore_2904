package com.epam.spring.impl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect
{
	@Pointcut("execution(* *.logEvent(..))")
	private void allLogEventMethods()
	{

	}

	@Before("allLogEventMethods()")
	public void logBeffore(JoinPoint joinPoint)
	{
		System.out.println("logBeffore: " + joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName());
	}

	@AfterReturning(
			pointcut = "allLogEventMethods()",
			returning = "retVal"
	)
	public void logAfter(Object retVal)
	{
		System.out.println("retVal: " + retVal);
	}

	@AfterThrowing(
			pointcut = "allLogEventMethods()",
			throwing = "ex"
	)
	public void logAfterThrow(Throwable ex)
	{
		System.out.println(ex.getMessage());

	}
}
