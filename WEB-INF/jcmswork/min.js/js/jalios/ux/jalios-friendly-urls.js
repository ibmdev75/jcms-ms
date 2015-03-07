!function(d){var h={_availabilityCache:{},_cacheAvailability:function(k,j){this._availabilityCache[k]=j;return j},isFriendlyURLAvailable:function(l,m){var p=this._availabilityCache[m];if(p!=undefined){return p}var j=true;try{var o=(new Date()).getTime();j=JcmsJsContext.getJsonRPC().FriendlyURLFilter.isFriendlyURLAvailable(l,m);var k=(new Date()).getTime()}catch(n){}return this._cacheAvailability(m,!!j)},_validityCache:{},_cacheValidity:function(j,k){this._validityCache[j]=k;return k},isFriendlyURLValid:function(l){var o=this._validityCache[l];if(o!=undefined){return o}var j=true;try{var n=(new Date()).getTime();j=JcmsJsContext.getJsonRPC().FriendlyURLFilter.isFriendlyURLValid(l);var k=(new Date()).getTime()}catch(m){}return this._cacheValidity(l,!!j)}};var c=700;var g=null;var e=null;var f=function(j){if(g){clearTimeout(g);g=null}g=setTimeout(i,c);e=j.target.id};var a=null;var i=function(){d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow");var j=d(".newFriendlyURLInvalidWarning");var k=d(".newFriendlyURLExistWarning");var l=d("#"+e);if(!l.exists()||l.val()===""){d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow","missing or empty, hide all msgs");j.addClass("hide");k.addClass("hide");a="";return}if(l.val()===a){d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow","same value as before, skip");return}if(a===null){d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow","overwrite old value ... ",a);a=l.val()}d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow","check new value...",l.val());var n=h.isFriendlyURLValid(l.val());var o=h.isFriendlyURLAvailable(l.getJcmsId(),l.val());var m=l.val()=="/";d.console.debug("EditFriendlyURL","checkAndUpdateFriendlyURLGUINow","isUrlValid",n,"isUrlAvailable",o,"isSlash",m);if(m||n){j.addClass("hide")}else{j.removeClass("hide")}if(m||o){k.addClass("hide")}else{k.removeClass("hide")}if(!m&&(!n||!o)){l.parent().addClass("has-error")}else{l.parent().removeClass("has-error")}};var b=function(){d("input[name=friendlyURL]").keydown(f)};d(document).on("jalios:ready",b)}(window.jQuery);