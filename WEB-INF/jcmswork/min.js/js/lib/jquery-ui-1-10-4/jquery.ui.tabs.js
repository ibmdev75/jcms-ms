/*!
 * jQuery UI Tabs 1.10.4
 * http://jqueryui.com
 *
 * Copyright 2014 jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 *
 * http://api.jqueryui.com/tabs/
 *
 * Depends:
 *	jquery.ui.core.js
 *	jquery.ui.widget.js
 */
(function(c,e){var a=0,f=/#.*$/;function d(){return ++a}function b(g){g=g.cloneNode(false);return g.hash.length>1&&decodeURIComponent(g.href.replace(f,""))===decodeURIComponent(location.href.replace(f,""))}c.widget("ui.tabs",{version:"1.10.4",delay:300,options:{active:null,collapsible:false,event:"click",heightStyle:"content",hide:null,show:null,activate:null,beforeActivate:null,beforeLoad:null,load:null},_create:function(){var h=this,g=this.options;this.running=false;this.element.addClass("ui-tabs ui-widget ui-widget-content ui-corner-all").toggleClass("ui-tabs-collapsible",g.collapsible).delegate(".ui-tabs-nav > li","mousedown"+this.eventNamespace,function(i){if(c(this).is(".ui-state-disabled")){i.preventDefault()}}).delegate(".ui-tabs-anchor","focus"+this.eventNamespace,function(){if(c(this).closest("li").is(".ui-state-disabled")){this.blur()}});this._processTabs();g.active=this._initialActive();if(c.isArray(g.disabled)){g.disabled=c.unique(g.disabled.concat(c.map(this.tabs.filter(".ui-state-disabled"),function(i){return h.tabs.index(i)}))).sort()}if(this.options.active!==false&&this.anchors.length){this.active=this._findActive(g.active)}else{this.active=c()}this._refresh();if(this.active.length){this.load(g.active)}},_initialActive:function(){var h=this.options.active,g=this.options.collapsible,i=location.hash.substring(1);if(h===null){if(i){this.tabs.each(function(j,k){if(c(k).attr("aria-controls")===i){h=j;return false}})}if(h===null){h=this.tabs.index(this.tabs.filter(".ui-tabs-active"))}if(h===null||h===-1){h=this.tabs.length?0:false}}if(h!==false){h=this.tabs.index(this.tabs.eq(h));if(h===-1){h=g?false:0}}if(!g&&h===false&&this.anchors.length){h=0}return h},_getCreateEventData:function(){return{tab:this.active,panel:!this.active.length?c():this._getPanelForTab(this.active)}},_tabKeydown:function(i){var h=c(this.document[0].activeElement).closest("li"),g=this.tabs.index(h),j=true;if(this._handlePageNav(i)){return}switch(i.keyCode){case c.ui.keyCode.RIGHT:case c.ui.keyCode.DOWN:g++;break;case c.ui.keyCode.UP:case c.ui.keyCode.LEFT:j=false;g--;break;case c.ui.keyCode.END:g=this.anchors.length-1;break;case c.ui.keyCode.HOME:g=0;break;case c.ui.keyCode.SPACE:i.preventDefault();clearTimeout(this.activating);this._activate(g);return;case c.ui.keyCode.ENTER:i.preventDefault();clearTimeout(this.activating);this._activate(g===this.options.active?false:g);return;default:return}i.preventDefault();clearTimeout(this.activating);g=this._focusNextTab(g,j);if(!i.ctrlKey){h.attr("aria-selected","false");this.tabs.eq(g).attr("aria-selected","true");this.activating=this._delay(function(){this.option("active",g)},this.delay)}},_panelKeydown:function(g){if(this._handlePageNav(g)){return}if(g.ctrlKey&&g.keyCode===c.ui.keyCode.UP){g.preventDefault();this.active.focus()}},_handlePageNav:function(g){if(g.altKey&&g.keyCode===c.ui.keyCode.PAGE_UP){this._activate(this._focusNextTab(this.options.active-1,false));return true}if(g.altKey&&g.keyCode===c.ui.keyCode.PAGE_DOWN){this._activate(this._focusNextTab(this.options.active+1,true));return true}},_findNextTab:function(h,i){var g=this.tabs.length-1;function j(){if(h>g){h=0}if(h<0){h=g}return h}while(c.inArray(j(),this.options.disabled)!==-1){h=i?h+1:h-1}return h},_focusNextTab:function(g,h){g=this._findNextTab(g,h);this.tabs.eq(g).focus();return g},_setOption:function(g,h){if(g==="active"){this._activate(h);return}if(g==="disabled"){this._setupDisabled(h);return}this._super(g,h);if(g==="collapsible"){this.element.toggleClass("ui-tabs-collapsible",h);if(!h&&this.options.active===false){this._activate(0)}}if(g==="event"){this._setupEvents(h)}if(g==="heightStyle"){this._setupHeightStyle(h)}},_tabId:function(g){return g.attr("aria-controls")||"ui-tabs-"+d()},_sanitizeSelector:function(g){return g?g.replace(/[!"$%&'()*+,.\/:;<=>?@\[\]\^`{|}~]/g,"\\$&"):""},refresh:function(){var h=this.options,g=this.tablist.children(":has(a[href])");h.disabled=c.map(g.filter(".ui-state-disabled"),function(i){return g.index(i)});this._processTabs();if(h.active===false||!this.anchors.length){h.active=false;this.active=c()}else{if(this.active.length&&!c.contains(this.tablist[0],this.active[0])){if(this.tabs.length===h.disabled.length){h.active=false;this.active=c()}else{this._activate(this._findNextTab(Math.max(0,h.active-1),false))}}else{h.active=this.tabs.index(this.active)}}this._refresh()},_refresh:function(){this._setupDisabled(this.options.disabled);this._setupEvents(this.options.event);this._setupHeightStyle(this.options.heightStyle);this.tabs.not(this.active).attr({"aria-selected":"false",tabIndex:-1});this.panels.not(this._getPanelForTab(this.active)).hide().attr({"aria-expanded":"false","aria-hidden":"true"});if(!this.active.length){this.tabs.eq(0).attr("tabIndex",0)}else{this.active.addClass("ui-tabs-active ui-state-active").attr({"aria-selected":"true",tabIndex:0});this._getPanelForTab(this.active).show().attr({"aria-expanded":"true","aria-hidden":"false"})}},_processTabs:function(){var g=this;this.tablist=this._getList().addClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all").attr("role","tablist");this.tabs=this.tablist.find("> li:has(a[href])").addClass("ui-state-default ui-corner-top").attr({role:"tab",tabIndex:-1});this.anchors=this.tabs.map(function(){return c("a",this)[0]}).addClass("ui-tabs-anchor").attr({role:"presentation",tabIndex:-1});this.panels=c();this.anchors.each(function(n,l){var h,j,m,k=c(l).uniqueId().attr("id"),o=c(l).closest("li"),p=o.attr("aria-controls");if(b(l)){h=l.hash;j=g.element.find(g._sanitizeSelector(h))}else{m=g._tabId(o);h="#"+m;j=g.element.find(h);if(!j.length){j=g._createPanel(m);j.insertAfter(g.panels[n-1]||g.tablist)}j.attr("aria-live","polite")}if(j.length){g.panels=g.panels.add(j)}if(p){o.data("ui-tabs-aria-controls",p)}o.attr({"aria-controls":h.substring(1),"aria-labelledby":k});j.attr("aria-labelledby",k)});this.panels.addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").attr("role","tabpanel")},_getList:function(){return this.tablist||this.element.find("ol,ul").eq(0)},_createPanel:function(g){return c("<div>").attr("id",g).addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").data("ui-tabs-destroy",true)},_setupDisabled:function(j){if(c.isArray(j)){if(!j.length){j=false}else{if(j.length===this.anchors.length){j=true}}}for(var h=0,g;(g=this.tabs[h]);h++){if(j===true||c.inArray(h,j)!==-1){c(g).addClass("ui-state-disabled").attr("aria-disabled","true")}else{c(g).removeClass("ui-state-disabled").removeAttr("aria-disabled")}}this.options.disabled=j},_setupEvents:function(h){var g={click:function(i){i.preventDefault()}};if(h){c.each(h.split(" "),function(j,i){g[i]="_eventHandler"})}this._off(this.anchors.add(this.tabs).add(this.panels));this._on(this.anchors,g);this._on(this.tabs,{keydown:"_tabKeydown"});this._on(this.panels,{keydown:"_panelKeydown"});this._focusable(this.tabs);this._hoverable(this.tabs)},_setupHeightStyle:function(g){var i,h=this.element.parent();if(g==="fill"){i=h.height();i-=this.element.outerHeight()-this.element.height();this.element.siblings(":visible").each(function(){var k=c(this),j=k.css("position");if(j==="absolute"||j==="fixed"){return}i-=k.outerHeight(true)});this.element.children().not(this.panels).each(function(){i-=c(this).outerHeight(true)});this.panels.each(function(){c(this).height(Math.max(0,i-c(this).innerHeight()+c(this).height()))}).css("overflow","auto")}else{if(g==="auto"){i=0;this.panels.each(function(){i=Math.max(i,c(this).height("").height())}).height(i)}}},_eventHandler:function(g){var p=this.options,k=this.active,l=c(g.currentTarget),j=l.closest("li"),n=j[0]===k[0],h=n&&p.collapsible,i=h?c():this._getPanelForTab(j),m=!k.length?c():this._getPanelForTab(k),o={oldTab:k,oldPanel:m,newTab:h?c():j,newPanel:i};g.preventDefault();if(j.hasClass("ui-state-disabled")||j.hasClass("ui-tabs-loading")||this.running||(n&&!p.collapsible)||(this._trigger("beforeActivate",g,o)===false)){return}p.active=h?false:this.tabs.index(j);this.active=n?c():j;if(this.xhr){this.xhr.abort()}if(!m.length&&!i.length){c.error("jQuery UI Tabs: Mismatching fragment identifier.")}if(i.length){this.load(this.tabs.index(j),g)}this._toggle(g,o)},_toggle:function(m,l){var k=this,g=l.newPanel,j=l.oldPanel;this.running=true;function i(){k.running=false;k._trigger("activate",m,l)}function h(){l.newTab.closest("li").addClass("ui-tabs-active ui-state-active");if(g.length&&k.options.show){k._show(g,k.options.show,i)}else{g.show();i()}}if(j.length&&this.options.hide){this._hide(j,this.options.hide,function(){l.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");h()})}else{l.oldTab.closest("li").removeClass("ui-tabs-active ui-state-active");j.hide();h()}j.attr({"aria-expanded":"false","aria-hidden":"true"});l.oldTab.attr("aria-selected","false");if(g.length&&j.length){l.oldTab.attr("tabIndex",-1)}else{if(g.length){this.tabs.filter(function(){return c(this).attr("tabIndex")===0}).attr("tabIndex",-1)}}g.attr({"aria-expanded":"true","aria-hidden":"false"});l.newTab.attr({"aria-selected":"true",tabIndex:0})},_activate:function(h){var g,i=this._findActive(h);if(i[0]===this.active[0]){return}if(!i.length){i=this.active}g=i.find(".ui-tabs-anchor")[0];this._eventHandler({target:g,currentTarget:g,preventDefault:c.noop})},_findActive:function(g){return g===false?c():this.tabs.eq(g)},_getIndex:function(g){if(typeof g==="string"){g=this.anchors.index(this.anchors.filter("[href$='"+g+"']"))}return g},_destroy:function(){if(this.xhr){this.xhr.abort()}this.element.removeClass("ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-collapsible");this.tablist.removeClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all").removeAttr("role");this.anchors.removeClass("ui-tabs-anchor").removeAttr("role").removeAttr("tabIndex").removeUniqueId();this.tabs.add(this.panels).each(function(){if(c.data(this,"ui-tabs-destroy")){c(this).remove()}else{c(this).removeClass("ui-state-default ui-state-active ui-state-disabled ui-corner-top ui-corner-bottom ui-widget-content ui-tabs-active ui-tabs-panel").removeAttr("tabIndex").removeAttr("aria-live").removeAttr("aria-busy").removeAttr("aria-selected").removeAttr("aria-labelledby").removeAttr("aria-hidden").removeAttr("aria-expanded").removeAttr("role")}});this.tabs.each(function(){var g=c(this),h=g.data("ui-tabs-aria-controls");if(h){g.attr("aria-controls",h).removeData("ui-tabs-aria-controls")}else{g.removeAttr("aria-controls")}});this.panels.show();if(this.options.heightStyle!=="content"){this.panels.css("height","")}},enable:function(g){var h=this.options.disabled;if(h===false){return}if(g===e){h=false}else{g=this._getIndex(g);if(c.isArray(h)){h=c.map(h,function(i){return i!==g?i:null})}else{h=c.map(this.tabs,function(i,j){return j!==g?j:null})}}this._setupDisabled(h)},disable:function(g){var h=this.options.disabled;if(h===true){return}if(g===e){h=true}else{g=this._getIndex(g);if(c.inArray(g,h)!==-1){return}if(c.isArray(h)){h=c.merge([g],h).sort()}else{h=[g]}}this._setupDisabled(h)},load:function(i,m){i=this._getIndex(i);var l=this,j=this.tabs.eq(i),h=j.find(".ui-tabs-anchor"),g=this._getPanelForTab(j),k={tab:j,panel:g};if(b(h[0])){return}this.xhr=c.ajax(this._ajaxSettings(h,m,k));if(this.xhr&&this.xhr.statusText!=="canceled"){j.addClass("ui-tabs-loading");g.attr("aria-busy","true");this.xhr.success(function(n){setTimeout(function(){g.html(n);l._trigger("load",m,k)},1)}).complete(function(o,n){setTimeout(function(){if(n==="abort"){l.panels.stop(false,true)}j.removeClass("ui-tabs-loading");g.removeAttr("aria-busy");if(o===l.xhr){delete l.xhr}},1)})}},_ajaxSettings:function(g,j,i){var h=this;return{url:g.attr("href"),beforeSend:function(l,k){return h._trigger("beforeLoad",j,c.extend({jqXHR:l,ajaxSettings:k},i))}}},_getPanelForTab:function(g){var h=c(g).attr("aria-controls");return this.element.find(this._sanitizeSelector("#"+h))}})})(jQuery);