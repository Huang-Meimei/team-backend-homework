package com.team11.controller;

import com.team11.domain.NucleicAcid;
import com.team11.service.NucleicAcidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

public class NucleicAcidController {

    @Autowired
    private NucleicAcidService nucleicAcidService;

    @PostMapping("saveNucleicAcid")
    public int saveNucleicAcid(NucleicAcid nucleicAcid){
        return nucleicAcidService.saveNucleicAcid(nucleicAcid);
    }

    @PostMapping("nucleicAcidList")
    public HashMap<String,Object> nucleicAcidList(int id){
        HashMap<String,Object> result = new HashMap<>();
        List<NucleicAcid> list = nucleicAcidService.nucleicAcidList(id);
        result.put("list",list);
        result.put("msg",1);
        return result;
    }

    @PostMapping("cancelNucleicAcid")
    public int cancelNucleicAcid(Long nid){
        return nucleicAcidService.cancelNucleicAcid(nid);
    }

}
