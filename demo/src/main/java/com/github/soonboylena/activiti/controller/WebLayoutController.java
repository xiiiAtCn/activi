package com.github.soonboylena.activiti.controller;

import com.github.soonboylena.activiti.service.WebFormService;
import com.github.soonboylena.activiti.service.WebLayoutService;
import com.github.soonboylena.activiti.support.UrlManager;
import com.github.soonboylena.activiti.vModel.UiObject;
import com.github.soonboylena.activiti.vModel.uiComponent.Form;
import com.github.soonboylena.activiti.vModel.uiComponent.Page;
import com.github.soonboylena.activiti.vModel.uiComponent.UrlSection;
import com.github.soonboylena.entity.core.IEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("page")
public class WebLayoutController {

    @Autowired
    private WebLayoutService webLayoutService;

    @Autowired
    private WebFormService formSvc;

    @GetMapping("init/{formKey}")
    public UrlSection init(@PathVariable("formKey") String formKey) {

        UrlSection section = new UrlSection(UrlManager.layout(formKey));
        return section;
    }

    @GetMapping("layout/{formKey}")
    public UiObject layout(@PathVariable("formKey") String formKey) {

        Form form = webLayoutService.buildLayout(formKey);
        Page page = new Page(form.getCaption());
        page.addContent(form);
        return page;
    }

    @GetMapping("data/{formKey}/{id}")
    public UiObject data(@PathVariable("formKey") String formKey, @PathVariable("id") String id) {
        return webLayoutService.buildLayout(formKey);
    }

    @PutMapping("data/{formKey}")
    public IEntity createData(@PathVariable("formKey") String formKey, @RequestBody Map<String, Object> map) {

        IEntity iEntity = formSvc.cleanUp(formKey, map);
        return iEntity;
    }
}
