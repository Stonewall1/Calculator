package by.tms.storage;

import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationStorage implements InMemoryStorage<Operation>{
    private static OperationStorage instance;

    private OperationStorage() {

    }

    public static OperationStorage getInstance() {
        if (instance == null) {
                instance = new OperationStorage();
        }
        return instance;
    }
    private final List<Operation> operations = new ArrayList<>();
    @Override
    public Operation save(Operation operation) {
        operations.add(operation);
        return operation;
    }

    @Override
    public List<Operation> getElements() {
        return operations;
    }
}
