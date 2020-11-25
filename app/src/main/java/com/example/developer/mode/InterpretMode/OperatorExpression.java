package com.example.developer.mode.InterpretMode;

public abstract class OperatorExpression extends ArithmeticExpression{
   ArithmeticExpression arithExp1;
   ArithmeticExpression arithExp2;

    public OperatorExpression(ArithmeticExpression arithExp1, ArithmeticExpression arithExp2) {
        this.arithExp1 = arithExp1;
        this.arithExp2 = arithExp2;
    }

}
