package pl.greywarden.parser.rpn;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Operators {
    private static final Map<String, BiFunction<Double, Double, Double>> operators;
    static {
        operators = new HashMap<>();
        operators.put("+", (x, y) -> x + y);
        operators.put("-", (x, y) -> x - y);
    }

    public static boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    public static Double performOperation(Double y, Double x, String token) {
        return operators.get(token).apply(y, x);
    }
}
