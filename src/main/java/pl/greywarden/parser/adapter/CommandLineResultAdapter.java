package pl.greywarden.parser.adapter;

public class CommandLineResultAdapter extends ResultAdapter<Object> {
    @Override
    public void info(Object result) {
        System.out.println("Result: " + result);
    }

    @Override
    public <E extends Throwable> void error(E message) {
        System.err.println(message.getMessage());
    }
}
