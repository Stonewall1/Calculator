package by.tms.consoleCalc;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    public String read(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
