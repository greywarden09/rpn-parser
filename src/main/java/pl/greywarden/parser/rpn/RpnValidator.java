package pl.greywarden.parser.rpn;

import lombok.NonNull;
import pl.greywarden.parser.error.RpnValidationException;

import static pl.greywarden.parser.rpn.Operators.isOperator;

public class RpnValidator {
    public void validateRpn(@NonNull String[] tokens) {
        int counter = 0;
        for (String token : tokens) {
            if (isNumber(token)) {
                ++counter;
            } else if (isOperator(token)) {
                counter -= 2;
                if (counter < 0) {
                    throw new RpnValidationException(tokens);
                }
                ++counter;
            } else {
                throw new RpnValidationException(tokens);
            }
        }
        if (counter != 1) {
            throw new RpnValidationException(tokens);
        }
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
