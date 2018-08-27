package pl.greywarden.parser.error;

import java.util.Arrays;

public class RpnValidationException extends RuntimeException {
    public RpnValidationException(String[] tokens) {
        super("RPN expression is invalid: " + Arrays.toString(tokens));
    }
}
