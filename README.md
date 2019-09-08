idea 搭建web工程：https://www.cnblogs.com/dreamgame/p/8884589.html
快捷键打开project structure Ctrl+Alt+Shift+S

IOC控制反转，全称Inverse Of Control是一种设计理念
由代理人来创建与管理对象，消费者通过代理人来获取对象
IOC的目的是降低程序与程序之间直接耦合
service用于处理业务逻辑
Dao用于数据的增删改，数据库操作
ID依赖注入
IOC是设计理念，是现代程序设计遵循的标准，是宏观目标
DI(Dependency Injection)是具体技术实现，是微观实现
DI在java中利用“反射”实现对象的依赖注入

Spring框架IOC理念的具体实现
Spring核心技术是反射
设计模式主要使用工厂与代理模式
spring-core spring的核心包，提供spring的核心特性IOC
spring-beans IOC容器beans的管理
spring-context：通过过程序初始化IOC容器对象，所有与spring交互部分content完成
spring-aop：面向切面编程
spring-expression：表达式包
spring-jcl：日志包
以上是spring最核心的依赖

使用接口来定义private 属性，通过运行时确定调用哪个对象
 Spring IOC 注解
 用于描述类
 @Repository 持久层
 @Service 业务逻辑类
 @Component 组件类
 @Controller 控制器类 用于与web html进行交互的
  用于注入
 @Resource 智能加载
 @Autowire 按类型加载
 
 Spring的“插件” AOP面向切面编程 
 Aspect 切面编程  
  （1）权限控制
  （2）日志切面，日志的收集，程序运行之后
 AOP技术在不修改源代码的情况下为程序行为进行扩展的技术
   AOP技术开发注意：
    （1）一定要引入aspectjweaver，这是底层的核心实现
            <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.1</version>
        </dependency>
    （2）启用注解
	    <!--启用AOP的注解功能 -->
      <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	 （3）定义切面
	  @Component
      @Aspect
     public class EnhanceAspect {
		/**
		 * 环绕通知，在程序运行前，运行后，以及得到返回值，都执行相应的功能增强
		 * @param pjp
		 * @return
		 * @throws Throwable
		 */
		//环绕通知
		//应用在当前工程所有Service类的所有方法中
		//String com.hawk.spring.AopService.hello(String name)
		//* com.hawk..             *Service.*    (..))" 切点表达式
		@Around("execution(* com.hawk..*Service.*(..))")
		public Object doAround(ProceedingJoinPoint pjp) throws  Throwable{
			System.out.println("[前置通知]"+pjp.getTarget().getClass().getSimpleName()
					+"."+pjp.getSignature().getName());
			/**
			 * 执行目标方法
			 */
			Object ret = pjp.proceed();
			System.out.println("[后置通知]"+pjp.getSignature().getName());
			return  ret;

		}
https://www.cnblogs.com/lilinzhiyu/p/8099178.html

spring MVC 是Spring体系的轻量级Web MVC框架
Spring MVC的核心Controller 控制器，用于处理请求，产生响应
Spring MVC基于Spring IOC 容器运行，所有对象被IOC管理

https://jingyan.baidu.com/album/4ae03de3e120de3eff9e6b86.html?picindex=4

Srring URL Mapping
 @RequestMapping 通用绑定，对所有请求增加前缀，在controller添加
 @GetMapping 绑定Get请求  所有的参数都是通过浏览器地址栏进行发送
 @PostMapping 绑定Post请求
接收请求数据的三种形式
  @使用Controller方法参数接收
  @使用Java Bean接收参数
  @使用路径变量接收数据
中文乱码的配置
  Get请求乱码 - tomcat的server.xml增加URIEndoding属性
      <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8086" protocol="HTTP/1.1" redirectPort="8443"/>
  POST请求乱码 - web.xml配置CharacterEncodingFilter
           <!-- 通过UTF-8实现编码转换 -->
			<filter>
				<filter-name>characterFilter</filter-name>
				<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
				<init-param>
					<param-name>encoding</param-name>
					<param-value>UTF-8</param-value>
				</init-param>
			</filter>
			<filter-mapping>
				<filter-name>characterFilter</filter-name>
				<!-- 这里要写/* 和上边不一样 -->
				<url-pattern>/*</url-pattern>
			</filter-mapping>
  Response响应乱码 -Spring配置StringHttpMessageConverter 
     在applicationContenx.xml中配置
	      <!-- 启用String MVC的注解模式 -->
			<mvc:annotation-driven>
				 <!--解决response乱码问题 -->
				 <mvc:message-converters>
					 <bean class="org.springframework.http.converter.StringHttpMessageConverter">
						 <property name="supportedMediaTypes">
							 <list>
								 <value>text/html;charset=utf-8</value>
							 </list>
						 </property>
					 </bean>
				 </mvc:message-converters>
			</mvc:annotation-driven>
响应处理的两种方式
   @Responsebody 产生响应文本
   ModelAndView 利用模板引擎渲染输出
    返回对象序列化
	         <!-- json 序列化 xml配置文件不需要做任何调整，就能实现对象的序列化 start-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.9.8</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.8</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.8</version>
        </dependency>
        <!-- json 序列化  end-->
	@DateTimeFormat(pattern = "yyyy-MM-dd")  //获取数据格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //json 返回数据序列化
    private Date birthDay;
	
	el表达式
	     <p>${user.username}</p>
     <p>${user.birthDay}</p>
主流模板引擎
  Java Server Page
  Freemarker
  Beetl
  Freemarker脚本为FreeMarker Template Language
  Freemarker提供了大量内建函数来简化开发
  
支持freemarker 需要引入另一个jar包，因为FreeMarkerConfigurationFactory在这个组件中
           <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
FTL取值
  ${属性名}-取值，可对属性进行计算
  ${属性名!默认值} 使用默认值
  ${属性名?string} 格式化输出

