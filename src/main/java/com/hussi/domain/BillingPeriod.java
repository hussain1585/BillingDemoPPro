package com.hussi.domain;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BillingPeriod {
    @Pattern(regexp = "\\d{4}-(5[0-2]|[1-4]?\\d)")
    private String billingId;
    private LocalDate from;
    private LocalDate to;
}
