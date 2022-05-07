package com.sight.application.app.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static LocalDateTime getRandomDateTime(LocalDate dateStart, LocalDate dateEnd) {

        // [random date]
        long minDay = dateStart.toEpochDay();
        long maxDay = dateEnd.toEpochDay();

        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        // [random time]
        int startSeconds = LocalTime.of(0, 0).toSecondOfDay();
        int endSeconds = LocalTime.of(23, 59).toSecondOfDay();
        int randomTimeSecond = ThreadLocalRandom
                .current()
                .nextInt(startSeconds, endSeconds);
        LocalTime randomTime = LocalTime.ofSecondOfDay(randomTimeSecond);

        return LocalDateTime.of(randomDate, randomTime);
    }
}
