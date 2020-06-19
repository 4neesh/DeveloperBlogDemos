package com.aneesh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class footballAspect {

	@Before("execution( void com.aneesh.aop.* .playGame (..))")
	public void beforeAspect() {

		System.out.println("Make sure players warm up before game.");
	}

	@After("execution( void com.aneesh.aop.* .playGame (..))")
	public void afterAspect() {

		System.out.println("Make sure players warm down after a game.");
	}


	@Around( "execution(  int com.aneesh.aop.* .countPlayers (..))")
	public Integer aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		System.out.println("Around: Count the players on the pitch...");

		Object result = proceedingJoinPoint.proceed();

		System.out.println("Around: Count is done.");
		return (Integer)result;
	}

	@AfterReturning(pointcut = "execution( int com.aneesh.aop.* .countPlayers (..))", returning="result")
	public void afterReturningAspect(int result)  {

		System.out.println("AfterReturning has the result: " + result);
	}

	@AfterThrowing(pointcut = "execution( int com.aneesh.aop.* .countPlayers (..))", throwing = "thrownExpression")
	public void afterThrowingAspect(Throwable thrownExpression)  {

		System.out.println("AfterThrowing has received a message: " + thrownExpression.getMessage());
	}


}

