package pl.greywarden.parser.adapter;

public abstract class ResultAdapter<T> {
    public abstract void info(T result);
    public abstract <E extends Throwable> void error(E message);
}
