package me.thiagorigonatti.rigtempostamp;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TinyFormat {

    static String formatTypes(Locale locale, ZonedDateTime zonedDateTime) {

        DateTimeFormatter dateTimeFormatter;

        switch (locale.toLanguageTag()) {
            case "en-US":
                dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yy h:mm a", locale);
                break;
            case "pt-BR":
                dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm", locale);
                break;
            default:
                return "Locale: \"".concat(locale.toLanguageTag().concat("\"")).concat(" not supported when using TinyFormat, use pattern instead.");
        }
        return dateTimeFormatter.format(zonedDateTime)
                .replaceAll("AM", "am")
                .replaceAll("PM", "pm");


    }
}

