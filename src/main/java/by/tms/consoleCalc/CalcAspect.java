package by.tms.consoleCalc;

import by.tms.service.CalculatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;


@Aspect
@Component
public class CalcAspect {
    private final AtomicLong count = new AtomicLong();
    private final Logger log = LogManager.getLogger(CalculatorService.class);

    @Pointcut("execution(public * by.tms.service.CalculatorService.calculate(..))")
    public void loggingPointcut() {

    }


    @Before("loggingPointcut()")
    public void loggingOperations() {
        count.incrementAndGet();
        log.info("Calculate method started " + count + " times");
    }
}
