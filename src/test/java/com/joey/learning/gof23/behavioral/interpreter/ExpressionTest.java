package com.joey.learning.gof23.behavioral.interpreter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ExpressionTest {
    private static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("A");
        Expression terminal2 = new TerminalExpression("B");
        Expression terminal3 = new TerminalExpression("C");
        Expression terminal4 = new TerminalExpression("D");
        Expression alternation1 = new OrExpression(terminal2, terminal3); // B or C
        Expression alternation2 = new OrExpression(terminal1, alternation1); // A or (B or C)
        return new AndExpression(terminal4, alternation2); // D and (A or (B or C))
    }

    @Test
    void interpret() {
        Expression pattern = buildInterpreterTree();
        String context1 = "D A C";
        String context2 = "A B";
        log.info("{}", pattern.interpret(context1));
        log.info("{}", pattern.interpret(context2));
    }
}