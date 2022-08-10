package by.tms.service;

import by.tms.entity.Operation;
import by.tms.storage.OperationStorage;

public class CalculatorService {
    private final OperationStorage operationStorage = new OperationStorage();

    public Operation calculate(Operation operation){
        double result = 0;
        switch (operation.getOperation()) {
            case "sum":
                result = operation.getX1() + operation.getX2();
                break;
            case "sub":
                result = operation.getX1() - operation.getX2();
                break;
            case "mul":
                result = operation.getX1() * operation.getX2();
                break;
            case "div":
                result = operation.getX1() / operation.getX2();
                break;
            default:
                break;
        }
        operation.setResult(result);
        operationStorage.save(operation);
        return operation;
    }
}
