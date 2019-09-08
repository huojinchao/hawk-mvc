package com.hawk.mvc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hawk.mvc.beans.Area;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-08 17:27
 * <p>
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
public interface AreaService {
    int addArea(Area area);
    int deleteById(int areaId);
    int updateById(int areaId);
    List<Area> selectArea(int areaId);
    IPage selectAreaPage(Integer page, Integer rows);
    IPage<Map> selectAreaMap(Integer page,Integer rows);

}
