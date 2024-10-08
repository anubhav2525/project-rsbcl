package org.excise.rsbcl.model.about.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "about_rsgsm_reductionCenters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmReductionCenters {
    @Id
    private ObjectId id;
    private int sno;
    private String district;
    private Integer feedingDepots;
    private Integer productionCapacity;
    private LocalDateTime lastUpdate;
}
