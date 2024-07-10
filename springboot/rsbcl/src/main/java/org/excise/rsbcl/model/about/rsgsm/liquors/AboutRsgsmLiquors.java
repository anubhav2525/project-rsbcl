package org.excise.rsbcl.model.about.rsgsm.liquors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "about_rsgsm_liquors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AboutRsgsmLiquors {
    private ObjectId id;
    private String liquorCategory;
    private String subCategory;
    private List<Integer> packagingSize;
    private String year;
}
