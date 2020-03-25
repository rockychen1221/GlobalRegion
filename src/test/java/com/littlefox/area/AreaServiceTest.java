package com.littlefox.area;

import com.littlefox.area.model.Area;
import com.littlefox.area.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Test
 * @author rockychen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Resource
    private AreaService areaService;

    @Test
    public void zh() {
        List<Area> areas =  areaService.selectAreaList("", "0", "zh_CN");
        areas.forEach(a-> System.out.println(a.toString()));
    }

    @Test
    public void en() {
        List<Area> areas =  areaService.selectAreaList("", "0", "en_US");
        areas.forEach(a-> System.out.println(a.toString()));
    }

}
