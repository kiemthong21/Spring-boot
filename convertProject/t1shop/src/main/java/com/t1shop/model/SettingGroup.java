package com.t1shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settings_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SettingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupid;
    @Column
    private String groupName;
    @OneToMany(mappedBy = "group")
    private List<Setting> settings = new ArrayList<>();
}
