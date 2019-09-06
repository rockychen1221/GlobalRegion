package com.littlefox.area.service;

import com.littlefox.area.model.Area;

import java.util.List;

/**
 * @author rockychen
 */
public interface AreaService {

    /**
     * 根据省份查询市
     * @param id 省市
     * @param level 层级
     * @param langType
     * @return ProvinceDepend
     */
    List<Area> findProvinceListByIdAndCountry(String id, String level, String langType);
}
