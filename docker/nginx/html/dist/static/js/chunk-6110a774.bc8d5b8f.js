(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6110a774"],{5283:function(i,t,n){"use strict";n("cd22")},"90a9":function(i,t,n){"use strict";n.d(t,"d",(function(){return r})),n.d(t,"c",(function(){return c})),n.d(t,"a",(function(){return o})),n.d(t,"e",(function(){return a})),n.d(t,"b",(function(){return u}));var e=n("b775");function r(i){return Object(e["a"])({url:"/religion/religionSacrifice/list",method:"get",params:i})}function c(i){return Object(e["a"])({url:"/religion/religionSacrifice/"+i,method:"get"})}function o(i){return Object(e["a"])({url:"/religion/religionSacrifice",method:"post",data:i})}function a(i){return Object(e["a"])({url:"/religion/religionSacrifice",method:"put",data:i})}function u(i){return Object(e["a"])({url:"/religion/religionSacrifice/"+i,method:"delete"})}},9450:function(i,t,n){"use strict";n.r(t);var e=function(){var i=this,t=i.$createElement,n=i._self._c||t;return n("div",{staticClass:"div"},[n("TMapBig",{model:{value:i.religionSacrificeList,callback:function(t){i.religionSacrificeList=t},expression:"religionSacrificeList"}})],1)},r=[],c=n("90a9"),o={name:"mapBig",components:{},data:function(){return{religionSacrificeList:[],total:0}},created:function(){this.getList()},methods:{getList:function(){var i=this;this.loading=!0,Object(c["d"])(this.queryParams).then((function(t){i.religionSacrificeList=t.rows,i.total=t.total,i.loading=!1}))},gotobig:function(){window.location.href="http://dami.fgimax.vipnps.vip//religion/religionSacrifice/map"}}},a=o,u=(n("5283"),n("2877")),l=Object(u["a"])(a,e,r,!1,null,null,null);t["default"]=l.exports},cd22:function(i,t,n){}}]);