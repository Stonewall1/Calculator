package by.tms.storage;

import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationStorage {
    private static OperationStorage instance;
    private final List<Operation> operations = new ArrayList<>();

    private OperationStorage() {

    }

    public static OperationStorage getInstance() {
        if (instance == null) {
                instance = new OperationStorage();
        }
        return instance;
    }

    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
