package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.InMemoryStorage;
import by.tms.storage.OperationStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CalculatorService {
    private final InMemoryStorage<Operation> operationStorage = OperationStorage.getInstance();

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
        return operationStorage.save(operation);
    }
    public List<Operation> getOperations() {
        return operationStorage.getElements();
    }
    public List<Operation> getOperationsByUser(User user){
        List<Operation> ops = new ArrayList<>();
        for (Operation operation : getOperations()) {
            if (operation.getUser().getId() == user.getId()) {
                ops.add(operation);
            }
        }
        return ops;
    }
}
