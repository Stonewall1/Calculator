package by.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("by.tms")
@EnableAspectJAutoProxy
public class CalculatorConfiguration {
    @Bean
    public String calculatorName() {
        return "---Calculator---";
    }
}
