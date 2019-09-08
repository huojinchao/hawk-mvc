package com.hawk.mvc.controller;

import com.hawk.mvc.beans.Area;
import com.hawk.mvc.mpper.AreaMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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
    private AreaMapper areaMapper;
    @GetMapping("/all")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("/area");
        List<Area> areas = areaMapper.findAll();
        modelAndView.addObject("areas",areas);
        return modelAndView;
    }
}
