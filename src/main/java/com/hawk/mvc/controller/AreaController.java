package com.hawk.mvc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hawk.mvc.beans.Area;
import com.hawk.mvc.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-07 20:49
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@Controller
@RequestMapping("/area")
public class AreaController {
    @Resource
    private AreaService areaService;
    @GetMapping("/add")
    @ResponseBody
    public String addArea(){
        Area area = new Area();
        area.setAreaName("济南");
        area.setCityCode("JiNan");
        area.setAddress("中国山东济南市");
        int flg = areaService.addArea(area);
        if(flg>0){
            return "success";
        }
        return "error";
    }



    @GetMapping("/delete/{areaId}")
    @ResponseBody
    public String deleteArea(@PathVariable("areaId")int areaId){
        int flg = areaService.deleteById(areaId);
        if(flg>0){
            return "success";
        }
        return "error";
    }

    @GetMapping("/update/{areaId}")
    @ResponseBody
    public String updateArea(@PathVariable("areaId")int areaId){
        int flg = areaService.updateById(areaId);
        if(flg>0){
            return "success";
        }
        return "error";
    }

    @GetMapping("/select/{areaId}")
    @ResponseBody
    public List<Area> selectArea(@PathVariable("areaId")int areaId){
        List<Area> areas = areaService.selectArea(areaId);
        return  areas;
    }

    @GetMapping("/page/{page}/{rows}")
    @ResponseBody
    public  Map<String,Object> selectPage(@PathVariable("page")int page,@PathVariable("rows")int rows){
        IPage iPage = areaService.selectAreaPage(page,rows);
        long total = iPage.getTotal();
        long pages = iPage.getPages();
        List<Area> areas = iPage.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("pages",pages);
        map.put("areas",areas);
        return  map;
    }

    @GetMapping("/page1/{page}/{rows}")
    @ResponseBody
    public  IPage selectPage1(@PathVariable("page")int page,@PathVariable("rows")int rows){
        IPage iPage = areaService.selectAreaPage(page,rows);
        return  iPage ;
    }

    @GetMapping("/page2/{page}/{rows}")
    @ResponseBody
    public  IPage<Map> selectPage2(@PathVariable("page")int page,@PathVariable("rows")int rows){
        IPage<Map> iPage = areaService.selectAreaMap(page,rows);
        return  iPage ;
    }
}
