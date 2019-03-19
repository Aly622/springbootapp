package com.mine.base.bean;

import java.io.Serializable;

/**
 * @创建人 Oliver.Liu
 * @创建时间 3/19/2019
 * @描述
 */
public class Hello implements Serializable{
    private String fldStr;
    private Integer fldInt;
    private boolean fldBool;

    public String getFldStr() {
        return fldStr;
    }

    public void setFldStr(String fldStr) {
        this.fldStr = fldStr;
    }

    public Integer getFldInt() {
        return fldInt;
    }

    public void setFldInt(Integer fldInt) {
        this.fldInt = fldInt;
    }

    public boolean isFldBool() {
        return fldBool;
    }

    public void setFldBool(boolean fldBool) {
        this.fldBool = fldBool;
    }
}
