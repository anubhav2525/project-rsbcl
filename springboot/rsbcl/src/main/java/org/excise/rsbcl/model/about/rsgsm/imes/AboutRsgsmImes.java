package org.excise.rsbcl.model.about.rsgsm.imes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_imes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmImes {
    @Id
    private ObjectId id;
    private String work;
}
