package org.excise.rsbcl.model.about.rsgsm.futurePlans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_futurePlans")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AboutRsgsmFuturePlans {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String brandName;
}
