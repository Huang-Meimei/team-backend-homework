package com.team11.dao;

import com.team11.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface UserDao {

    @Select("select * from t_user where uname = #{account} or utel = #{account} or email = #{account}")
    User selectOne(String account);

    @Select("select * from t_user where uid = #{uid}")
    User selectOneById(int uid);

    @Insert("insert into t_user values(null,#{uname},#{truename},#{upass},#{utel},#{email},#{photo},#{sex},#{ptype},#{pnumber},#{birthday},#{country},#{identity},#{y11},#{y12},#{y13},#{y14},1)")
    int insertOne(User user);

    @Update("update t_user set uname=#{uname},utel=#{utel},email=#{email},photo=#{photo},sex=#{sex},ptype=#{ptype},pnumber=#{pnumber},birthday=#{birthday},country=#{country} where uid=#{uid}")
    int update(User user);

}
