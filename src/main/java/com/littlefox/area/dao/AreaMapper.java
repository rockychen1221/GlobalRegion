
package com.littlefox.area.dao;

import com.littlefox.area.model.Area;

import java.util.List;
import java.util.Map;

/**
 * 地区Mapper
 * @author rockychen
 */
public interface AreaMapper {

    /**
     * 根据省份查询市
     * @param params {id:'省市', country:'国家',langType:'zh_CN'}
     * @return ProvinceDepend
     */
    List<Area> selectAreaList(Map<String, String> params);

}
