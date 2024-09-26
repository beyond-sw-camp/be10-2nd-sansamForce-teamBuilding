package sansam.team.common.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

    /* 넘어온 endDate로부터 오늘까지의 일 반환 */
    public static long getPeriodDate(LocalDateTime endDate) {
        return ChronoUnit.DAYS.between(endDate, LocalDateTime.now());
    }

    public static boolean isBetweenDateTime(LocalDateTime startDate, LocalDateTime endDate) {
        LocalDateTime nowDate = LocalDateTime.now();

        return startDate.isAfter(nowDate) && endDate.isBefore(nowDate);
    }

}
