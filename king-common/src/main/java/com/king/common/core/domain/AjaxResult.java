package com.king.common.core.domain;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    private static final String CODE_TAG = "code";
    private static final String MSG_TAG = "msg";
    private static final String DATA_TAG = "data";

    public AjaxResult(int code, String msg, Object obj) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, obj);
    }

    public AjaxResult(Object obj) {
        this(0, "", obj);
    }

}
