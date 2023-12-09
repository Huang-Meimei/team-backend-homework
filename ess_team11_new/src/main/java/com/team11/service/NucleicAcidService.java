package com.team11.service;

import com.team11.dao.NucleicAcidDao;
import com.team11.domain.NucleicAcid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NucleicAcidService {

    @Autowired
    private NucleicAcidDao nucleicAcidDao;

    public int saveNucleicAcid(NucleicAcid nucleicAcid){
        return nucleicAcidDao.saveNucleicAcid(nucleicAcid);
    }

    public List<NucleicAcid> nucleicAcidList(int id){
        return nucleicAcidDao.listById(id);
    }

    public int cancelNucleicAcid(Long nid){
        return nucleicAcidDao.updateState(nid, -1);
    }
}
