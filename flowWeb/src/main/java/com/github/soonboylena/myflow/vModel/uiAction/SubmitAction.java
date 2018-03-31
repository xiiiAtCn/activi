package com.github.soonboylena.myflow.vModel.uiAction;

import com.github.soonboylena.myflow.vModel.contant.ClientActionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubmitAction extends AbstractAction {

    private String[] formKeys;

    public SubmitAction(UrlObject url, String... formKeys) {
        this.url = url;
        this.formKeys = formKeys;
    }

    @Override
    public ClientActionType getType() {
        return ClientActionType.submit;
    }
}