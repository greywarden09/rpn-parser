package pl.greywarden.parser;

import pl.greywarden.parser.adapter.CommandLineResultAdapter;
import pl.greywarden.parser.adapter.ResultAdapter;
import pl.greywarden.parser.provider.InputParamsRpnTokenProvider;
import pl.greywarden.parser.provider.RpnTokenProvider;
import pl.greywarden.parser.rpn.RpnParser;
import pl.greywarden.parser.rpn.RpnValidator;

public class Main {
    public static void main(String... args) {
        RpnParser parser = new RpnParser();
        RpnValidator validator = new RpnValidator();
        RpnTokenProvider<String[]> tokenProvider = new InputParamsRpnTokenProvider();
        ResultAdapter<Object> adapter = new CommandLineResultAdapter();

        ApplicationInitializer applicationInitializer = new ApplicationInitializer(parser, validator, tokenProvider, adapter);
        applicationInitializer.run(args);
    }
}
