package org.excise.rsbcl.model.about.rsgsm.sugarDivision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "about_rsgsm_sugarDivision")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmSugarDivision {
    @Id
    private ObjectId id;
    private int sno;
    private String year;
    private Double caneCrushed;
    private Integer days;
    private Double recovery;
    private Double sugarProduction;
    private Double electricityExport;  // Use Double to handle null values
    private Double rectifiedSpirit;
    private LocalDateTime lastUpdate;
}
