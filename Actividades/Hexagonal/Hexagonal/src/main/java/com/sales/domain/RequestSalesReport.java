package com.sales.domain;
import java.time.LocalDate;

public class RequestSalesReport {
    private final LocalDate start;
    private final LocalDate end;
    public RequestSalesReport(LocalDate start, LocalDate end){
        this.start = start;
        this.end = end;
    }
    public SalesReport produce(SalesReporting reporting){
        return reporting.reportForPeriod(start, end);
    }
}