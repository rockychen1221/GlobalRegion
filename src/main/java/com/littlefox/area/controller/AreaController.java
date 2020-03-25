package com.littlefox.area.controller;

import com.littlefox.area.model.Area;
import com.littlefox.area.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地区Controller
 * @author rockychen
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    /**
     * 查询国家省份地区下拉
     *
     * @param areaId  区域ID，level为0时可以为空
     * @param level   区域的级别，标注国家、省份、地区、城市等
     * @return List<Area>
     */
    @RequestMapping(value = "/selectAreaList.json", method = RequestMethod.POST)
    @ResponseBody
    public List<Area> selectAreaList( @ModelAttribute("areaId") String areaId, @ModelAttribute("level") String level) {
        String langType = "zh_CN";
        return areaService.selectAreaList(areaId, level, langType);
    }

}
