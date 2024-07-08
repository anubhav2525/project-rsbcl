package org.excise.rsbcl.model.about.rsgsm.turnOverProfit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_turnOverProfit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmTurnOverProfit {
    @Id
    private ObjectId id;
    private String year;
    private Double profit;
    private Double turnover;
}
