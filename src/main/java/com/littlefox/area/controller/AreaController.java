package com.littlefox.area.controller;

import com.littlefox.area.model.Area;
import com.littlefox.area.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    @RequestMapping(value = "/init.do", method = RequestMethod.GET)
    public String init(){
        return "area/index";
    }


    /**
     * 查询国家省份地区下拉
     *
     * @param request HttpServletRequest
     * @param model   Model
     * @param areaId  区域ID，level为0时可以为空
     * @param level   区域的级别，标注国家、省份、地区、城市等
     * @return List<ProvinceDepend>
     */
    @RequestMapping(value = "/selectAreaList.json", method = RequestMethod.POST)
    @ResponseBody
    public List<Area> selectAreaList( @ModelAttribute("areaId") String areaId, @ModelAttribute("level") String level) {
        String langType = "zh_CN";
        List<Area> areaList = areaService.findProvinceListByIdAndCountry(areaId, level, langType);
        return areaList;
    }


}
