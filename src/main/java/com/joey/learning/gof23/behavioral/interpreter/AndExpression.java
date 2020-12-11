package com.joey.learning.gof23.behavioral.interpreter;

public class AndExpression extends Expression {
    private Expression e1 = null;
    private Expression e2 = null;

    public AndExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    /**
     * 给定的 context 需要同时满足 e1 和 e2
     *
     * @param context
     * @return
     */
    @Override
    public boolean interpret(String context) {
        return e1.interpret(context) && e2.interpret(context);
    }
}
