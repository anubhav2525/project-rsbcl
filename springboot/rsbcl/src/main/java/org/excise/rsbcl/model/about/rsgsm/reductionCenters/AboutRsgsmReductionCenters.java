package org.excise.rsbcl.model.about.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_reductionCenters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmReductionCenters {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String district;
    private Integer feedingDepots;
    private Integer productionCapacity;
}
