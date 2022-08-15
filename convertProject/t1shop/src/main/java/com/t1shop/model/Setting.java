package com.t1shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingid;
    @Column(name = "setting_name")
    private String settingName;
    @Column(name = "ordinal")
    private Integer order;
    @Column(name = "`status`")
    private Boolean statuss;
    @ManyToOne
    @JoinColumn(name = "groupby")
    private SettingGroup group;

    @OneToMany(mappedBy = "roles")
    private List<User> user = new ArrayList<>();

    @OneToMany(mappedBy = "productCategory")
    private List<Product> product = new ArrayList<>();

}
