package by.tms.service.validation;

public class OperationValidation {

    public boolean wrongOperationFieldFilling(String operation){
        return !operation.equals("sum")
                && !operation.equals("sub")
                && !operation.equals("mul")
                && !operation.equals("div");
    }
    public boolean isFieldsEmpty(String x1 , String x2 , String operation){
        return x1.isEmpty() || x2.isEmpty() || operation.isEmpty();
    }
}
