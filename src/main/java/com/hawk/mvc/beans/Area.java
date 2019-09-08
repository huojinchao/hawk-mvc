package com.hawk.mvc.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-07 20:36
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
@TableName("base_area")
public class Area {
    /**
     * 依赖mysql自动生成主键
     * 其他字段自动遵从驼峰命名
     */
    @TableId(type = IdType.AUTO)
    private Integer areaId;
    private String areaName;
    private String cityCode;
    private String address;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
