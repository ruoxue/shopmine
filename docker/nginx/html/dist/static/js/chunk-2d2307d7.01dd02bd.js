(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d2307d7"],{ed02:function(e,t,r){"use strict";r.r(t);var l=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[r("el-form-item",{attrs:{label:"店铺ID",prop:"shopId"}},[r("el-input",{attrs:{placeholder:"请输入店铺ID",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.shopId,callback:function(t){e.$set(e.queryParams,"shopId",t)},expression:"queryParams.shopId"}})],1),r("el-form-item",{attrs:{label:"规格名称",prop:"title"}},[r("el-input",{attrs:{placeholder:"请输入规格名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.title,callback:function(t){e.$set(e.queryParams,"title",t)},expression:"queryParams.title"}})],1),r("el-form-item",{attrs:{label:"规格图片链接",prop:"thumb"}},[r("el-input",{attrs:{placeholder:"请输入规格图片链接",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.thumb,callback:function(t){e.$set(e.queryParams,"thumb",t)},expression:"queryParams.thumb"}})],1),r("el-form-item",{attrs:{label:"售卖价格",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入售卖价格",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.price,callback:function(t){e.$set(e.queryParams,"price",t)},expression:"queryParams.price"}})],1),r("el-form-item",{attrs:{label:"成本价",prop:"costPrice"}},[r("el-input",{attrs:{placeholder:"请输入成本价",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.costPrice,callback:function(t){e.$set(e.queryParams,"costPrice",t)},expression:"queryParams.costPrice"}})],1),r("el-form-item",{attrs:{label:"划线价格",prop:"originalPrice"}},[r("el-input",{attrs:{placeholder:"请输入划线价格",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.originalPrice,callback:function(t){e.$set(e.queryParams,"originalPrice",t)},expression:"queryParams.originalPrice"}})],1),r("el-form-item",{attrs:{label:"商品编码 格式:XXXX-YYYYYYYY-ZZ",prop:"productCode"}},[r("el-input",{attrs:{placeholder:"请输入商品编码 格式:XXXX-YYYYYYYY-ZZ",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.productCode,callback:function(t){e.$set(e.queryParams,"productCode",t)},expression:"queryParams.productCode"}})],1),r("el-form-item",{attrs:{label:"商品条形码",prop:"productSn"}},[r("el-input",{attrs:{placeholder:"请输入商品条形码",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.productSn,callback:function(t){e.$set(e.queryParams,"productSn",t)},expression:"queryParams.productSn"}})],1),r("el-form-item",{attrs:{label:"库存预警",prop:"stockWarning"}},[r("el-input",{attrs:{placeholder:"请输入库存预警",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.stockWarning,callback:function(t){e.$set(e.queryParams,"stockWarning",t)},expression:"queryParams.stockWarning"}})],1),r("el-form-item",{attrs:{label:"销量",prop:"salesCount"}},[r("el-input",{attrs:{placeholder:"请输入销量",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.salesCount,callback:function(t){e.$set(e.queryParams,"salesCount",t)},expression:"queryParams.salesCount"}})],1),r("el-form-item",{attrs:{label:"重量(千克)",prop:"weight"}},[r("el-input",{attrs:{placeholder:"请输入重量(千克)",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.weight,callback:function(t){e.$set(e.queryParams,"weight",t)},expression:"queryParams.weight"}})],1),r("el-form-item",{attrs:{label:"体积(m³)",prop:"volume"}},[r("el-input",{attrs:{placeholder:"请输入体积(m³)",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.volume,callback:function(t){e.$set(e.queryParams,"volume",t)},expression:"queryParams.volume"}})],1),r("el-form-item",{attrs:{label:"规格项id 多个值逗号分割 关联product_spec_option表主键ID",prop:"specOptionIds"}},[r("el-input",{attrs:{placeholder:"请输入规格项id 多个值逗号分割 关联product_spec_option表主键ID",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.specOptionIds,callback:function(t){e.$set(e.queryParams,"specOptionIds",t)},expression:"queryParams.specOptionIds"}})],1),r("el-form-item",{attrs:{label:"展示顺序 越小越靠前",prop:"displayOrder"}},[r("el-input",{attrs:{placeholder:"请输入展示顺序 越小越靠前",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.displayOrder,callback:function(t){e.$set(e.queryParams,"displayOrder",t)},expression:"queryParams.displayOrder"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),r("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),r("el-row",{staticClass:"mb8",attrs:{gutter:10}},[r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:add"],expression:"['shop:sku:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:edit"],expression:"['shop:sku:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:remove"],expression:"['shop:sku:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:export"],expression:"['shop:sku:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),r("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.skuList},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),r("el-table-column",{attrs:{label:"自增主键ID",align:"center",prop:"id"}}),r("el-table-column",{attrs:{label:"店铺ID",align:"center",prop:"shopId"}}),r("el-table-column",{attrs:{label:"商品ID",align:"center",prop:"goodsId"}}),r("el-table-column",{attrs:{label:"规格名称",align:"center",prop:"title"}}),r("el-table-column",{attrs:{label:"规格图片链接",align:"center",prop:"thumb"}}),r("el-table-column",{attrs:{label:"售卖价格",align:"center",prop:"price"}}),r("el-table-column",{attrs:{label:"成本价",align:"center",prop:"costPrice"}}),r("el-table-column",{attrs:{label:"划线价格",align:"center",prop:"originalPrice"}}),r("el-table-column",{attrs:{label:"商品编码 格式:XXXX-YYYYYYYY-ZZ",align:"center",prop:"productCode"}}),r("el-table-column",{attrs:{label:"商品条形码",align:"center",prop:"productSn"}}),r("el-table-column",{attrs:{label:"库存",align:"center",prop:"stock"}}),r("el-table-column",{attrs:{label:"库存预警",align:"center",prop:"stockWarning"}}),r("el-table-column",{attrs:{label:"销量",align:"center",prop:"salesCount"}}),r("el-table-column",{attrs:{label:"重量(千克)",align:"center",prop:"weight"}}),r("el-table-column",{attrs:{label:"体积(m³)",align:"center",prop:"volume"}}),r("el-table-column",{attrs:{label:"规格项id 多个值逗号分割 关联product_spec_option表主键ID",align:"center",prop:"specOptionIds"}}),r("el-table-column",{attrs:{label:"展示顺序 越小越靠前",align:"center",prop:"displayOrder"}}),r("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:edit"],expression:"['shop:sku:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(r){return e.handleUpdate(t.row)}}},[e._v("修改")]),r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:sku:remove"],expression:"['shop:sku:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),r("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),r("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[r("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"店铺ID",prop:"shopId"}},[r("el-input",{attrs:{placeholder:"请输入店铺ID"},model:{value:e.form.shopId,callback:function(t){e.$set(e.form,"shopId",t)},expression:"form.shopId"}})],1),r("el-form-item",{attrs:{label:"规格名称",prop:"title"}},[r("el-input",{attrs:{placeholder:"请输入规格名称"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),r("el-form-item",{attrs:{label:"规格图片链接",prop:"thumb"}},[r("el-input",{attrs:{placeholder:"请输入规格图片链接"},model:{value:e.form.thumb,callback:function(t){e.$set(e.form,"thumb",t)},expression:"form.thumb"}})],1),r("el-form-item",{attrs:{label:"售卖价格",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入售卖价格"},model:{value:e.form.price,callback:function(t){e.$set(e.form,"price",t)},expression:"form.price"}})],1),r("el-form-item",{attrs:{label:"成本价",prop:"costPrice"}},[r("el-input",{attrs:{placeholder:"请输入成本价"},model:{value:e.form.costPrice,callback:function(t){e.$set(e.form,"costPrice",t)},expression:"form.costPrice"}})],1),r("el-form-item",{attrs:{label:"划线价格",prop:"originalPrice"}},[r("el-input",{attrs:{placeholder:"请输入划线价格"},model:{value:e.form.originalPrice,callback:function(t){e.$set(e.form,"originalPrice",t)},expression:"form.originalPrice"}})],1),r("el-form-item",{attrs:{label:"商品编码 格式:XXXX-YYYYYYYY-ZZ",prop:"productCode"}},[r("el-input",{attrs:{placeholder:"请输入商品编码 格式:XXXX-YYYYYYYY-ZZ"},model:{value:e.form.productCode,callback:function(t){e.$set(e.form,"productCode",t)},expression:"form.productCode"}})],1),r("el-form-item",{attrs:{label:"商品条形码",prop:"productSn"}},[r("el-input",{attrs:{placeholder:"请输入商品条形码"},model:{value:e.form.productSn,callback:function(t){e.$set(e.form,"productSn",t)},expression:"form.productSn"}})],1),r("el-form-item",{attrs:{label:"库存预警",prop:"stockWarning"}},[r("el-input",{attrs:{placeholder:"请输入库存预警"},model:{value:e.form.stockWarning,callback:function(t){e.$set(e.form,"stockWarning",t)},expression:"form.stockWarning"}})],1),r("el-form-item",{attrs:{label:"销量",prop:"salesCount"}},[r("el-input",{attrs:{placeholder:"请输入销量"},model:{value:e.form.salesCount,callback:function(t){e.$set(e.form,"salesCount",t)},expression:"form.salesCount"}})],1),r("el-form-item",{attrs:{label:"重量(千克)",prop:"weight"}},[r("el-input",{attrs:{placeholder:"请输入重量(千克)"},model:{value:e.form.weight,callback:function(t){e.$set(e.form,"weight",t)},expression:"form.weight"}})],1),r("el-form-item",{attrs:{label:"体积(m³)",prop:"volume"}},[r("el-input",{attrs:{placeholder:"请输入体积(m³)"},model:{value:e.form.volume,callback:function(t){e.$set(e.form,"volume",t)},expression:"form.volume"}})],1),r("el-form-item",{attrs:{label:"规格项id 多个值逗号分割 关联product_spec_option表主键ID",prop:"specOptionIds"}},[r("el-input",{attrs:{placeholder:"请输入规格项id 多个值逗号分割 关联product_spec_option表主键ID"},model:{value:e.form.specOptionIds,callback:function(t){e.$set(e.form,"specOptionIds",t)},expression:"form.specOptionIds"}})],1),r("el-form-item",{attrs:{label:"展示顺序 越小越靠前",prop:"displayOrder"}},[r("el-input",{attrs:{placeholder:"请输入展示顺序 越小越靠前"},model:{value:e.form.displayOrder,callback:function(t){e.$set(e.form,"displayOrder",t)},expression:"form.displayOrder"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),r("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},a=[],n=r("5530"),o=(r("d81d"),r("b775"));function i(e){return Object(o["a"])({url:"/shop/sku/list",method:"get",params:e})}function s(e){return Object(o["a"])({url:"/shop/sku/"+e,method:"get"})}function u(e){return Object(o["a"])({url:"/shop/sku",method:"post",data:e})}function c(e){return Object(o["a"])({url:"/shop/sku",method:"put",data:e})}function p(e){return Object(o["a"])({url:"/shop/sku/"+e,method:"delete"})}var m={name:"Sku",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,skuList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,shopId:null,goodsId:null,title:null,thumb:null,price:null,costPrice:null,originalPrice:null,productCode:null,productSn:null,stock:null,stockWarning:null,salesCount:null,weight:null,volume:null,specOptionIds:null,displayOrder:null},form:{},rules:{shopId:[{required:!0,message:"店铺ID不能为空",trigger:"blur"}],goodsId:[{required:!0,message:"商品ID不能为空",trigger:"blur"}],title:[{required:!0,message:"规格名称不能为空",trigger:"blur"}],thumb:[{required:!0,message:"规格图片链接不能为空",trigger:"blur"}],price:[{required:!0,message:"售卖价格不能为空",trigger:"blur"}],costPrice:[{required:!0,message:"成本价不能为空",trigger:"blur"}],originalPrice:[{required:!0,message:"划线价格不能为空",trigger:"blur"}],productCode:[{required:!0,message:"商品编码 格式:XXXX-YYYYYYYY-ZZ不能为空",trigger:"blur"}],productSn:[{required:!0,message:"商品条形码不能为空",trigger:"blur"}],stock:[{required:!0,message:"库存不能为空",trigger:"blur"}],stockWarning:[{required:!0,message:"库存预警不能为空",trigger:"blur"}],salesCount:[{required:!0,message:"销量不能为空",trigger:"blur"}],weight:[{required:!0,message:"重量(千克)不能为空",trigger:"blur"}],volume:[{required:!0,message:"体积(m³)不能为空",trigger:"blur"}],displayOrder:[{required:!0,message:"展示顺序 越小越靠前不能为空",trigger:"blur"}],createTime:[{required:!0,message:"创建时间不能为空",trigger:"blur"}],updateTime:[{required:!0,message:"修改时间不能为空",trigger:"blur"}]}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,i(this.queryParams).then((function(t){e.skuList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,shopId:null,goodsId:null,title:null,thumb:null,price:null,costPrice:null,originalPrice:null,productCode:null,productSn:null,stock:null,stockWarning:null,salesCount:null,weight:null,volume:null,specOptionIds:null,displayOrder:null,createTime:null,updateTime:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加商品规格信息"},handleUpdate:function(e){var t=this;this.reset();var r=e.id||this.ids;s(r).then((function(e){t.form=e.data,t.open=!0,t.title="修改商品规格信息"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?c(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,r=e.id||this.ids;this.$modal.confirm('是否确认删除商品规格信息编号为"'+r+'"的数据项？').then((function(){return p(r)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("shop/sku/export",Object(n["a"])({},this.queryParams),"sku_".concat((new Date).getTime(),".xlsx"))}}},d=m,h=r("2877"),f=Object(h["a"])(d,l,a,!1,null,null,null);t["default"]=f.exports}}]);