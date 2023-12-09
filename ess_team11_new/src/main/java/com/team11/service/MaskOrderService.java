package com.team11.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.team11.dao.MaskOrderDao;
import com.team11.dao.UserDao;
import com.team11.domain.MaskOrder;
import com.team11.domain.User;
import com.team11.util.ReturnResult;
import com.team11.vo.UserVO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

@Service
public class MaskOrderService {
    private static final Logger logger = LoggerFactory.getLogger(MaskOrderService.class);

    //二维码宽度
    private static final Integer width = 300;
    //二维码高度
    private static final Integer height = 300;
    //
    private static final String imageFormat = "jpg";

    @Value("${URL}")
    private String url;

    @Resource
    private MaskOrderDao maskOrderDao;

    @Autowired
    private UserService userService;

    public Map<String, Object> save(MaskOrder maskOrder) {
        Map<String, Object> maps = new HashMap<>();
        if(maskOrderDao.save(maskOrder) == 1){
           int mid = maskOrderDao.getOderMid(maskOrder.getUid());
            maps.put("code",200);
            maps.put("mid",mid);
        }
        return maps;
    }

    public List<MaskOrder> maskOrderList(Long id) {
        return maskOrderDao.maskOrderList(id);
    }

    public int cancel(Long mid) {
        return maskOrderDao.updateState(mid, -1);
    }

    public int maskArrived(Long mid) {
        return maskOrderDao.updateState(mid, 2);
    }

    public void createQRCode(HttpServletResponse response, Integer userId) {
        UserVO userVO = userService.selectOne(userId);
        try {
            if (ObjectUtil.isNull(userVO)) {
                response.getWriter().print(JSONUtil.toJsonStr(ReturnResult.createError(500, "用户不存在")));
            }
            String information = url + userVO.getUname() + DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_PATTERN);
            //QrCodeUtil.generate(information, new QrConfig(), ImgUtil.IMAGE_TYPE_JPG, response.getOutputStream());
            createQrCode(information, response.getOutputStream());
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage(), e);
        }
    }

    public ReturnResult decode(MultipartFile file) {
        try {
            Result result = encodeQrCode(file.getInputStream());
            if (result != null) {
                return ReturnResult.createResult(200, result.getText());
            }
            //return ReturnResult.createResult(200, QrCodeUtil.decode(file.getInputStream()));
        } catch (IOException e) {
            logger.error("错误信息：{}", e.getMessage(), e);
        }
        return ReturnResult.createError(500, "二维码解析错误");
    }

    /**
     * 生成二维码
     *
     * @param content      二维码内容
     * @param outputStream 输出流
     */
    public static void createQrCode(String content, OutputStream outputStream) {
        //第一步，定义二维码的参数
        Map<EncodeHintType, Object> hints = new HashMap<>(5);
        //1、设置编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //2、设置容错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
        //3、设置边距
        hints.put(EncodeHintType.MARGIN, 1);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析二维码
     *
     * @param inputStream 二维码
     * @return Result
     */
    private static Result encodeQrCode(InputStream inputStream) {
        try {
            //创建MultiFormatReader
            MultiFormatReader reader = new MultiFormatReader();
            //读取二维码
            BufferedImage image = ImageIO.read(inputStream);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Map<DecodeHintType, Object> hint = new HashMap<>(2);
            hint.put(DecodeHintType.CHARACTER_SET, "utf-8");
            //解析二维码
            return reader.decode(binaryBitmap, hint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Resource
    UserDao userDao;
    public Map<String,Object> getOderByMid(int mid){
        Map<String, Object> mps = new HashMap<>();
        MaskOrder maskOrder = maskOrderDao.selectOderByMid(mid);
        if(maskOrder != null){
            User user = userDao.selectOneById(Integer.parseInt(maskOrder.getUid() + ""));
            maskOrder.setUname(user.getTruename());
            mps.put("code",200);
            mps.put("data",maskOrder);
        }else{
            mps.put("code",400);
        }

        return mps;
    }
}
