package com.safarsathi.backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer packageId;
    private String packageName;
    @Column(length = 2000)
    private  String description;
    private Integer packageDiscountedPrice;
    private Integer packageActualPrice;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "package_image",
        joinColumns = {
            @JoinColumn(name = "package_id")
    },
        inverseJoinColumns = {
            @JoinColumn(name = "image_id")
        }
    )
    private Set<ImageModel> packageImage;

    public Set<ImageModel> getPackageImage() {
        return packageImage;
    }

    public void setPackageImage(Set<ImageModel> packageImage) {
        this.packageImage = packageImage;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPackageDiscountedPrice() {
        return packageDiscountedPrice;
    }

    public void setPackageDiscountedPrice(Integer packageDiscountedPrice) {
        this.packageDiscountedPrice = packageDiscountedPrice;
    }

    public Integer getPackageActualPrice() {
        return packageActualPrice;
    }

    public void setPackageActualPrice(Integer packageActualPrice) {
        this.packageActualPrice = packageActualPrice;
    }
}
