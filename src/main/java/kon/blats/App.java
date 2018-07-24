package kon.blats;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.Math.abs;

public class App {
    public static void main(String[] args) {

        String desiredCutOffTime = "05:30";
        int desiredHour = Integer.parseInt(desiredCutOffTime.split(":")[0]);
        int desiredMinutes = Integer.parseInt(desiredCutOffTime.split(":")[1]);

        ZonedDateTime utcZonedDateTime = ZonedDateTime.now();
        ZonedDateTime malZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of("+12"));

        int hourNowInMalaysia = malZonedDateTime.getHour();
        int minuteNowInMalaysia = malZonedDateTime.getMinute();

        boolean isPositiveHoursDiff = desiredHour - hourNowInMalaysia > 0;
        boolean isPositiveMinutesDiff = desiredMinutes - minuteNowInMalaysia > 0;

        if (isPositiveHoursDiff && isPositiveMinutesDiff) {
            LocalTime malaisyanTime = LocalTime.of(hourNowInMalaysia, minuteNowInMalaysia);
            LocalTime desiredTime = LocalTime.of(desiredHour, desiredMinutes);
            System.out.println(Duration.between(malaisyanTime, desiredTime).getSeconds());
        } else {
            LocalTime malaisyanTime = LocalTime.of(hourNowInMalaysia, minuteNowInMalaysia);
            LocalTime desiredTime = LocalTime.of(desiredHour, desiredMinutes);

            LocalTime midnightTime = LocalTime.of(23, 59, 59, 99);
            long midnightDiff = abs(Duration.between(malaisyanTime, midnightTime).getSeconds());
            long absoluteDiff = abs(Duration.between(LocalTime.of(00, 00, 00, 00), desiredTime).getSeconds());

            long delay = absoluteDiff + midnightDiff;
        }

        Duration difference = Duration.between(utcZonedDateTime, malZonedDateTime);
    }
}
