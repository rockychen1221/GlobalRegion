package com.littlefox.area;

import com.littlefox.area.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Resource
    private AreaService areaService;

    @Test
    public void select() {

    }

}
