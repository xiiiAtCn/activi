package com.github.soonboylena.activiti.vModel.uiComponent;

import com.github.soonboylena.activiti.vModel.AbstractDwc;
import com.github.soonboylena.activiti.vModel.IUiDefinition;
import lombok.Data;

public class Form extends AbstractDwc<FormDefinition> {

    private final static String type = "Form";

    public Form(String model) {
        FormDefinition definition = new FormDefinition();
        definition.setModel(model);
    }

    @Override
    public String getType() {
        return type;
    }
}

@Data
class FormDefinition implements IUiDefinition {
    private String model;
}