package org.excise.rsbcl.model.sales.countryLiquor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales_countryLiquor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesCountryLiquor {
    @Id
    public ObjectId _id;
    public String district;
    public Double up40;
    public Double up50;
    public Double up5;
    public Double total;
    public String category;
    public int year;
}
