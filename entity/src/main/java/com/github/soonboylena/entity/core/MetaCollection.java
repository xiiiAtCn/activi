package com.github.soonboylena.entity.core;

import com.github.soonboylena.entity.exceptions.KeyDuplicateException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class MetaCollection<T extends IMeta> implements IMeta {

    private String key;

    protected Map<String, T> metaPool = new LinkedHashMap<>();

    @Override
    public String getKey() {
        return key;
    }

    public T getMeta(String metaKey) {
        return metaPool.get(metaKey);
    }

    public Collection<T> getMetas() {
        return metaPool.values();
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void addMeta(T meta) {
        if (meta == null) return;
        if (metaPool.containsKey(meta.getKey())) {
            throw new KeyDuplicateException("MetaCollection中已经包含了key为 [" + meta.getKey() + "] 的meta");
        }
        metaPool.put(meta.getKey(), meta);
    }

    public int size() {
        return metaPool.size();
    }
}
