package com.github.soonboylena.myflow.entity.core;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaView extends MetaCollection<MetaForm> {

    private String caption;

    @Override
    public String getCaption() {
        return caption;
    }
}
