package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component      //Bean으로 등록되어야 한다.
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /*
     * 메소드 성능을 측정한다.
     * 이 클래스가 바로 Spring AOP의 Aspect이다.
     * 이 내부가 Proxy 패턴으로 동작하는 것이다.
     */
    @Around("@annotation(LogExecutionTime)")        // 이 어노테이션을 적용하는 메소드에 이 메소드를 실행하겠다.
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws  Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // @Around 애노테이션을 가질 경우, JoinPoint를 인자로 받을 수 있다.
        // 이 인자로 Annotation이 달린 Target 메소드가 들어온다.
        //인자로 받은 메소드를 실행한다.
        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return proceed;
    }
}
