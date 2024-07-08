package org.excise.rsbcl.model.revenue.countryLiquor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "revenue_countryLiquor")
public class RevenueCountryLiquor {
    @Id
    private ObjectId _id;
    private String district;
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double total;
    private int year;
}
