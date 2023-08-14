package me.thiagorigonatti.rigtempostamp;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NormalFormat {

    static String formatTypes(Locale locale, ZonedDateTime zonedDateTime) {

        DateTimeFormatter dateTimeFormatter;

        switch (locale.toLanguageTag()) {
            case "en-US":
                dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, M/d/yyyy - h:mm a z", locale);
                break;
            case "pt-BR":
                dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy - HH:mm z", locale);
                break;
            default:
                return "Locale: \"".concat(locale.toLanguageTag().concat("\"")).concat(" not supported when using NormalFormat, use pattern instead.");
        }
        return dateTimeFormatter.format(zonedDateTime)
                .replaceAll("AM", "am")
                .replaceAll("PM", "pm");
    }

}

