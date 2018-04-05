package com.github.soonboylena.myflow.support;

import com.github.soonboylena.myflow.vModel.uiAction.UrlObject;
import org.springframework.http.HttpMethod;

public class UrlManager {

    private static final String prefix = "/api";

    public static UrlObject layout(String formKey) {
        return new UrlObject(prefix + "/page/layout/{formKey}", ChainMap.get().put("formKey", formKey).ok());
    }

    public static UrlObject submit() {
        return new UrlObject(prefix + "/page/data", HttpMethod.PUT);
    }

    public static UrlObject pageInit(String formKey) {
        return new UrlObject(prefix + "/page/init/{formKey}", ChainMap.get().put("formKey", formKey).ok());
    }
}
