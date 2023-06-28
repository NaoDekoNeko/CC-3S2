package com.sales.domain;

import java.time.LocalDate;

public interface SalesReporting {
    SalesReport reportForPeriod(LocalDate start, LocalDate end);
}
