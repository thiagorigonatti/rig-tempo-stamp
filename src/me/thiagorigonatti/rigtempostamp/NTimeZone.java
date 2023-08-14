package me.thiagorigonatti.rigtempostamp;

import java.util.TimeZone;

public class NTimeZone {

    public static final NTimeZone SP = new NTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
    public static final NTimeZone UTC = new NTimeZone(TimeZone.getTimeZone("UTC"));
    final TimeZone timeZone;

    NTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
