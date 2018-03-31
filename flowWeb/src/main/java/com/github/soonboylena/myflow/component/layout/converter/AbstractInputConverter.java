package com.github.soonboylena.myflow.component.layout.converter;

import com.github.soonboylena.myflow.support.WebItemType;
import com.github.soonboylena.myflow.vModel.UiObject;
import com.github.soonboylena.myflow.vModel.uiComponent.FormItem;
import com.github.soonboylena.myflow.vModel.uiComponent.LabelInput;
import com.github.soonboylena.myflow.vModel.uiComponent.MapUiObject;
import com.github.soonboylena.myflow.entity.core.IMeta;
import com.github.soonboylena.myflow.entity.core.IMetaInput;
import com.github.soonboylena.myflow.entity.core.MetaField;

import java.util.Map;

public abstract class AbstractInputConverter implements UIConverter {

    @Override
    public boolean support(IMeta metaItem) {
        return metaItem instanceof IMetaInput;
    }

    @Override
    public UiObject convert(IMeta metaItem) {

        IMetaInput metaInput = (IMetaInput) metaItem;

        FormItem labelInput = new FormItem(metaInput.getCaption());

        MetaField field = (MetaField) metaItem;
        MapUiObject<String, Object> mapUiObject = new MapUiObject<>(getType().webType());
        mapUiObject.put("name", field.getKey());
        mapUiObject.put("readonly", field.isReadOnly());
        mapUiObject.put("required", field.isRequired());

        Map<String, Object> attach = attach();
        if (attach != null) mapUiObject.putAll(attach);

        labelInput.addContent(mapUiObject);
        return labelInput;
    }

    protected abstract Map<String, Object> attach();

    protected abstract WebItemType getType();

}