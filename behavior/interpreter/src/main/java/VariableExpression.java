import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VariableExpression implements Expression {

    private Object lookup;
    private String methodName;

    public VariableExpression(Object lookup, String methodName) {
        this.lookup = lookup;
        this.methodName = methodName;
    }

    public void interpret(Context c) {
        try{
            Object source = c.get(lookup);
            if(source != null){
                Method method = source.getClass().getMethod(methodName, null);
                Object result = method.invoke(source, null);
                c.addVariable(this, result);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exc){

        }
    }
}
