package pl.greywarden.parser.rpn;

import java.util.ArrayDeque;
import java.util.Deque;

public class RpnParser {
    public double calculateResult(String[] tokens) {
        Deque<Double> result = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                result.push(Double.valueOf(token));
            } else if (isOperator(token)) {
                Double x = result.pop();
                Double y = result.pop();
                result.push(Operators.performOperation(y, x, token));
            }
        }
        return result.pop();
    }

    private boolean isOperator(String token) {
        return Operators.isOperator(token);
    }

    private boolean isNumber(String token) {
        try {
            Double.valueOf(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
