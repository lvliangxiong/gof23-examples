package com.joey.learning.gof23.behavioral.interpreter;

import java.util.StringTokenizer;

public class TerminalExpression extends Expression {
    private String literal = null;

    public TerminalExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(literal)) return true;
        }
        return false;
    }
}
