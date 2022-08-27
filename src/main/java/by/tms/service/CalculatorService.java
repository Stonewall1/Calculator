package by.tms.service;

import by.tms.entity.Operation;
import by.tms.storage.OperationStorage;

public class CalculatorService {
    private final OperationStorage operationStorage = OperationStorage.getInstance();

    public Operation calculate(Operation operation) {
        double result = 0;
        switch (operation.getOperation()) {
            case "sum" -> result = operation.getX1() + operation.getX2();
            case "sub" -> result = operation.getX1() - operation.getX2();
            case "mul" -> result = operation.getX1() * operation.getX2();
            case "div" -> result = operation.getX1() / operation.getX2();
            default -> {
            }
        }
        operation.setResult(result);
        operationStorage.save(operation);
        return operation;
    }
}
