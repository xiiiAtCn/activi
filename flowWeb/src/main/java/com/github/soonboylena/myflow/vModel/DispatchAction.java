package com.github.soonboylena.myflow.vModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispatchAction {
    private String type;
    private String url;
    private String confirm;
    private String at;
    private String alert;
    private String mode;
}
