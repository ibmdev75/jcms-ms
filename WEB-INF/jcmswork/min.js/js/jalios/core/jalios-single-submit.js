!function(d){if(!d.jalios){d.jalios={}}if(!d.jalios.form){d.jalios.form={}}var f=function(l){var k=l.refresh;if(!k){return}if(k.type=="before"){if(!k.options||!k.options.isform){return}var j=d(k.options.isform);if(!j.exists()){return}d.jalios.form.SingleSubmit.ajaxRefreshing=true;if(j.hasClass("noSingleSubmitButton")){return}if(d.jalios.form.SingleSubmit.processing){l.preventDefault();l.stopPropagation();l.stopImmediatePropagation();return}d.jalios.form.SingleSubmit.disable()}else{if(k.type=="success"||k.type=="fail"){d.jalios.form.SingleSubmit.enable();d.jalios.form.SingleSubmit.ajaxRefreshing=false}}};var e=function(k){var j=d(k.currentTarget);if(!j.exists()){return}if(d.jalios.form.SingleSubmit.ajaxRefreshing){k.preventDefault();k.stopPropagation();k.stopImmediatePropagation();return}if(j.hasClass("noSingleSubmitButton")){return}if(d.jalios.form.SingleSubmit.processing){k.preventDefault();k.stopPropagation();k.stopImmediatePropagation();return}d.jalios.form.SingleSubmit.disable();window.onbeforeunload=null};var g=function(){d(document).on("jalios:refresh",f);d(document).on("submit","FORM",e)};var a=false;var h=function(j){if(j.keyCode==116){return}a=true};var i=function(){if(a){return true}if(typeof(tinyMCE)!=="undefined"){var j=false;jQuery.each(tinyMCE.editors,function(k,l){j|=l.isDirty()});if(j){return true}}return false};var c=function(){window.onbeforeunload=b;d(document).on("keypress",":input",h)};var b=function(){if(window.disableOnBeforeUnloadMessage){return}if(!i()){return}return I18N.glp("warn.edit.contentlost")};d.jalios.form.SingleSubmit={processing:false,enable:function(){d.jalios.form.SingleSubmit.toggle(true)},disable:function(){d.jalios.form.SingleSubmit.toggle(false)},toggle:function(j){d.jalios.form.SingleSubmit.processing=!j;d("INPUT.formButton, BUTTON.formButton, A.formButton, INPUT.btn, BUTTON.btn, A.btn").each(function(l){var m=d(this);var k=d(m.prop("form")||m.closest("FORM"));if(k.hasClass("noSingleSubmitButton")){return}m.toggleClass("disabled",!j)})},initUnload:c};d(document).ready(function(j){g()})}(window.jQuery);function initUnloadMessage(){jQuery.jalios.form.SingleSubmit.initUnload()};