package com.sales.domain;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository {
    List<Sale> allWithinDateRange(LocalDate start, LocalDate end);
}