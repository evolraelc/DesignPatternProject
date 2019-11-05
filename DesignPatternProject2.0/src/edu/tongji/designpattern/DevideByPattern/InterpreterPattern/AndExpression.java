package edu.tongji.designpattern.DevideByPattern.InterpreterPattern;

public class AndExpression implements Expression {

    private Expression expression1 = null;
    private Expression expression2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expression1 = expr1;
        this.expression2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return this.expression1.interpret(context) && this.expression2.interpret(context);
    }
}