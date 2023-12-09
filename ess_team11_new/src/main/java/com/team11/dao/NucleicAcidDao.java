package com.team11.dao;

import com.team11.domain.NucleicAcid;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NucleicAcidDao {

    @Insert("INSERT INTO NUCLEICACID VALUES(NULL,#{uid},#{uname},#{ptype},#{pnumber},#{tel},#{address},#{saddress},#{ntime},#{ordertime},null,null,null,null,1)")
    int saveNucleicAcid(NucleicAcid nucleicAcid);

    @Select("SELECT * FROM NUCLEICACID WHERE UID = #{uid}")
    List<NucleicAcid> listById(int uid);

    @Update("UPDATE NUCLEICACID SET STATE_FLAG = #{state_flag} WHERE NID = #{nid}")
    int updateState(Long nid, int state_flag);

}
