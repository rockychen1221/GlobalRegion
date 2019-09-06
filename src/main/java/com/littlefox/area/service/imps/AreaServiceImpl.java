package com.littlefox.area.service.imps;

import com.littlefox.area.dao.AreaMapper;
import com.littlefox.area.model.Area;
import com.littlefox.area.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;


    @Override
    public List<Area> findProvinceListByIdAndCountry(String id, String level, String langType) {
        return null;
    }
}
