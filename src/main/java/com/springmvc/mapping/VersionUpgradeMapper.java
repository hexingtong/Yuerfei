package com.springmvc.mapping;

import com.springmvc.pojo.VersionUpgrade;

import java.util.List;

public interface VersionUpgradeMapper {


    List<VersionUpgrade> selectVersionAll();
}
