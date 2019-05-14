package com.epam.spring.impl.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.IEventLogger;
import com.epam.spring.impl.ConsoleEventLogger;
import com.epam.spring.impl.Event;


@Aspect
public class StatisticsAspect
{

	private IEventLogger otherLogger;
	private Map<Class<?>, Integer> statistic = new HashMap<>();

	private Integer countConsole = 0;
	private Integer countFile = 0;
	private Integer countCashe = 0;

	@Pointcut("execution(* com.epam.spring.impl.*.logEvent(..))")
	public void statisticPointCut()
	{

	}

	@Before("statisticPointCut()")
	public void advice(final JoinPoint joinPoint)
	{
		final Class<?> key = joinPoint.getTarget().getClass();

		if (!statistic.containsKey(key))
		{
			statistic.put(key, Integer.valueOf(1));
		}
		else
		{
			statistic.put(key, statistic.get(key) + 1);
		}
	}

	@Pointcut("execution(* com.epam.spring.impl.ConsoleEventLogger.logEvent(..))")
	public void replacePointCup()
	{

	}

	@Around("replacePointCup() && args(event)")
	public void replaceEdvice(ProceedingJoinPoint joinPoint, Object event) throws Throwable
	{

		final Class<?> key = ConsoleEventLogger.class;

		if (!statistic.containsKey(key))
		{
			joinPoint.proceed();
			statistic.put(key, Integer.valueOf(1));
		}

		if (statistic.get(key) > 1){
			otherLogger.logEvent((Event)event);
		}

	}

	public Map<Class<?>, Integer> getStatistic()
	{
		return statistic;
	}

	public void setOtherLogger(final IEventLogger otherLogger)
	{
		this.otherLogger = otherLogger;
	}
}
