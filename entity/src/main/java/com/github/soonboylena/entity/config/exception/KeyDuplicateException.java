package com.github.soonboylena.entity.config.exception;

public class KeyDuplicateException extends RuntimeException {

    private String xpath;
    private String key;

    public KeyDuplicateException(String xpath, String key) {
        super(String.format("%s.xpath:%s, key: %s", "xml配置文件key重复。", xpath, key));
        this.xpath = xpath;
        this.key = key;
    }
}
