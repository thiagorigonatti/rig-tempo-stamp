package me.thiagorigonatti.rigtempostamp;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RigTempoStamp {

    private final Locale locale;

    public RigTempoStamp(NLocale locale) {
        this.locale = locale.locale;
    }

    public RigTempoStamp(Locale locale) {
        this.locale = locale;
    }

    public String format(Instant instant, String pattern) {
        return format(ZonedDateTime.from(instant.atZone(ZoneId.systemDefault())), pattern);
    }

    public String format(String datetime, ZoneId zoneId, String pattern) {
        return format(ZonedDateTime.of(LocalDateTime.parse(datetime), zoneId), pattern);
    }

    public String format(String datetime, ZoneId zoneId, FORMAT format) {
        return format(ZonedDateTime.of(LocalDateTime.parse(datetime), zoneId), format);
    }

    public String format(ZonedDateTime zonedDateTime, String pattern) {

        String weekDayNameShort = DateTimeFormatter.ofPattern("E", locale).format(zonedDateTime);
        String weekDayName = DateTimeFormatter.ofPattern("EEEE", locale).format(zonedDateTime);
        String monthDay1Digit = DateTimeFormatter.ofPattern("d", locale).format(zonedDateTime);
        String monthDay2Digits = DateTimeFormatter.ofPattern("dd", locale).format(zonedDateTime);
        String month1Digit = DateTimeFormatter.ofPattern("M", locale).format(zonedDateTime);
        String month2Digits = DateTimeFormatter.ofPattern("MM", locale).format(zonedDateTime);
        String monthNameShort = DateTimeFormatter.ofPattern("MMM", locale).format(zonedDateTime);
        String monthName = DateTimeFormatter.ofPattern("MMMM", locale).format(zonedDateTime);
        String yearShort = DateTimeFormatter.ofPattern("yy", locale).format(zonedDateTime);
        String year = DateTimeFormatter.ofPattern("y", locale).format(zonedDateTime);
        String hours1Digit = DateTimeFormatter.ofPattern("H", locale).format(zonedDateTime);
        String hours2Digits = DateTimeFormatter.ofPattern("HH", locale).format(zonedDateTime);
        String minutes1Digit = DateTimeFormatter.ofPattern("m", locale).format(zonedDateTime);
        String minutes2Digits = DateTimeFormatter.ofPattern("mm", locale).format(zonedDateTime);
        String seconds1Digit = DateTimeFormatter.ofPattern("s", locale).format(zonedDateTime);
        String seconds2Digits = DateTimeFormatter.ofPattern("ss", locale).format(zonedDateTime);
        String amPm = DateTimeFormatter.ofPattern("a", locale).format(zonedDateTime);
        String zoneId = DateTimeFormatter.ofPattern("z", locale).format(zonedDateTime);

        return pattern
                .replaceAll("<dddd>", weekDayName)
                .replaceAll("<ddd>", weekDayNameShort)
                .replaceAll("<dd>", monthDay2Digits)
                .replaceAll("<d>", monthDay1Digit)
                .replaceAll("<MMMM>", monthName)
                .replaceAll("<MMM>", monthNameShort)
                .replaceAll("<MM>", month2Digits)
                .replaceAll("<M>", month1Digit)
                .replaceAll("<YYYY>|<yyyy>", year)
                .replaceAll("<YY>|<yy>", yearShort)
                .replaceAll("<HH>", hours2Digits)
                .replaceAll("<H>", hours1Digit)
                .replaceAll("<mm>", minutes2Digits)
                .replaceAll("<m>", minutes1Digit)
                .replaceAll("<ss>", seconds2Digits)
                .replaceAll("<s>", seconds1Digit)
                .replaceAll("<ampm>", amPm
                        .replaceAll("AM", "am")
                        .replaceAll("PM", "pm"))
                .replaceAll("<AMPM>", amPm)
                .replaceAll("<z>", zoneId);
    }

    public String format(ZonedDateTime zonedDateTime, FORMAT format) {

        switch (format) {
            case TINY:
                return TinyFormat.formatTypes(locale, zonedDateTime);
            case SMALL:
                return SmallFormat.formatTypes(locale, zonedDateTime);
            case NORMAL:
                return NormalFormat.formatTypes(locale, zonedDateTime);
            case BIG:
                return BigFormat.formatTypes(locale, zonedDateTime);
            case EXTENDED:
                return ExtendedFormat.formatTypes(locale, zonedDateTime);
            default:
                return "error";
        }
    }


    public enum FORMAT {
        TINY, SMALL, NORMAL, BIG, EXTENDED
    }
}
