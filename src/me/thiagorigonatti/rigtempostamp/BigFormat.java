package me.thiagorigonatti.rigtempostamp;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BigFormat {

    static String formatTypes(Locale locale, ZonedDateTime zonedDateTime) {

        DateTimeFormatter dateTimeFormatter;

        switch (locale.toLanguageTag()) {
            case "en-US":
                dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, y h:mm:ss a z 'GMT'XXX", locale);
                break;
            case "pt-BR":
                dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' y HH:mm:ss z 'GMT'XXX", locale);
                break;
            default:
                return "Locale: \"".concat(locale.toLanguageTag().concat("\"")).concat(" not supported when using BigFormat, use pattern instead.");
        }
        return dateTimeFormatter.format(zonedDateTime)
                .replaceAll("AM", "am")
                .replaceAll("PM", "pm");
    }
}

