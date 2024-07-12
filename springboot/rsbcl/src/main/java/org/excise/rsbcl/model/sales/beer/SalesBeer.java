package org.excise.rsbcl.model.sales.beer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales_beer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesBeer {
    @Id
    public ObjectId _id;
    public String district;
    public Double strong;
    public Double mild;
    public Double total;
    public String category;
    public int year;
}
