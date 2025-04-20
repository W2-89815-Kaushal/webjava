package com.sunbeam;

public class Arithmetic {
    private int num1;
    private int num2;

    public Arithmetic() {}

    public Arithmetic(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Getters and setters
    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }

    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }

    // Business logic methods
    public int add() {
        return num1 + num2;
    }

    public int subtract() {
        return num1 - num2;
    }

    public int multiply() {
        return num1 * num2;
    }

    public int divide() {
        return num2 != 0 ? num1 / num2 : 0;
    }
}
