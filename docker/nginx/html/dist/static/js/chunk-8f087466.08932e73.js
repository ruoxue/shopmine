(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8f087466"],{"04cb":function(e,t,r){"use strict";r.r(t);var l=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[r("el-form-item",{attrs:{label:"店铺",prop:"shopId"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择店铺",clearable:""},model:{value:e.queryParams.shopId,callback:function(t){e.$set(e.queryParams,"shopId",t)},expression:"queryParams.shopId"}},e._l(e.shopIdOptions,(function(e,t){return r("el-option",{key:t,attrs:{label:e.shopName,value:e.shopId,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"标题",prop:"title"}},[r("el-input",{attrs:{placeholder:"请输入标题",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.title,callback:function(t){e.$set(e.queryParams,"title",t)},expression:"queryParams.title"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),r("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),r("el-row",{staticClass:"mb8",attrs:{gutter:10}},[r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:add"],expression:"['shop:product:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:edit"],expression:"['shop:product:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:remove"],expression:"['shop:product:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:export"],expression:"['shop:product:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),r("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.productList},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),r("el-table-column",{attrs:{label:"店铺",align:"center",prop:"shopName"}}),r("el-table-column",{attrs:{label:"商品类型",align:"center",prop:"type"}}),r("el-table-column",{attrs:{label:"标题",align:"center",prop:"title"}}),r("el-table-column",{attrs:{label:"短标题",align:"center",prop:"shortTitle"}}),r("el-table-column",{attrs:{label:"商品状态",align:"center",prop:"status"}}),r("el-table-column",{attrs:{label:"上架时间",align:"center",prop:"putawayTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.putawayTime,"{y}-{m}-{d}")))])]}}])}),r("el-table-column",{attrs:{label:"商品主图",align:"center",prop:"thumb",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[r("image-preview",{attrs:{src:e.row.thumb,width:50,height:50}})]}}])}),r("el-table-column",{attrs:{label:"售卖价格",align:"center",prop:"price"}}),r("el-table-column",{attrs:{label:"成本价",align:"center",prop:"costPrice"}}),r("el-table-column",{attrs:{label:"商品编码",align:"center",prop:"productCode"}}),r("el-table-column",{attrs:{label:"销量",align:"center",prop:"salesCount"}}),r("el-table-column",{attrs:{label:"已出售数",align:"center",prop:"virtualSales"}}),r("el-table-column",{attrs:{label:"下架时间",align:"center",prop:"endTime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.endTime,"{y}-{m}-{d}")))])]}}])}),r("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:edit"],expression:"['shop:product:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(r){return e.handleUpdate(t.row)}}},[e._v("修改")]),r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["shop:product:remove"],expression:"['shop:product:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),r("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),r("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[r("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"标题",prop:"title"}},[r("el-input",{attrs:{placeholder:"请输入标题"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),r("el-form-item",{attrs:{label:"副标题",prop:"subTitle"}},[r("el-input",{attrs:{placeholder:"请输入副标题"},model:{value:e.form.subTitle,callback:function(t){e.$set(e.form,"subTitle",t)},expression:"form.subTitle"}})],1),r("el-form-item",{attrs:{label:"短标题",prop:"shortTitle"}},[r("el-input",{attrs:{placeholder:"请输入短标题"},model:{value:e.form.shortTitle,callback:function(t){e.$set(e.form,"shortTitle",t)},expression:"form.shortTitle"}})],1),r("el-form-item",{attrs:{label:"店铺",prop:"shopId"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择店铺",clearable:""},model:{value:e.form.shopId,callback:function(t){e.$set(e.form,"shopId",t)},expression:"form.shopId"}},e._l(e.shopIdOptions,(function(e,t){return r("el-option",{key:t,attrs:{label:e.shopName,value:e.shopId,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"分类",prop:"categoryId"}},[r("el-cascader",{style:{width:"100%"},attrs:{options:e.categoryIdOptions,props:e.categoryIdProps,placeholder:"请输入分类",clearable:""},model:{value:e.form.categoryId,callback:function(t){e.$set(e.form,"categoryId",t)},expression:"form.categoryId"}})],1),r("el-form-item",{attrs:{label:"首图视频"}},[r("file-upload",{model:{value:e.form.video,callback:function(t){e.$set(e.form,"video",t)},expression:"form.video"}})],1),r("el-form-item",{attrs:{label:"视频封面图"}},[r("image-upload",{model:{value:e.form.videoThumb,callback:function(t){e.$set(e.form,"videoThumb",t)},expression:"form.videoThumb"}})],1),r("el-form-item",{attrs:{label:"商品主图"}},[r("image-upload",{model:{value:e.form.thumb,callback:function(t){e.$set(e.form,"thumb",t)},expression:"form.thumb"}})],1),r("el-form-item",{attrs:{label:"商品轮播图"}},[r("image-upload",{model:{value:e.form.thumbs,callback:function(t){e.$set(e.form,"thumbs",t)},expression:"form.thumbs"}})],1),r("el-form-item",{attrs:{label:"售卖价格",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入售卖价格"},model:{value:e.form.price,callback:function(t){e.$set(e.form,"price",t)},expression:"form.price"}})],1),r("el-form-item",{attrs:{label:"成本价",prop:"costPrice"}},[r("el-input",{attrs:{placeholder:"请输入成本价"},model:{value:e.form.costPrice,callback:function(t){e.$set(e.form,"costPrice",t)},expression:"form.costPrice"}})],1),r("el-form-item",{attrs:{label:"是否开启限购",prop:"isBuyNumLimit"}},[r("el-input",{attrs:{placeholder:"请输入是否开启限购 1:限购 0:不限购"},model:{value:e.form.isBuyNumLimit,callback:function(t){e.$set(e.form,"isBuyNumLimit",t)},expression:"form.isBuyNumLimit"}})],1),r("el-form-item",{attrs:{label:"每人限购数",prop:"maxBuyTotal"}},[r("el-input",{attrs:{placeholder:"请输入每人限购数量上限"},model:{value:e.form.maxBuyTotal,callback:function(t){e.$set(e.form,"maxBuyTotal",t)},expression:"form.maxBuyTotal"}})],1),r("el-form-item",{attrs:{label:"单次限购数",prop:"maxBuyOnce"}},[r("el-input",{attrs:{placeholder:"请输入单次下单购买限购数量"},model:{value:e.form.maxBuyOnce,callback:function(t){e.$set(e.form,"maxBuyOnce",t)},expression:"form.maxBuyOnce"}})],1),r("el-form-item",{attrs:{label:"起购数量",prop:"minBuy"}},[r("el-input",{attrs:{placeholder:"请输入起购数量"},model:{value:e.form.minBuy,callback:function(t){e.$set(e.form,"minBuy",t)},expression:"form.minBuy"}})],1),r("el-form-item",{attrs:{label:"商品详情"}},[r("editor",{attrs:{"min-height":192},model:{value:e.form.content,callback:function(t){e.$set(e.form,"content",t)},expression:"form.content"}})],1),r("el-form-item",{attrs:{label:"上架时间",prop:"putawayTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择上架时间"},model:{value:e.form.putawayTime,callback:function(t){e.$set(e.form,"putawayTime",t)},expression:"form.putawayTime"}})],1),r("el-form-item",{attrs:{label:"下架时间",prop:"endTime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择下架时间"},model:{value:e.form.endTime,callback:function(t){e.$set(e.form,"endTime",t)},expression:"form.endTime"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),r("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},i=[],a=r("5530"),o=(r("d81d"),r("b775"));function n(e){return Object(o["a"])({url:"/shop/product/list",method:"get",params:e})}function s(e){return Object(o["a"])({url:"/shop/product/"+e,method:"get"})}function u(e){return Object(o["a"])({url:"/shop/product",method:"post",data:e})}function c(e){return Object(o["a"])({url:"/shop/product",method:"put",data:e})}function m(e){return Object(o["a"])({url:"/shop/product/"+e,method:"delete"})}var d=r("4d75"),p=r("7dd9"),h={name:"Product",data:function(){return{categoryIdOptions:[],categoryIdProps:{multiple:!1,value:"id",label:"name"},shopIdOptions:[{shopName:"无",shopId:0}],loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,productList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,shopId:null,displayOrder:null,type:null,title:null,subTitle:null,shortTitle:null,status:null,putawayTime:null,video:null,videoThumb:null,thumb:null,thumbs:null,price:null,originalPrice:null,costPrice:null,priceHide:null,minPrice:null,maxPrice:null,hasOption:null,productCode:null,productSn:null,stock:null,stockWarning:null,stockHide:null,stockCnf:null,salesCount:null,salesHide:null,virtualSales:null,unit:null,weight:null,volume:null,autoComplete:null,dispatchType:null,dispatchPrice:null,dispatchId:null,dispatchMode:null,defaultDispatchMode:null,dispatchHide:null,isBuyNumLimit:null,maxBuyTotal:null,maxBuyOnce:null,minBuy:null,content:null,viewCount:null,isRefundSupport:null,relatedGoods:null,auditStatus:null,refuseReason:null,version:null,selloutTime:null,deleteTime:null,endTime:null},form:{},rules:{categoryId:[{required:!0,type:"array",message:"请至少选择一个categoryId",trigger:"change"}],shopId:[{required:!0,message:"店铺ID不能为空",trigger:"blur"}],displayOrder:[{required:!0,message:"$comment不能为空",trigger:"blur"}],type:[{required:!0,message:"商品类型 1:实物 2:虚拟商品 3:电子卡密不能为空",trigger:"change"}],title:[{required:!0,message:"标题不能为空",trigger:"blur"}],subTitle:[{required:!0,message:"副标题不能为空",trigger:"blur"}],shortTitle:[{required:!0,message:"短标题不能为空",trigger:"blur"}],status:[{required:!0,message:"商品状态 0:放置仓库 1:上架售卖 2:上架隐藏 3:定时上架 -1:后台删除不能为空",trigger:"blur"}],putawayTime:[{required:!0,message:"上架时间不能为空",trigger:"blur"}],video:[{required:!0,message:"首图视频不能为空",trigger:"blur"}],videoThumb:[{required:!0,message:"视频封面图不能为空",trigger:"blur"}],thumb:[{required:!0,message:"商品主图不能为空",trigger:"blur"}],price:[{required:!0,message:"售卖价格不能为空",trigger:"blur"}],originalPrice:[{required:!0,message:"划线价格不能为空",trigger:"blur"}],costPrice:[{required:!0,message:"成本价不能为空",trigger:"blur"}],priceHide:[{required:!0,message:"$comment不能为空",trigger:"blur"}],minPrice:[{required:!0,message:"$comment不能为空",trigger:"blur"}],maxPrice:[{required:!0,message:"$comment不能为空",trigger:"blur"}],hasOption:[{required:!0,message:"规格类型 1:多规格商品 0:无规格不能为空",trigger:"blur"}],productCode:[{required:!0,message:"商品编码 格式:XXXX-YYYYYYYY-ZZ不能为空",trigger:"blur"}],productSn:[{required:!0,message:"商品条形码不能为空",trigger:"blur"}],stock:[{required:!0,message:"商品库存不能为空",trigger:"blur"}],stockWarning:[{required:!0,message:"库存预警不能为空",trigger:"blur"}],stockHide:[{required:!0,message:"商品详情隐藏库存 1:隐藏 0:不隐藏不能为空",trigger:"blur"}],stockCnf:[{required:!0,message:"$comment不能为空",trigger:"blur"}],salesCount:[{required:!0,message:"销量不能为空",trigger:"blur"}],salesHide:[{required:!0,message:"商品详情隐藏销量 1:隐藏 0:不隐藏不能为空",trigger:"blur"}],virtualSales:[{required:!0,message:"已出售数不能为空",trigger:"blur"}],unit:[{required:!0,message:"单位不能为空",trigger:"blur"}],weight:[{required:!0,message:"重量(千克)不能为空",trigger:"blur"}],volume:[{required:!0,message:"体积(m³)不能为空",trigger:"blur"}],autoComplete:[{required:!0,message:"$comment不能为空",trigger:"blur"}],dispatchType:[{required:!0,message:"快递运费类型 0:运费模板 1:统一运费不能为空",trigger:"change"}],dispatchPrice:[{required:!0,message:"运费价格不能为空",trigger:"blur"}],dispatchHide:[{required:!0,message:"商品详情隐藏快递 1:隐藏 0:不隐藏不能为空",trigger:"blur"}],isBuyNumLimit:[{required:!0,message:"是否开启限购 1:限购 0:不限购不能为空",trigger:"blur"}],maxBuyTotal:[{required:!0,message:"每人限购数量上限不能为空",trigger:"blur"}],maxBuyOnce:[{required:!0,message:"单次下单购买限购数量不能为空",trigger:"blur"}],minBuy:[{required:!0,message:"起购数量不能为空",trigger:"blur"}],content:[{required:!0,message:"商品详情不能为空",trigger:"blur"}],viewCount:[{required:!0,message:"浏览数不能为空",trigger:"blur"}],isRefundSupport:[{required:!0,message:"是否支持售后维权 1:支持 0:不支持不能为空",trigger:"blur"}],relatedGoods:[{required:!0,message:"关联商品不能为空",trigger:"blur"}],auditStatus:[{required:!0,message:"$comment不能为空",trigger:"blur"}],refuseReason:[{required:!0,message:"$comment不能为空",trigger:"blur"}],version:[{required:!0,message:"商品版本号不能为空",trigger:"blur"}],selloutTime:[{required:!0,message:"售罄时间不能为空",trigger:"blur"}],deleteTime:[{required:!0,message:"删除时间不能为空",trigger:"blur"}],createTime:[{required:!0,message:"创建时间不能为空",trigger:"blur"}],updateTime:[{required:!0,message:"修改时间不能为空",trigger:"blur"}]}}},created:function(){this.getList(),this.getCategoryIdOptions(),this.getShopIdOptions()},methods:{getShopIdOptions:function(){var e=this;Object(p["d"])().then((function(t){e.shopIdOptions=t.rows}))},getCategoryIdOptions:function(){var e=this;Object(d["d"])().then((function(t){e.categoryIdOptions=t.rows}))},getList:function(){var e=this;this.loading=!0,n(this.queryParams).then((function(t){e.productList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,shopId:null,displayOrder:null,type:null,title:null,subTitle:null,shortTitle:null,status:1,putawayTime:null,video:null,videoThumb:null,thumb:null,thumbs:null,price:null,originalPrice:null,costPrice:null,priceHide:null,minPrice:null,maxPrice:null,hasOption:null,productCode:null,productSn:null,stock:null,stockWarning:null,stockHide:null,stockCnf:null,salesCount:null,salesHide:null,virtualSales:null,unit:null,weight:null,volume:null,autoComplete:null,dispatchType:null,dispatchPrice:null,dispatchId:null,dispatchMode:null,defaultDispatchMode:null,dispatchHide:null,isBuyNumLimit:null,maxBuyTotal:null,maxBuyOnce:null,minBuy:null,content:null,viewCount:null,isRefundSupport:null,relatedGoods:null,auditstatus:1,refuseReason:null,version:null,selloutTime:null,deleteTime:null,createTime:null,updateTime:null,endTime:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加商品基础信息"},handleUpdate:function(e){var t=this;this.reset();var r=e.id||this.ids;s(r).then((function(e){t.form=e.data,t.open=!0,t.title="修改商品基础信息"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?c(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,r=e.id||this.ids;this.$modal.confirm('是否确认删除商品基础信息编号为"'+r+'"的数据项？').then((function(){return m(r)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("shop/product/export",Object(a["a"])({},this.queryParams),"product_".concat((new Date).getTime(),".xlsx"))}}},g=h,f=r("2877"),b=Object(f["a"])(g,l,i,!1,null,null,null);t["default"]=b.exports},"4d75":function(e,t,r){"use strict";r.d(t,"d",(function(){return i})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return o})),r.d(t,"e",(function(){return n})),r.d(t,"b",(function(){return s}));var l=r("b775");function i(e){return Object(l["a"])({url:"/shop/productCategory/list",method:"get",params:e})}function a(e){return Object(l["a"])({url:"/shop/productCategory/"+e,method:"get"})}function o(e){return Object(l["a"])({url:"/shop/productCategory",method:"post",data:e})}function n(e){return Object(l["a"])({url:"/shop/productCategory",method:"put",data:e})}function s(e){return Object(l["a"])({url:"/shop/productCategory/"+e,method:"delete"})}},"7dd9":function(e,t,r){"use strict";r.d(t,"d",(function(){return i})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return o})),r.d(t,"e",(function(){return n})),r.d(t,"b",(function(){return s}));var l=r("b775");function i(e){return Object(l["a"])({url:"/shop/productShop/list",method:"get",params:e})}function a(e){return Object(l["a"])({url:"/shop/productShop/"+e,method:"get"})}function o(e){return Object(l["a"])({url:"/shop/productShop",method:"post",data:e})}function n(e){return Object(l["a"])({url:"/shop/productShop",method:"put",data:e})}function s(e){return Object(l["a"])({url:"/shop/productShop/"+e,method:"delete"})}}}]);