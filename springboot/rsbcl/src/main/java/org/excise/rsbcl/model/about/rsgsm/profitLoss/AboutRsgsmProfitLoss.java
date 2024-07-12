package org.excise.rsbcl.model.about.rsgsm.profitLoss;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_profitLoss")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmProfitLoss {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String year;
    private Double sugarFactory;
    private Double distillery;
    private Double total;
}
