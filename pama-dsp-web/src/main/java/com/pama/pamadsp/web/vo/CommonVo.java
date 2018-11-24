package com.pama.pamadsp.web.vo;

public class CommonVo {
    private String resCode="00";//00:成功 01:失败
    private String resMsg="成功";

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
}
