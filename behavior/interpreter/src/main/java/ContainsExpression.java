public class ContainsExpression extends ComparisonExpression {

    public ContainsExpression(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    @Override
    public void interpret(Context c) {
        expressionA.interpret(c);
        expressionB.interpret(c);

        Object exprAresult = c.get(expressionA);
        Object exprBresult = c.get(expressionB);

        if ((exprAresult instanceof String) && (exprBresult instanceof String)) {
            if (((String)exprAresult).indexOf((String)exprBresult) != -1) {
                c.addVariable(this, Boolean.TRUE);
                return;
            }
        }
        c.addVariable(this, Boolean.FALSE);
        return;
    }
}
