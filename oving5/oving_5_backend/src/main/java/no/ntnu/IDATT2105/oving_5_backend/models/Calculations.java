package no.ntnu.IDATT2105.oving_5_backend.models;

public class Calculations {
    private long id;
    private String firstNumber;
    private String operator;
    private String secondNumber;
    private String calculation;

    public Calculations() {

    }

    public Calculations(long id, String firstNumber, String operator, String secondNumber, String calculation) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.operator = operator;
        this.secondNumber = secondNumber;
        this.calculation = calculation;

    }

    public Calculations(String firstNumber, String operator, String secondNumber, String calculation) {
        this.firstNumber = firstNumber;
        this.operator = operator;
        this.secondNumber = secondNumber;
        this.calculation = calculation;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    @Override
    public String toString() {
        return "Calculations [id=" + id + ", firstNumber=" + firstNumber + ", operator=" + operator +
                ", secondNumber=" + secondNumber + ", calculation="+ calculation + "]";
    }
}
