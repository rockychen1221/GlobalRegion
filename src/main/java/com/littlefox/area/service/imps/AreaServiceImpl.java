package com.littlefox.area.service.imps;

import com.littlefox.area.dao.AreaMapper;
import com.littlefox.area.model.Area;
import com.littlefox.area.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<Area> selectAreaList(String id, String level, String langType) {

        Map<String, String> params = new HashMap<String, String>(4){{
            put("id", id);
            put("len", String.valueOf(id.length()));
            put("level", level);
            put("langType", langType);
        }};

        return areaMapper.selectAreaList(params);
    }
}
