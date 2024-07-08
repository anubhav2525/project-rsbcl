package org.excise.rsbcl.model.about.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_reductionCenters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmReductionCenters {
    private ObjectId id;
    private String district;
    private Integer feedingDepots;
    private Integer productionCapacity;
}
