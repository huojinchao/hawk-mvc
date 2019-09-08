无入侵
损耗小
强大的CRUD
多种数据库
内置分页

mybatis-plus地址:https://mp.baomidou.com/

1.引入mybatis-plus 需要注释掉以下两项
  <!--        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.0</version>
        </dependency>-->
        <!-- mybatis与spring整合插件 -->
<!--        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.2</version>
        </dependency>-->
2.修改applicationContext.xml
    <!--2.配置SessionFactory 只需要改这一个地方就能保证mybatis-plus生效-->
    <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
3.开启分页查询，需要在mybatis-config.xml
  添加一个分页插件
      <plugins>
        <!-- 添加分页插件 -->
        <plugin interceptor="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor"></plugin>
    </plugins>
4.自带的分页查询
       @Override
    public IPage selectAreaPage(Integer page, Integer rows) {
        IPage<Area>  p = new Page<Area>(page,rows);
        QueryWrapper<Area> condition = new QueryWrapper<>();
        IPage pageResult = areaMapper.selectPage(p,condition);
        return pageResult;
    }
5.自定义sql的分页查询
 <mapper namespace="com.hawk.mvc.mpper.AreaMapper">
    <select id="selectAreaMap" resultType="java.util.Map">
        select * from base_area
    </select>
</mapper>

public interface AreaMapper extends BaseMapper<Area> {
    /**
     *
     * @param page 第一个参数必须是page
     * @return
     */
    IPage<Map> selectAreaMap(Page page);
}
public class AreaServiceImpl implements AreaService
    @Override
    public IPage<Map> selectAreaMap(Integer page, Integer rows) {
        return areaMapper.selectAreaMap(new Page(page,rows));
    }
