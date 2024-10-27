package com.hussi.usecases;

import com.hussi.domain.BillingPeriod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BillingPeriodService {
    private final Map<String, BillingPeriod> billingPeriods;

//    public BillingPeriodService() {
//        this.billingPeriods = new HashMap<>();
//    }

    public void generateBillingPeriodsForYear(int year) {
        int periodId = 1;
        LocalDate monthStart = LocalDate.of(year, 1, 1);

        // Generate billing periods for each month in the specified year
        while (monthStart.getYear() == year) {
            LocalDate firstDayOfMonth = monthStart.withDayOfMonth(1);
            LocalDate nextMonth = firstDayOfMonth.plusMonths(1);

            // Add weekly billing periods starting from Saturday
            while (monthStart.isBefore(nextMonth)) {
                LocalDate periodStart = monthStart.with(DayOfWeek.SATURDAY);
                LocalDate periodEnd = periodStart.plusDays(6);

                if (periodEnd.getMonthValue() != monthStart.getMonthValue()) {
                    periodEnd = nextMonth.minusDays(1); // Adjust to end of the month
                }

                String billingId = String.format("%d-%d", year, periodId);
                billingPeriods.put(billingId, BillingPeriod.builder()
                        .billingId(billingId)
                        .from(periodStart)
                        .to(periodEnd)
                        .build());

                periodId++;
                monthStart = periodEnd.plusDays(1); // Move to the next period start
            }

            monthStart = nextMonth; // Move to the next month
        }
    }
}
