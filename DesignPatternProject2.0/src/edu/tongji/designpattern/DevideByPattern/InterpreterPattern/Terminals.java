package edu.tongji.designpattern.DevideByPattern.InterpreterPattern;



public class Terminals implements Expression{

    private String lexeme;

    public Terminals(String lexeme){
        this.lexeme = lexeme;
    }

    public void setLexeme(String l){
        this.lexeme = l;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(lexeme)){
            return true;
        }
        return false;
    }
}
