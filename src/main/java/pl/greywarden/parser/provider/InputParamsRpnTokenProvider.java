package pl.greywarden.parser.provider;

import java.util.Optional;

public class InputParamsRpnTokenProvider extends RpnTokenProvider<String[]> {
    @Override
    public String[] getTokens(String[] source) {
        return Optional.ofNullable(source).orElseThrow(() -> new IllegalArgumentException("Input must not be null"));
    }
}
