package pl.greywarden.parser;

import lombok.RequiredArgsConstructor;
import pl.greywarden.parser.adapter.ResultAdapter;
import pl.greywarden.parser.error.RpnValidationException;
import pl.greywarden.parser.provider.RpnTokenProvider;
import pl.greywarden.parser.rpn.RpnParser;
import pl.greywarden.parser.rpn.RpnValidator;

@RequiredArgsConstructor
public class ApplicationInitializer {
    private final RpnParser parser;
    private final RpnValidator validator;
    private final RpnTokenProvider<String[]> tokenProvider;
    private final ResultAdapter<Object> resultAdapter;

    public void run(String... args) {
        String[] rpn = tokenProvider.getTokens(args);
        try {
            validator.validateRpn(rpn);
            double result = parser.calculateResult(rpn);
            resultAdapter.info(result);
        } catch (RpnValidationException e) {
            resultAdapter.error(e);
        }
    }
}
