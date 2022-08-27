package by.tms.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Operation extends Entity {
    private double x1;
    private double x2;
    private double result;
    private String operation;
    private User user;
    private LocalDateTime time;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Operation() {

    }

    public Operation(double x1, double x2, String operation) {
        this.x1 = x1;
        this.x2 = x2;
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", result=" + result +
                ", operation='" + operation + '\'' +
                ", time=" + time +
                '}';
    }
}
