package pl.greywarden.parser.provider;

public abstract class RpnTokenProvider<T> {
    public abstract String[] getTokens(T source);
}
