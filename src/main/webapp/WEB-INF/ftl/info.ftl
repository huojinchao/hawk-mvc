<!-- 判断对象是否为空-->
<#if user?? >
<span style="color:red;font-size:48px">

${user.name}
</span>
<h1>${user.salary?string('0.00')}</h1>
<h2>${user.birthDay?string('yyyy-MM-dd HH:mm:ss')}</h2>
<h2>${user.username}</h2>
<!-- 字段不存在的时候，或者属性为空的时候-->
<h3>${user.address!'未登记地址'}</h3>
<h4>
    <#if user.salary <= 10000>
        低收入人群需要补贴
        <!-- 含有大于号的表达式需要用小括号-->
    <#elseif (user.salary > 10000 && user.salary <20000) >
        中等收入人群鼓励创业
    <#else>
         高收入人群多做公益
    </#if>
    <#if user.username=='admin'>
        系统超级管理员
    </#if>
</h4>
<#else>
   <h5>对象不存在</h5>
</#if>