(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b2c59"],{2610:function(e,t,l){"use strict";l.r(t);var r=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[l("el-form-item",{attrs:{label:"名称",prop:"name"}},[l("el-input",{attrs:{placeholder:"请输入名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.name,callback:function(t){e.$set(e.queryParams,"name",t)},expression:"queryParams.name"}})],1),l("el-form-item",{attrs:{label:"状态",prop:"status"}},[l("el-select",{attrs:{placeholder:"请选择状态",clearable:""},model:{value:e.queryParams.status,callback:function(t){e.$set(e.queryParams,"status",t)},expression:"queryParams.status"}},e._l(e.dict.type.global_status,(function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),l("el-form-item",{attrs:{label:"简介",prop:"introduce"}},[l("el-input",{attrs:{placeholder:"请输入简介",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.introduce,callback:function(t){e.$set(e.queryParams,"introduce",t)},expression:"queryParams.introduce"}})],1),l("el-form-item",{attrs:{label:"宗教类别",prop:"religionType"}},[l("el-select",{attrs:{placeholder:"请选择宗教类别",clearable:""},model:{value:e.queryParams.religionType,callback:function(t){e.$set(e.queryParams,"religionType",t)},expression:"queryParams.religionType"}},e._l(e.dict.type.religion_type,(function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),l("el-form-item",{attrs:{label:"经度",prop:"longitude"}},[l("el-input",{attrs:{placeholder:"请输入经度",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.longitude,callback:function(t){e.$set(e.queryParams,"longitude",t)},expression:"queryParams.longitude"}})],1),l("el-form-item",{attrs:{label:"纬度",prop:"latitude"}},[l("el-input",{attrs:{placeholder:"请输入纬度",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.latitude,callback:function(t){e.$set(e.queryParams,"latitude",t)},expression:"queryParams.latitude"}})],1),l("el-form-item",{attrs:{label:"景区级别",prop:"scenicLevel"}},[l("el-input",{attrs:{placeholder:"请输入景区级别",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.scenicLevel,callback:function(t){e.$set(e.queryParams,"scenicLevel",t)},expression:"queryParams.scenicLevel"}})],1),l("el-form-item",{attrs:{label:"文保级别",prop:"securityLevel"}},[l("el-input",{attrs:{placeholder:"请输入文保级别",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.securityLevel,callback:function(t){e.$set(e.queryParams,"securityLevel",t)},expression:"queryParams.securityLevel"}})],1),l("el-form-item",{attrs:{label:"门票",prop:"ticket"}},[l("el-input",{attrs:{placeholder:"请输入门票",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.ticket,callback:function(t){e.$set(e.queryParams,"ticket",t)},expression:"queryParams.ticket"}})],1),l("el-form-item",{attrs:{label:"始建年代",prop:"initialTime"}},[l("el-input",{attrs:{placeholder:"请输入始建年代",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.initialTime,callback:function(t){e.$set(e.queryParams,"initialTime",t)},expression:"queryParams.initialTime"}})],1),l("el-form-item",{attrs:{label:"开发时间",prop:"devTime"}},[l("el-input",{attrs:{placeholder:"请输入开发时间",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.devTime,callback:function(t){e.$set(e.queryParams,"devTime",t)},expression:"queryParams.devTime"}})],1),l("el-form-item",{attrs:{label:"主要景点",prop:"mainSpot"}},[l("el-input",{attrs:{placeholder:"请输入主要景点",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.mainSpot,callback:function(t){e.$set(e.queryParams,"mainSpot",t)},expression:"queryParams.mainSpot"}})],1),l("el-form-item",{attrs:{label:"适宜游玩时间",prop:"niceTime"}},[l("el-input",{attrs:{placeholder:"请输入适宜游玩时间",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.niceTime,callback:function(t){e.$set(e.queryParams,"niceTime",t)},expression:"queryParams.niceTime"}})],1),l("el-form-item",{attrs:{label:"宗教事务",prop:"religionThing"}},[l("el-input",{attrs:{placeholder:"请输入宗教事务",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.religionThing,callback:function(t){e.$set(e.queryParams,"religionThing",t)},expression:"queryParams.religionThing"}})],1),l("el-form-item",[l("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),l("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),l("el-row",{staticClass:"mb8",attrs:{gutter:10}},[l("el-col",{attrs:{span:1.5}},[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:add"],expression:"['religion:religionArea:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),l("el-col",{attrs:{span:1.5}},[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:edit"],expression:"['religion:religionArea:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),l("el-col",{attrs:{span:1.5}},[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:remove"],expression:"['religion:religionArea:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),l("el-col",{attrs:{span:1.5}},[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:export"],expression:"['religion:religionArea:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),l("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),l("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.religionAreaList},on:{"selection-change":e.handleSelectionChange}},[l("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),l("el-table-column",{attrs:{label:"编号",align:"center",prop:"id"}}),l("el-table-column",{attrs:{label:"名称",align:"center",prop:"name"}}),l("el-table-column",{attrs:{label:"创建时间",align:"center",prop:"createTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("span",[e._v(e._s(e.parseTime(t.row.createTime,"{y}-{m}-{d} ")))])]}}])}),l("el-table-column",{attrs:{label:"更新时间",align:"center",prop:"updateTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("span",[e._v(e._s(e.parseTime(t.row.updateTime,"{y}-{m}-{d}")))])]}}])}),l("el-table-column",{attrs:{label:"状态",align:"center",prop:"status"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("dict-tag",{attrs:{options:e.dict.type.global_status,value:t.row.status}})]}}])}),l("el-table-column",{attrs:{label:"简介",align:"center",prop:"introduce"}}),l("el-table-column",{attrs:{label:"照片",align:"center",prop:"thumb",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[l("image-preview",{attrs:{src:e.row.thumb,width:50,height:50}})]}}])}),l("el-table-column",{attrs:{label:"宗教类别",align:"center",prop:"religionType"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("dict-tag",{attrs:{options:e.dict.type.religion_type,value:t.row.religionType}})]}}])}),l("el-table-column",{attrs:{label:"经度",align:"center",prop:"longitude"}}),l("el-table-column",{attrs:{label:"纬度",align:"center",prop:"latitude"}}),l("el-table-column",{attrs:{label:"景区级别",align:"center",prop:"scenicLevel"}}),l("el-table-column",{attrs:{label:"文保级别",align:"center",prop:"securityLevel"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("dict-tag",{attrs:{options:e.dict.type.security_level,value:t.row.securityLevel}})]}}])}),l("el-table-column",{attrs:{label:"门票",align:"center",prop:"ticket"}}),l("el-table-column",{attrs:{label:"始建年代",align:"center",prop:"initialTime"}}),l("el-table-column",{attrs:{label:"开发时间",align:"center",prop:"devTime"}}),l("el-table-column",{attrs:{label:"主要景点",align:"center",prop:"mainSpot"}}),l("el-table-column",{attrs:{label:"适宜游玩时间",align:"center",prop:"niceTime"}}),l("el-table-column",{attrs:{label:"宗教事务",align:"center",prop:"religionThing"}}),l("el-table-column",{attrs:{label:"备注",align:"center",prop:"remark"}}),l("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:edit"],expression:"['religion:religionArea:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(l){return e.handleUpdate(t.row)}}},[e._v("修改")]),l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["religion:religionArea:remove"],expression:"['religion:religionArea:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(l){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),l("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),l("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[l("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[l("el-form-item",{attrs:{label:"名称",prop:"name"}},[l("el-input",{attrs:{placeholder:"请输入名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),l("el-form-item",{attrs:{label:"状态"}},[l("el-radio-group",{model:{value:e.form.status,callback:function(t){e.$set(e.form,"status",t)},expression:"form.status"}},e._l(e.dict.type.global_status,(function(t){return l("el-radio",{key:t.value,attrs:{label:parseInt(t.value)}},[e._v(e._s(t.label))])})),1)],1),l("el-form-item",{attrs:{label:"简介",prop:"introduce"}},[l("el-input",{attrs:{placeholder:"请输入简介"},model:{value:e.form.introduce,callback:function(t){e.$set(e.form,"introduce",t)},expression:"form.introduce"}})],1),l("el-form-item",{attrs:{label:"照片"}},[l("image-upload",{model:{value:e.form.thumb,callback:function(t){e.$set(e.form,"thumb",t)},expression:"form.thumb"}})],1),l("el-form-item",{attrs:{label:"宗教类别",prop:"religionType"}},[l("el-select",{attrs:{placeholder:"请选择宗教类别"},model:{value:e.form.religionType,callback:function(t){e.$set(e.form,"religionType",t)},expression:"form.religionType"}},e._l(e.dict.type.religion_type,(function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),l("el-form-item",{attrs:{label:"经度",prop:"longitude"}},[l("el-input",{attrs:{placeholder:"请输入经度"},model:{value:e.form.longitude,callback:function(t){e.$set(e.form,"longitude",t)},expression:"form.longitude"}})],1),l("el-form-item",{attrs:{label:"纬度",prop:"latitude"}},[l("el-input",{attrs:{placeholder:"请输入纬度"},model:{value:e.form.latitude,callback:function(t){e.$set(e.form,"latitude",t)},expression:"form.latitude"}})],1),l("el-form-item",{attrs:{label:"景区级别",prop:"scenicLevel"}},[l("el-input",{attrs:{placeholder:"请输入景区级别"},model:{value:e.form.scenicLevel,callback:function(t){e.$set(e.form,"scenicLevel",t)},expression:"form.scenicLevel"}})],1),l("el-form-item",{attrs:{label:"文保级别",prop:"securityLevel"}},[l("el-input",{attrs:{placeholder:"请输入文保级别"},model:{value:e.form.securityLevel,callback:function(t){e.$set(e.form,"securityLevel",t)},expression:"form.securityLevel"}})],1),l("el-form-item",{attrs:{label:"门票",prop:"ticket"}},[l("el-input",{attrs:{placeholder:"请输入门票"},model:{value:e.form.ticket,callback:function(t){e.$set(e.form,"ticket",t)},expression:"form.ticket"}})],1),l("el-form-item",{attrs:{label:"始建年代",prop:"initialTime"}},[l("el-input",{attrs:{placeholder:"请输入始建年代"},model:{value:e.form.initialTime,callback:function(t){e.$set(e.form,"initialTime",t)},expression:"form.initialTime"}})],1),l("el-form-item",{attrs:{label:"开发时间",prop:"devTime"}},[l("el-input",{attrs:{placeholder:"请输入开发时间"},model:{value:e.form.devTime,callback:function(t){e.$set(e.form,"devTime",t)},expression:"form.devTime"}})],1),l("el-form-item",{attrs:{label:"主要景点",prop:"mainSpot"}},[l("el-input",{attrs:{placeholder:"请输入主要景点"},model:{value:e.form.mainSpot,callback:function(t){e.$set(e.form,"mainSpot",t)},expression:"form.mainSpot"}})],1),l("el-form-item",{attrs:{label:"适宜游玩时间",prop:"niceTime"}},[l("el-input",{attrs:{placeholder:"请输入适宜游玩时间"},model:{value:e.form.niceTime,callback:function(t){e.$set(e.form,"niceTime",t)},expression:"form.niceTime"}})],1),l("el-form-item",{attrs:{label:"宗教事务",prop:"religionThing"}},[l("el-input",{attrs:{placeholder:"请输入宗教事务"},model:{value:e.form.religionThing,callback:function(t){e.$set(e.form,"religionThing",t)},expression:"form.religionThing"}})],1),l("el-form-item",{attrs:{label:"备注",prop:"remark"}},[l("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),l("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},a=[],n=l("5530"),i=(l("d81d"),l("b775"));function o(e){return Object(i["a"])({url:"/religion/religionArea/list",method:"get",params:e})}function s(e){return Object(i["a"])({url:"/religion/religionArea/"+e,method:"get"})}function u(e){return Object(i["a"])({url:"/religion/religionArea",method:"post",data:e})}function c(e){return Object(i["a"])({url:"/religion/religionArea",method:"put",data:e})}function m(e){return Object(i["a"])({url:"/religion/religionArea/"+e,method:"delete"})}var p={name:"ReligionArea",dicts:["global_status","religion_type"],data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,religionAreaList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,name:null,status:null,introduce:null,thumb:null,religionType:null,longitude:null,latitude:null,scenicLevel:null,securityLevel:null,ticket:null,initialTime:null,devTime:null,mainSpot:null,niceTime:null,religionThing:null},form:{},rules:{name:[{required:!0,message:"名称不能为空",trigger:"blur"}]}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,o(this.queryParams).then((function(t){e.religionAreaList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,name:null,tenantId:null,createBy:null,createTime:null,updateBy:null,updateTime:null,status:1,introduce:null,thumb:null,religionType:null,longitude:null,latitude:null,scenicLevel:null,securityLevel:null,ticket:null,initialTime:null,devTime:null,mainSpot:null,niceTime:null,religionThing:null,deleted:null,remark:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加宗教场所"},handleUpdate:function(e){var t=this;this.reset();var l=e.id||this.ids;s(l).then((function(e){t.form=e.data,t.open=!0,t.title="修改宗教场所"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?c(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,l=e.id||this.ids;this.$modal.confirm('是否确认删除宗教场所编号为"'+l+'"的数据项？').then((function(){return m(l)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("religion/religionArea/export",Object(n["a"])({},this.queryParams),"religionArea_".concat((new Date).getTime(),".xlsx"))}}},d=p,f=l("2877"),y=Object(f["a"])(d,r,a,!1,null,null,null);t["default"]=y.exports}}]);