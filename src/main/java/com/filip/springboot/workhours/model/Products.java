package com.filip.springboot.workhours.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document(collection = "products")
public class Products {

    @Id
    private String id;
    private String prodName;
    private String prodDesc;
    private Double prodPrice;
    private String prodImage;

    public Products() {
    }

    public Products(String prodName, String prodDesc, Double prodPrice, String prodImage) {
        super();
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodImage = prodImage;
    }

}
