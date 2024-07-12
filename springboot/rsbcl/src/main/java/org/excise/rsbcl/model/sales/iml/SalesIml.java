package org.excise.rsbcl.model.sales.iml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales_iml")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesIml {
    @Id
    public ObjectId _id;
    public String district;
    public Double whisky;
    public Double rum;
    public Double vodka;
    public Double gin;
    public Double wine;
    public Double heritage;
    public Double brandy;
    public Double rtd;
    public Double scotch;
    public Double other;
    public Double total;
    public String category;
    public int year;
}
