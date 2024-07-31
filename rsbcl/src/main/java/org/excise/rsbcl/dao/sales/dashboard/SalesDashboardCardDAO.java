package org.excise.rsbcl.dao.sales.dashboard;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SalesDashboardCardDAO {
    private Double amount;
    private Double percentage;
    private String cardName;
    private LocalTime time;
    private int year;
    private String category;
}
