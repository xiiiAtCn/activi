package com.github.soonboylena.activiti.vModel.uiComponent;import com.fasterxml.jackson.annotation.JsonProperty;import com.github.soonboylena.activiti.vModel.IUiDefinition;import com.github.soonboylena.activiti.vModel.contant.ButtonType;import com.github.soonboylena.activiti.vModel.contant.SimpleListRowSelectType;import com.github.soonboylena.activiti.vModel.uiAction.LinkAction;import com.github.soonboylena.activiti.vModel.uiAction.UrlObject;import lombok.AllArgsConstructor;import lombok.Data;import java.util.ArrayList;import java.util.List;import java.util.Objects;/** * Created with IntelliJ IDEA. * Description: * Project Name:    spring-boot-admin * UserEntity:            sunb * Date:            2017-10-10 * Time:            17:38 */@Datapublic class SimpleListComponentDefine implements IUiDefinition {    // 列表名称    @JsonProperty(value = "ui_alias")    private String text;    // 数据url    @JsonProperty(value = "data_url")    private UrlObject dataUrl;    // 明细数据里边的按钮    @JsonProperty(value = "showModalBtn")    private boolean hasRowButton = false;    // 头部按钮    @JsonProperty(value = "operation")    private List<Button> actions;    // 列定义    @JsonProperty(value = "cols")    private List<ColDefine> colDefines;    // 表格宽度    @JsonProperty(value = "tableWidth")    private String tableWidth;    // 单选/多选/不选    private SimpleListRowSelectType checkRow;    /**     * @Author XIII  xiii.at.cn@gmail.com     * @Modified 2017/12/13 15:18     */    //是否显示搜索框    private boolean showSearch;    //建议搜索词搜索    @JsonProperty(value = "suggestUrl")    private UrlObject suggestUrl;    public void addColDefine(ColDefine colDefine) {        if (colDefines == null) colDefines = new ArrayList<>();        colDefines.add(colDefine);    }    public void addOperation(Button action) {        if (actions == null) this.actions = new ArrayList<>();        actions.add(action);    }    public void addOperation(List<Button> actions) {        if (this.actions == null) this.actions = new ArrayList<>();        this.actions.addAll(actions);    }    public void addAction(Button button) {        if (button == null) {            return;        }        if (this.actions == null) actions = new ArrayList<>();        actions.add(button);    }    /**     * 添加删除按钮     *     * @param urlObject     */    public void setDeleteUrl(UrlObject urlObject) {        Objects.requireNonNull(urlObject);        LinkAction action = new LinkAction();//        action.setType(ClientActionType.serverAction);        action.setUrl(urlObject);        action.setCallbackMethodName("reloadData");        Button button = new Button("删除", action);        button.setType(ButtonType.error);        addOperation(button);        // 设置单选        setCheckRow(SimpleListRowSelectType.M);    }    //@Data    //@AllArgsConstructor    //public static class ItemAction {    //    private String field;    //    private String text;    //    private String type;    //    //    public ItemAction(String field, String text) {    //        this.field = field;    //        this.text = text;    //    }    //}    //@Data    //@AllArgsConstructor    //public static class Action {    //    private String url;    //    private String text;    //}    @Data    @AllArgsConstructor    public static class ColDefine {        private String field;        private String text;        private String sort;        public ColDefine(String field, String text) {            this.field = field;            this.text = text;        }    }}