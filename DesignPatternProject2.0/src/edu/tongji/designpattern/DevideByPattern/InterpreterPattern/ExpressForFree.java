package edu.tongji.designpattern.DevideByPattern.InterpreterPattern;

public class ExpressForFree {
    private Expression name = new Terminals("java");
    private Expression gender = new Terminals("man");
    private AndExpression expr = new AndExpression(name,gender);
    private String context = null;
    public ExpressForFree(String context){
        this.context = context;
    }

    public boolean isFree(){
        return expr.interpret(this.context);
    }

}
