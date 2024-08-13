package org.excise.rsbcl.model.about.rsgsm.financialStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "about_rsgsm_financialStatus")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AboutRsgsmFinancialStatus {
    @Id
    private ObjectId id;
    private int sno;
    private String year;
    private Double revenue;
    private Double expenditure;
    private Double profitLoss;
    private LocalDateTime lastUpdate;
}
