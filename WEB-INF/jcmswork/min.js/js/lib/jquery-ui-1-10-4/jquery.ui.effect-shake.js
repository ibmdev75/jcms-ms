/*!
 * jQuery UI Effects Shake 1.10.4
 * http://jqueryui.com
 *
 * Copyright 2014 jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 *
 * http://api.jqueryui.com/shake-effect/
 *
 * Depends:
 *	jquery.ui.effect.js
 */
(function(a,b){a.effects.effect.shake=function(l,k){var c=a(this),d=["position","top","bottom","left","right","height","width"],j=a.effects.setMode(c,l.mode||"effect"),u=l.direction||"left",e=l.distance||20,h=l.times||3,v=h*2+1,q=Math.round(l.duration/v),g=(u==="up"||u==="down")?"top":"left",f=(u==="up"||u==="left"),t={},s={},r={},p,m=c.queue(),n=m.length;a.effects.save(c,d);c.show();a.effects.createWrapper(c);t[g]=(f?"-=":"+=")+e;s[g]=(f?"+=":"-=")+e*2;r[g]=(f?"-=":"+=")+e*2;c.animate(t,q,l.easing);for(p=1;p<h;p++){c.animate(s,q,l.easing).animate(r,q,l.easing)}c.animate(s,q,l.easing).animate(t,q/2,l.easing).queue(function(){if(j==="hide"){c.hide()}a.effects.restore(c,d);a.effects.removeWrapper(c);k()});if(n>1){m.splice.apply(m,[1,0].concat(m.splice(n,v+1)))}c.dequeue()}})(jQuery);