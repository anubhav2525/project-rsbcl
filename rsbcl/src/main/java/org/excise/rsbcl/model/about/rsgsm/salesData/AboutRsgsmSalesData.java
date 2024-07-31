package org.excise.rsbcl.model.about.rsgsm.salesData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_salesData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmSalesData {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String year;
    private ProductionDetails ownManufactured;
    private ProductionDetails others;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductionDetails {
        private Double countryLiquor;
        private Double rajasthanMadeLiquor;
        private Double total;
    }
}
