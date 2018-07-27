package kon.blats;

import java.time.*;

public class App {
    public static void main(String[] args) {
        String desiredCutOffTime = "01:30";
        int desiredHour = Integer.parseInt(desiredCutOffTime.split(":")[0]);
        int desiredMinutes = Integer.parseInt(desiredCutOffTime.split(":")[1]);

        ZonedDateTime utcZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime bspTimeNow = utcZonedDateTime.withZoneSameInstant(ZoneId.of("+8"));

        int hourNowInBsp = bspTimeNow.getHour();
        int minuteNowInBsp = bspTimeNow.getMinute();

        boolean isPositiveHoursDiff = desiredHour - hourNowInBsp > 0;
        LocalTime bspTime = LocalTime.of(hourNowInBsp, minuteNowInBsp);
        LocalTime desiredTime = LocalTime.of(desiredHour, desiredMinutes);

        long secondsToCutOff;
        if (isPositiveHoursDiff) {
            secondsToCutOff = Duration.between(bspTime, desiredTime).getSeconds();
        } else {
            long maxDiff = Duration.between(bspTime, LocalTime.MAX).getSeconds();
            long midnightDiff = Duration.between(LocalTime.MIDNIGHT, desiredTime).getSeconds();
            secondsToCutOff = midnightDiff + maxDiff;
        }
        System.out.println(secondsToCutOff);

    }
}
