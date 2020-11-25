package com.example.developer.mode.InterpretMode;

public class NumExpression extends ArithmeticExpression {
    int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}
