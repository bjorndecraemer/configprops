package com.bjornspetprojects.configprops.configprops.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GhelamcoDbPropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "prop_name")
    private String propertyName;
    @Column(name = "prop_val")
    private String propertyValue;
    @Column(name = "prop_type")
    private String propertyType;
    @Column(name = "prop_desc")
    private String propertyDescription;
}
