package com.coffeekong.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections.MapUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
// 비동기 통신을 하기 위해 사용되는 response 클래스
public class Response implements Serializable {
    private int returnCode;
    private String returnMessage;
    private Map<String, Object> context;

    public Response() {
        context = new HashMap<>();
        setReturnCode(0);
        setReturnMessage("success");
    }

    @JsonProperty(value="return_code")
    public int getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    @JsonProperty(value="return_message")
    public String getReturnMessage() {
        return returnMessage;
    }
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    @JsonProperty(value="context")
    @JsonInclude(Include.NON_NULL)
    public Map<String, Object> getContext() {
        if (MapUtils.isEmpty(context)) {
            return null;
        }
        return context;
    }
    public Object putContext(String k, Object v) {
        return context.put(k, v);
    }
}
