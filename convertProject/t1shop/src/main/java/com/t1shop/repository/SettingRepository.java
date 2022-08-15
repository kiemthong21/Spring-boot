package com.t1shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t1shop.model.Setting;
import com.t1shop.model.SettingGroup;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    // get Setting by group
   List<Setting> findByGroup(SettingGroup group);
   

}
