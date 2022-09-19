package by.tms.consoleCalc;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class Application {
    private CalculatorService calculatorService;
    private ConsoleReader consoleReader;
    private ConsoleWriter consoleWriter;
    @Autowired
    @Qualifier("calculatorName")
    private String calculatorName;

    public Application() {

    }

    @Autowired
    public Application(CalculatorService calculatorService, ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.calculatorService = calculatorService;
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public void run() {
        System.out.println(calculatorName);
        System.out.println(consoleWriter.operations());
        while (true) {
            consoleWriter.writeFirst();
            double n1 = Double.parseDouble(consoleReader.read());

            consoleWriter.writeSecond();
            double n2 = Double.parseDouble(consoleReader.read());

            consoleWriter.writeOperation();
            String op = consoleReader.read();

            Operation operation = new Operation(n1, n2, op);
            calculatorService.calculate(operation);
            System.out.println(operation.getResult());
        }
    }
}
