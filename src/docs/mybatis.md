[toc]
# 目录
## spring 与 mybatis 结合配置文件
```java
spring-mybatis.xml：
<!-- spring 和 MyBatis 整合-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSourceMysql" />
        <!-- 配置 sql 语句打印到控制台  -->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <!-- 自动扫描 mapping.xml文件 -->
        <property name="mapperLocations" value="classpath*:com/cn/mapper/*.xml" />
    </bean>

    <!-- DAO接口所在包名，Spring 会自动查找其下的接口 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.cn.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
    </bean>
    
mybatis-config.xml：
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING" />
    </settings>
</configuration>
```
## mapper.xml 文件
[原文地址](https://cloud.tencent.com/developer/article/1129237)
```
association:一对一关联(has one)
collection:一对多关联(has many)
注意，只有在做select查询时才会用到这两个标签，都有三种用法，且用法类似。

eg:
association 一对一映射
<resultMap id="personResult" type="com.cn.model.Person">
    <id column="id" property="id"/>
    <result column="name" property="name"/>
    <association property="card" javaType="com.cn.model.Card">
        <id column="card_id" property="card_id"/>
        <result column="address" property="address"/>
    </association>
</resultMap>

<select id="getPerson" resultMap="personResult">
        select p.id, p.name, c.card_id, c.address  from person p, card c where p.id = #{id};
</select>

association 一对一对一映射
<resultMap id="cityResult" type="com.cn.model.City">
        <id column="city_id" property="cityId"/>
        <result column="city_name" property="cityName"/>
        <association property="person" resultMap="personResult" />
</resultMap>

<select id="getCity" resultMap="cityResult">
        SELECT
            c.city_id,
            c.city_name,
            p.id,
            p.`name`,
            d.card_id,
            d.address
        FROM
            city c,
            person p,
            card d
        WHERE
            c.city_id = p.id
        AND p.id = d.card_id
        AND c.city_id = #{id};
</select>

collection:一对多关联(has many)

<resultMap id="custpmerResult" type="com.cn.model.Customer">
        <id column="user_id" property="userId"/>
        <result column="user_name" property="userName"/>
        <result column="age" property="age"/>
        <collection property="mobilePhone" ofType="com.cn.model.MobilePhone" javaType="list">
            <id column="mobilePhone_id" property="mobilePhoneId"/>
            <result column="brand" property="brand"/>
            <result column="price" property="price"/>
            <result column="customer_id" property="customerId"/>
        </collection>
</resultMap>

<select id="getCustomer" resultMap="custpmerResult">
        SELECT
            c.user_id,
            c.user_name,
            c.age,
            m.mobilePhone_id,
            m.brand,
            m.price,
            m.customer_id
        FROM
            customer c,
            mobilephone m
        WHERE
            c.user_id = m.customer_id
        AND c.user_id = #{id};
    </select>
    
```
## 注意事项
```
 mapper.xml 文件注意点
* 1 mapper.xml 文件提供 sql 语句给 sqlSession 执行
* 2 mybatis 的 dao 接口方法名要和 mapper.xml 文件里的 id 一致
* 3 如果数据库表中的字段和实体类名称不一致 可在 mapper 文件里做一次映射
* 4 在 mapper.xml 文件里 resultType 是 sql 映射文件中定义返回值类型，返回值有基本类型，对象类型，List类型，Map类型等
* 5 \# 将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号。如：order by \#{user_id}，如果传入的值是111,那么解析成sql时的值为order by “111”, 如果传入的值是id，则解析成的sql为order by “id”。
* 6 $ 将传入的数据直接显示生成在sql中。如：order by ${user_id}，如果传入的值是111,那么解析成sql时的值为order by 111, 如果传入的值是id，则解析成的sql为order by id
* 7 建议使用 # 可以一定程度上避免 sql 注入

 dao 层接口注意点
* 1 mybatis 扫描 dao 层会自动生成 dao 包下面接口的实现类
* 2 mybatils 传多个参数时可以在 dao 层使用 @Param("id") String id 形式
```
