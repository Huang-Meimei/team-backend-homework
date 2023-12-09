package com.team11.controller;

import com.team11.domain.MaskOrder;
import com.team11.service.MaskOrderService;
import com.team11.util.ReturnResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class MaskOrderController {



    @Autowired
    private MaskOrderService maskOrderService;

//    @PostMapping("maskOrderList")
//    public List<MaskOrder> maskOrderList(String userName){
//        return maskOrderService.maskOrderList(userName);
//    }

    @PostMapping("maskOrderList")
    public List<MaskOrder> maskOrderList(Long id){
        return maskOrderService.maskOrderList(id);
    }

    @PostMapping("saveMaskOrder")
    public Map<String, Object> saveOrderList(MaskOrder maskOrder){
        return maskOrderService.save(maskOrder);
    }

    @PostMapping("cancelMaskOrder")
    public int cancelMaskOrder(Long mid){
        return maskOrderService.cancel(mid);
    }

    @PostMapping("maskArrived")
    public int maskArrived(Long mid){
        return maskOrderService.maskArrived(mid);
    }

    @GetMapping("QRCode/{userId}")
    public void createQRCode(HttpServletResponse response, @PathVariable Integer userId) {
        maskOrderService.createQRCode(response, userId);
    }

    @PostMapping("decode")
    public ReturnResult decode(MultipartFile file) {
      return maskOrderService.decode(file);
    }

    @GetMapping("getOderByMid/{mid}")
    public Map<String,Object> getOderByMid(@PathVariable("mid") int mid) {
        System.out.println(mid);
        return maskOrderService.getOderByMid(mid);
    }

}
