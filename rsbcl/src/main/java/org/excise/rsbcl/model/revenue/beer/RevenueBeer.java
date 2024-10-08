package org.excise.rsbcl.model.revenue.beer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "revenue_beer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueBeer {
    @Id
    private ObjectId id;


    private String district;
    private Double a;
    private Double b;
    private Double c;
    private Double d;
    private Double e;
    private Double f;
    private Double total;
    private String month;
    private int year;
}
