package com.hawk.mvc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawk.mvc.beans.Area;
import com.hawk.mvc.mpper.AreaMapper;
import com.hawk.mvc.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-08 17:27
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@Service("areaService")
public class AreaServiceImpl implements AreaService {
    @Resource
    AreaMapper areaMapper;
    @Override
    public int addArea(Area area) {
        return areaMapper.insert(area);
    }

    @Override
    public int deleteById(int areaId) {
        return areaMapper.deleteById(areaId);
    }

    @Override
    public int updateById(int areaId) {
        Area area = areaMapper.selectById(areaId);
        area.setAreaName("信阳");
        area.setCityCode("XinYang");
        area.setAddress("河南省信阳市");
        return areaMapper.updateById(area);
    }

    @Override
    public List<Area> selectArea(int areaId) {
        QueryWrapper<Area> condition = new QueryWrapper<>();
        condition.eq("area_Id",areaId);
        condition.eq("area_name","济南");
        condition.notLike("area_name","南");
       // condition.orderByDesc("area_id");
        condition.orderByDesc(new String[]{"area_id","address"});
        return  areaMapper.selectList(condition);
    }

    @Override
    public IPage selectAreaPage(Integer page, Integer rows) {
        IPage<Area>  p = new Page<Area>(page,rows);
        QueryWrapper<Area> condition = new QueryWrapper<>();
        IPage pageResult = areaMapper.selectPage(p,condition);
        return pageResult;
    }

    @Override
    public IPage<Map> selectAreaMap(Integer page, Integer rows) {
        return areaMapper.selectAreaMap(new Page(page,rows));
    }

}
