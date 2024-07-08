package org.excise.rsbcl.model.revenue.beer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "revenue_beer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueBeer {
    @Id
    private ObjectId id;
    private String district;
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double total;
    private int year;
}
