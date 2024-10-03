package com.sansam.team.common.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

    /* 넘어온 endDate로부터 오늘까지의 일 반환 */
    public static long getPeriodDate(LocalDateTime endDate) {
        return ChronoUnit.DAYS.between(endDate, LocalDateTime.now());
    }

    /* 오늘이 몇 주 전인지 구함 - week가 2일 경우 오늘이 startDate로부터 2주 전인지 */
    public static boolean isBeforeWeek(LocalDateTime startDate, int week) {
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusWeeks(week);

        return nowDate.isBefore(endDate);
    }

    public static boolean isBetweenDateTime(LocalDateTime startDate, LocalDateTime endDate) {
        LocalDateTime nowDate = LocalDateTime.now();

        return startDate.isBefore(nowDate) && endDate.isAfter(nowDate);
    }

}
