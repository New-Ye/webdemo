package com.songtian.webdemo.mapper;

import com.songtian.webdemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(value = {"select * from user where name=#{name}&&pwd=#{pwd}"})
    String login(String name,String pwd);

    @Insert(value = {"insert into user (name ,pwd,sex,age,birthdate) values (#{name },#{pwd},#{sex},#{age},#{birthdate})"})
    int register(User user);

    @Select(value = {"select count(*) from user where name=#{name}"})
    int checkRegisterByName(String name);

    @Select(value = {"select * from user"})
    List<User> selectAll();

    @Update("<script>" +
            "update user" +
            "<set>"+
            "<if test='name!=null&&name!='''>name=#{name},</if>" +
            "<if test='pwd!=null&&pwd!='''>pwd=#{pwd},</if>" +
            "<if test='sex!=null&&sex!='''>sex=#{sex},</if>"+
            "<if test='age!=null&&age!='''>age=#{age},</if>"+
            "<if test='birthdate!=null&&birthdate!='''>birthdate=#{birthdate},</if>"+
            "</set>" +
            "where id=#{id}"+
            "</script>")
    Integer updateMsg(User user);

    @Select(value = "select pwd from user where id=#{id}")
    Integer checkPwd(int pwd);

}
