package com.targa.labs.myBoutique.product.domain;

import com.targa.labs.myBoutique.commons.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Department extends AbstractEntity implements Serializable {

    @Column(name = "department_name",nullable = false)
    private String depName;

    private String description;

    private String image;

    @OneToMany(mappedBy = "department")
    private List<Category> categories = new ArrayList<>();

    public Department(String depName, String description, String image) {
        this.depName = depName;
        this.description = description;
        this.image = image;
    }
}
