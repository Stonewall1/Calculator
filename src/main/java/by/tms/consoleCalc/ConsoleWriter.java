package by.tms.consoleCalc;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleWriter {
    public List<String> operations() {
        System.out.println("Operations available");
        List<String> list = new ArrayList<>();
        list.add("sub --> subtract");
        list.add("sum --> add");
        list.add("mul --> multiply");
        list.add("div --> divide");
        return list;
    }

    public void writeFirst() {
        String firstNumInput = "Enter number1";
        System.out.println(firstNumInput);
    }

    public void writeSecond() {
        String secondNumInput = "Enter number2";
        System.out.println(secondNumInput);
    }

    public void writeOperation() {
        String operationInput = "Enter operation";
        System.out.println(operationInput);
    }
}
