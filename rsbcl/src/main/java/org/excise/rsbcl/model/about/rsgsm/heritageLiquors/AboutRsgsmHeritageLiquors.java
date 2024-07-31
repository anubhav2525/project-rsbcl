package org.excise.rsbcl.model.about.rsgsm.heritageLiquors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about_rsgsm_heritageLiquors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmHeritageLiquors {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private int sno;
    private String category;
    private String brand;
    private String ingredients;
    private String packaging;
    private String exDistilleryPrice;
}
