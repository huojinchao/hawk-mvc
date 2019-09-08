package com.hawk.mvc.mpper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawk.mvc.beans.Area;

import java.util.Map;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-08 17:35
 * <p>
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
public interface AreaMapper extends BaseMapper<Area> {
    /**
     *
     * @param page 第一个参数必须是page
     * @return
     */
    IPage<Map> selectAreaMap(Page page);
}
