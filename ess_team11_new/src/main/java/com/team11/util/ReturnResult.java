package com.team11.util;

import java.util.HashMap;

public class ReturnResult {

    private int code;
    private HashMap<String,Object> datas;

    private ReturnResult(int code){
        this.code = code;
        datas = new HashMap<>();
    }

    public static ReturnResult createResult(int code){
        return new ReturnResult(code);
    }

    public static ReturnResult createResult(int code,String msg){
      return createResult(code).setAttr("msg",msg);
    }

    public static ReturnResult createError(int code,String msg){
        return createResult(code).setAttr("msg",msg);
    }

    public int getCode() {
        return code;
    }
    public ReturnResult setCode(int code) {
        this.code = code;
        return this;
    }
    public ReturnResult removeAttr(String key){
        this.datas.remove(key);
        return this;
    }
    public Object getAttr(String key){
        return datas.get(key);
    }
    public ReturnResult setAttr(String key,Object value){
        this.datas.put(key, value);
        return this;
    }

    public HashMap<String, Object> getDatas() {
        return datas;
    }
}
