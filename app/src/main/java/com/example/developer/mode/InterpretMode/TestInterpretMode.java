package com.example.developer.mode.InterpretMode;

import android.util.Log;

import java.util.Stack;

public class TestInterpretMode {
    private static final String TAG="TestInterpretMode";
    String expression = "1 + 2 + 3 + 4";
    Stack<ArithmeticExpression> mStack = new Stack<ArithmeticExpression>();

    public void caculate(){
        String[] strArray = expression.split(" ");
        for(int i=0;i<strArray.length;i++){
            Log.d(TAG," i= " + i + " value: "+strArray[i]);
            switch (strArray[i].charAt(0)){
                case '+':
                    ArithmeticExpression expression = mStack.pop();
                    AdditionExpresstion additionExpresstion = new AdditionExpresstion(expression,new NumExpression(Integer.valueOf(strArray[++i])));
                    break;
                default:
                    NumExpression numExpression = new NumExpression(Integer.valueOf(strArray[i]));
                    mStack.push(numExpression);
            }
        }
    }
}
