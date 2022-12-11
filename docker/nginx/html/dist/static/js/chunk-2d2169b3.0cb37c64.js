(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d2169b3"],{c2d2:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[r("el-form-item",{attrs:{label:"商品ID",prop:"skuId"}},[r("el-input",{attrs:{placeholder:"请输入商品ID",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.skuId,callback:function(t){e.$set(e.queryParams,"skuId",t)},expression:"queryParams.skuId"}})],1),r("el-form-item",{attrs:{label:"商品标题",prop:"skuTitle"}},[r("el-input",{attrs:{placeholder:"请输入商品标题",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.skuTitle,callback:function(t){e.$set(e.queryParams,"skuTitle",t)},expression:"queryParams.skuTitle"}})],1),r("el-form-item",{attrs:{label:"原价",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入原价",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.price,callback:function(t){e.$set(e.queryParams,"price",t)},expression:"queryParams.price"}})],1),r("el-form-item",{attrs:{label:"售价",prop:"salePrice"}},[r("el-input",{attrs:{placeholder:"请输入售价",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.salePrice,callback:function(t){e.$set(e.queryParams,"salePrice",t)},expression:"queryParams.salePrice"}})],1),r("el-form-item",{attrs:{label:"乐观锁",prop:"revision"}},[r("el-input",{attrs:{placeholder:"请输入乐观锁",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.revision,callback:function(t){e.$set(e.queryParams,"revision",t)},expression:"queryParams.revision"}})],1),r("el-form-item",{attrs:{label:"创建人",prop:"createdBy"}},[r("el-input",{attrs:{placeholder:"请输入创建人",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.createdBy,callback:function(t){e.$set(e.queryParams,"createdBy",t)},expression:"queryParams.createdBy"}})],1),r("el-form-item",{attrs:{label:"创建时间",prop:"createdTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择创建时间"},model:{value:e.queryParams.createdTime,callback:function(t){e.$set(e.queryParams,"createdTime",t)},expression:"queryParams.createdTime"}})],1),r("el-form-item",{attrs:{label:"更新人",prop:"updatedBy"}},[r("el-input",{attrs:{placeholder:"请输入更新人",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.updatedBy,callback:function(t){e.$set(e.queryParams,"updatedBy",t)},expression:"queryParams.updatedBy"}})],1),r("el-form-item",{attrs:{label:"更新时间",prop:"updatedTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择更新时间"},model:{value:e.queryParams.updatedTime,callback:function(t){e.$set(e.queryParams,"updatedTime",t)},expression:"queryParams.updatedTime"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),r("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),r("el-row",{staticClass:"mb8",attrs:{gutter:10}},[r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:add"],expression:"['shop:buyerItem:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:edit"],expression:"['shop:buyerItem:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:remove"],expression:"['shop:buyerItem:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:export"],expression:"['shop:buyerItem:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),r("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.buyerItemList},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),r("el-table-column",{attrs:{label:"订单ID",align:"center",prop:"orderId"}}),r("el-table-column",{attrs:{label:"购物车ID",align:"center",prop:"cartId"}}),r("el-table-column",{attrs:{label:"明细项ID",align:"center",prop:"itemId"}}),r("el-table-column",{attrs:{label:"商品ID",align:"center",prop:"skuId"}}),r("el-table-column",{attrs:{label:"商品标题",align:"center",prop:"skuTitle"}}),r("el-table-column",{attrs:{label:"商品介绍",align:"center",prop:"skuIntro"}}),r("el-table-column",{attrs:{label:"原价",align:"center",prop:"price"}}),r("el-table-column",{attrs:{label:"售价",align:"center",prop:"salePrice"}}),r("el-table-column",{attrs:{label:"乐观锁",align:"center",prop:"revision"}}),r("el-table-column",{attrs:{label:"创建人",align:"center",prop:"createdBy"}}),r("el-table-column",{attrs:{label:"创建时间",align:"center",prop:"createdTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.createdTime,"{y}-{m}-{d}")))])]}}])}),r("el-table-column",{attrs:{label:"更新人",align:"center",prop:"updatedBy"}}),r("el-table-column",{attrs:{label:"更新时间",align:"center",prop:"updatedTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.updatedTime,"{y}-{m}-{d}")))])]}}])}),r("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:edit"],expression:"['shop:buyerItem:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(r){return e.handleUpdate(t.row)}}},[e._v("修改")]),r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:buyerItem:remove"],expression:"['shop:buyerItem:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),r("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),r("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[r("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"商品ID",prop:"skuId"}},[r("el-input",{attrs:{placeholder:"请输入商品ID"},model:{value:e.form.skuId,callback:function(t){e.$set(e.form,"skuId",t)},expression:"form.skuId"}})],1),r("el-form-item",{attrs:{label:"商品标题",prop:"skuTitle"}},[r("el-input",{attrs:{placeholder:"请输入商品标题"},model:{value:e.form.skuTitle,callback:function(t){e.$set(e.form,"skuTitle",t)},expression:"form.skuTitle"}})],1),r("el-form-item",{attrs:{label:"商品介绍",prop:"skuIntro"}},[r("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.skuIntro,callback:function(t){e.$set(e.form,"skuIntro",t)},expression:"form.skuIntro"}})],1),r("el-form-item",{attrs:{label:"原价",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入原价"},model:{value:e.form.price,callback:function(t){e.$set(e.form,"price",t)},expression:"form.price"}})],1),r("el-form-item",{attrs:{label:"售价",prop:"salePrice"}},[r("el-input",{attrs:{placeholder:"请输入售价"},model:{value:e.form.salePrice,callback:function(t){e.$set(e.form,"salePrice",t)},expression:"form.salePrice"}})],1),r("el-form-item",{attrs:{label:"乐观锁",prop:"revision"}},[r("el-input",{attrs:{placeholder:"请输入乐观锁"},model:{value:e.form.revision,callback:function(t){e.$set(e.form,"revision",t)},expression:"form.revision"}})],1),r("el-form-item",{attrs:{label:"创建人",prop:"createdBy"}},[r("el-input",{attrs:{placeholder:"请输入创建人"},model:{value:e.form.createdBy,callback:function(t){e.$set(e.form,"createdBy",t)},expression:"form.createdBy"}})],1),r("el-form-item",{attrs:{label:"创建时间",prop:"createdTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择创建时间"},model:{value:e.form.createdTime,callback:function(t){e.$set(e.form,"createdTime",t)},expression:"form.createdTime"}})],1),r("el-form-item",{attrs:{label:"更新人",prop:"updatedBy"}},[r("el-input",{attrs:{placeholder:"请输入更新人"},model:{value:e.form.updatedBy,callback:function(t){e.$set(e.form,"updatedBy",t)},expression:"form.updatedBy"}})],1),r("el-form-item",{attrs:{label:"更新时间",prop:"updatedTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择更新时间"},model:{value:e.form.updatedTime,callback:function(t){e.$set(e.form,"updatedTime",t)},expression:"form.updatedTime"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),r("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},l=[],n=r("5530"),i=(r("d81d"),r("b775"));function o(e){return Object(i["a"])({url:"/shop/buyerItem/list",method:"get",params:e})}function s(e){return Object(i["a"])({url:"/shop/buyerItem/"+e,method:"get"})}function u(e){return Object(i["a"])({url:"/shop/buyerItem",method:"post",data:e})}function c(e){return Object(i["a"])({url:"/shop/buyerItem",method:"put",data:e})}function m(e){return Object(i["a"])({url:"/shop/buyerItem/"+e,method:"delete"})}var d={name:"BuyerItem",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,buyerItemList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,skuId:null,skuTitle:null,skuIntro:null,price:null,salePrice:null,revision:null,createdBy:null,createdTime:null,updatedBy:null,updatedTime:null},form:{},rules:{}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,o(this.queryParams).then((function(t){e.buyerItemList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={orderId:null,cartId:null,itemId:null,skuId:null,skuTitle:null,skuIntro:null,price:null,salePrice:null,revision:null,createdBy:null,createdTime:null,updatedBy:null,updatedTime:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.orderId})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加购买明细"},handleUpdate:function(e){var t=this;this.reset();var r=e.orderId||this.ids;s(r).then((function(e){t.form=e.data,t.open=!0,t.title="修改购买明细"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.orderId?c(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,r=e.orderId||this.ids;this.$modal.confirm('是否确认删除购买明细编号为"'+r+'"的数据项？').then((function(){return m(r)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("shop/buyerItem/export",Object(n["a"])({},this.queryParams),"buyerItem_".concat((new Date).getTime(),".xlsx"))}}},p=d,y=r("2877"),f=Object(y["a"])(p,a,l,!1,null,null,null);t["default"]=f.exports}}]);