(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d208dc1"],{a71f:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[a("el-form-item",{attrs:{label:"名称",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.name,callback:function(t){e.$set(e.queryParams,"name",t)},expression:"queryParams.name"}})],1),a("el-form-item",{attrs:{label:"状态",prop:"status"}},[a("el-select",{attrs:{placeholder:"请选择状态",clearable:""},model:{value:e.queryParams.status,callback:function(t){e.$set(e.queryParams,"status",t)},expression:"queryParams.status"}},e._l(e.dict.type.global_status,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"用户",prop:"userId"}},[a("el-input",{attrs:{placeholder:"请输入用户",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.userId,callback:function(t){e.$set(e.queryParams,"userId",t)},expression:"queryParams.userId"}})],1),a("el-form-item",{attrs:{label:"入住时间",prop:"startTime"}},[a("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择入住时间"},model:{value:e.queryParams.startTime,callback:function(t){e.$set(e.queryParams,"startTime",t)},expression:"queryParams.startTime"}})],1),a("el-form-item",{attrs:{label:"期限",prop:"limitDay"}},[a("el-input",{attrs:{placeholder:"请输入期限",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.limitDay,callback:function(t){e.$set(e.queryParams,"limitDay",t)},expression:"queryParams.limitDay"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),a("el-row",{staticClass:"mb8",attrs:{gutter:10}},[a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:add"],expression:"['religion:religionOutuserManager:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:edit"],expression:"['religion:religionOutuserManager:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:remove"],expression:"['religion:religionOutuserManager:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:export"],expression:"['religion:religionOutuserManager:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),a("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.religionOutuserManagerList},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{label:"编号",align:"center",prop:"id"}}),a("el-table-column",{attrs:{label:"名称",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"创建时间",align:"center",prop:"createTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e.parseTime(t.row.createTime,"{y}-{m}-{d}")))])]}}])}),a("el-table-column",{attrs:{label:"更新时间",align:"center",prop:"updateTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e.parseTime(t.row.updateTime,"{y}-{m}-{d}")))])]}}])}),a("el-table-column",{attrs:{label:"状态",align:"center",prop:"status"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("dict-tag",{attrs:{options:e.dict.type.global_status,value:t.row.status}})]}}])}),a("el-table-column",{attrs:{label:"用户",align:"center",prop:"userId"}}),a("el-table-column",{attrs:{label:"入住时间",align:"center",prop:"startTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e.parseTime(t.row.startTime,"{y}-{m}-{d}")))])]}}])}),a("el-table-column",{attrs:{label:"期限",align:"center",prop:"limitDay"}}),a("el-table-column",{attrs:{label:"备注",align:"center",prop:"remark"}}),a("el-table-column",{attrs:{label:"原由",align:"center",prop:"reason"}}),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:edit"],expression:"['religion:religionOutuserManager:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.handleUpdate(t.row)}}},[e._v("修改")]),a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionOutuserManager:remove"],expression:"['religion:religionOutuserManager:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),a("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"名称",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"状态"}},[a("el-radio-group",{model:{value:e.form.status,callback:function(t){e.$set(e.form,"status",t)},expression:"form.status"}},e._l(e.dict.type.global_status,(function(t){return a("el-radio",{key:t.value,attrs:{label:parseInt(t.value)}},[e._v(e._s(t.label))])})),1)],1),a("el-form-item",{attrs:{label:"用户",prop:"userId"}},[a("el-input",{attrs:{placeholder:"请输入用户"},model:{value:e.form.userId,callback:function(t){e.$set(e.form,"userId",t)},expression:"form.userId"}})],1),a("el-form-item",{attrs:{label:"入住时间",prop:"startTime"}},[a("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择入住时间"},model:{value:e.form.startTime,callback:function(t){e.$set(e.form,"startTime",t)},expression:"form.startTime"}})],1),a("el-form-item",{attrs:{label:"期限",prop:"limitDay"}},[a("el-input",{attrs:{placeholder:"请输入期限"},model:{value:e.form.limitDay,callback:function(t){e.$set(e.form,"limitDay",t)},expression:"form.limitDay"}})],1),a("el-form-item",{attrs:{label:"备注",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1),a("el-form-item",{attrs:{label:"原由",prop:"reason"}},[a("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.reason,callback:function(t){e.$set(e.form,"reason",t)},expression:"form.reason"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),a("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},l=[],n=a("5530"),i=(a("d81d"),a("b775"));function s(e){return Object(i["a"])({url:"/religion/religionOutuserManager/list",method:"get",params:e})}function o(e){return Object(i["a"])({url:"/religion/religionOutuserManager/"+e,method:"get"})}function u(e){return Object(i["a"])({url:"/religion/religionOutuserManager",method:"post",data:e})}function m(e){return Object(i["a"])({url:"/religion/religionOutuserManager",method:"put",data:e})}function c(e){return Object(i["a"])({url:"/religion/religionOutuserManager/"+e,method:"delete"})}var d={name:"ReligionOutuserManager",dicts:["global_status"],data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,religionOutuserManagerList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,name:null,status:null,userId:null,startTime:null,limitDay:null,reason:null},form:{},rules:{name:[{required:!0,message:"名称不能为空",trigger:"blur"}]}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,s(this.queryParams).then((function(t){e.religionOutuserManagerList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,name:null,tenantId:null,createBy:null,createTime:null,updateBy:null,updateTime:null,status:1,userId:null,startTime:null,limitDay:null,deleted:null,remark:null,reason:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加临时人员登记"},handleUpdate:function(e){var t=this;this.reset();var a=e.id||this.ids;o(a).then((function(e){t.form=e.data,t.open=!0,t.title="修改临时人员登记"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?m(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,a=e.id||this.ids;this.$modal.confirm('是否确认删除临时人员登记编号为"'+a+'"的数据项？').then((function(){return c(a)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("religion/religionOutuserManager/export",Object(n["a"])({},this.queryParams),"religionOutuserManager_".concat((new Date).getTime(),".xlsx"))}}},p=d,g=a("2877"),f=Object(g["a"])(p,r,l,!1,null,null,null);t["default"]=f.exports}}]);