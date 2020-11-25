package com.example.developer.mode.InterpretMode;

public class AdditionExpresstion extends OperatorExpression {
    public AdditionExpresstion(ArithmeticExpression arithExp1, ArithmeticExpression arithExp2) {
        super(arithExp1, arithExp2);
    }


    @Override
    public int interpret() {
        return arithExp1.interpret() + arithExp2.interpret();
    }
}
