package me.thiagorigonatti.rigtempostamp;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExtendedFormat {

    static String formatTypes(Locale locale, ZonedDateTime zonedDateTime) {

        DateTimeFormatter dateTimeFormatter;

        switch (locale.toLanguageTag()) {
            case "en-US":
                dateTimeFormatter = DateTimeFormatter.ofPattern("zzzz 'GMT'XXX EEEE, MMMM d, y, h:mm:ss.S a z", locale);
                break;
            case "pt-BR":
                dateTimeFormatter = DateTimeFormatter.ofPattern("zzzz 'GMT'XXX EEEE, dd 'de' MMMM 'de' y, HH:mm:ss.S z", locale);
                break;
            default:
                return "Locale: \"".concat(locale.toLanguageTag().concat("\"")).concat(" not supported when using ExtendedFormat, use pattern instead.");
        }
        return dateTimeFormatter.format(zonedDateTime)
                .replaceAll("AM", "am")
                .replaceAll("PM", "pm");
    }

}

