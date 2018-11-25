package com.pama.pamadsp.web.entity;

/**
 * Created by SHIYU463
 */
public class CommonVO {
    private String resCode = "00";
    private String resMsg = "成功";

    public CommonVO() {

    }

    public CommonVO(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    @Override
    public String toString() {
        return "CommonVO{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                '}';
    }
}
