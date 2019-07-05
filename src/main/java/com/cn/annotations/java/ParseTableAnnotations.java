package com.cn.annotations.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/19
 * @Description:
 * @Version: 1.0.0
 */
public class ParseTableAnnotations {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setAge(19);
        person.setName("王五");
        person.setCdate("2018-10-22 10:22:22");
        save(person);

        User user = new User();
        user.setAge(20);
        user.setName("赵六");
        //save(user);
        System.out.println("执行成功！");
    }

    public static void save(Object obj) throws IllegalAccessException {
        StringBuffer sql_key = new StringBuffer("insert into ");
        StringBuffer sql_value = new StringBuffer(" values (");
        Class clazz = obj.getClass();
        // 解析类的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Table) {
                Table table = (Table) annotation;
                String tableName = table.table();
                sql_key.append("`" + tableName + "` (");
            }
        }

        // 解析字段的注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 设为true的话就是跳过访问检查，也就可以访问 private 的东西
            field.setAccessible(true);
            Annotation[] annos = field.getAnnotations();
            for (Annotation annotation : annos) {
                if (annotation instanceof Table) {
                    Table table = (Table) annotation;
                    String column = table.column();
                    String type = table.type();
                    sql_key.append("`" + column + "`, ");
                    if ("String".equals(type)) {
                        String value = field.get(obj).toString();
                        sql_value.append(" '" + value + "', ");
                    } else if ("int".equals(type)) {
                        int value = field.getInt(obj);
                        sql_value.append(value + ", ");
                    }
                }
            }
        }

        String sql = sql_key.substring(0, sql_key.length() - 2) + ") " + sql_value.substring(0, sql_value.length() - 2) + ");";
        opsDb(sql);
    }

    public static void opsDb(String sql) {
        Connection conn = null;
        String url = "jdbc:mysql://192.168.16.198:3306/test?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
