package com.cqjtu.pcy.product_management_system.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result {
    private boolean success;
    private Object data;
    private String msg;
    public Result(boolean success, Object data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
