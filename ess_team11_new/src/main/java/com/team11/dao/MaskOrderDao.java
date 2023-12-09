package com.team11.dao;

import com.team11.domain.MaskOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface MaskOrderDao {

    @Select("SELECT * FROM MASK_ORDER WHERE UID=#{id} OR RID=#{id}")
    List<MaskOrder> maskOrderList(Long id);

    @Select("select max(mid) from MASK_ORDER where uid = #{uid}")
    int getOderMid(@Param("uid") long uid);

    @Insert("INSERT INTO MASK_ORDER VALUES(NULL,#{uid},#{uname},#{rid},#{rname},#{ptype},#{pnumber},#{rtel},#{address},#{saddress},#{atime},#{mtype},#{mnumber},#{ordertime},NULL,NULL,NULL,NULL,1)")
    int save(MaskOrder maskOrder);

    @Update("UPDATE MASK_ORDER SET STATE_FLAG = #{state_flag} WHERE MID = #{mid}")
    int updateState(Long mid, int state_flag);

    @Select("select * from MASK_ORDER where mid = #{mid}")
    MaskOrder selectOderByMid(@Param("mid") int mid);

}
