import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit

class Gigasecond {

    static Long gigasec = 1_000_000_000L

    static LocalDateTime add(LocalDate moment) {
        add(moment.atStartOfDay())
    }

    static LocalDateTime add(LocalDateTime moment) {
        // Original
        //LocalDateTime.ofEpochSecond(moment.toEpochSecond(ZoneOffset.UTC) + gigasec, 0, ZoneOffset.UTC)

        // Based on community solutions
        moment.plus(gigasec, ChronoUnit.SECONDS)
    }
}
