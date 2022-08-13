package by.tms.service.validation;

import by.tms.entity.Operation;

public class OperationValidation {

    public boolean wrongOperationFieldFilling(String operation){
        return !operation.equals("sum")
                && !operation.equals("sub")
                && !operation.equals("mul")
                && !operation.equals("div");
    }
    public boolean isFieldsEmpty(String x1 , String x2 , String operation){
        if(x1.isEmpty() || x2.isEmpty() || operation.isEmpty()){
            return true;
        }
        return false;
    }
}
