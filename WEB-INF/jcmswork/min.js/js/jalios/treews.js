"JCMS.treews"._namespace();JCMS.treews.TreeHelper={addClassOpenGroup:function(b){var a=b.href;b.href=a+"&classForOpenNodes="+encodeURIComponent($("hiddenDivForOpenNodes").className);return true},toggleWSDiv:function(b){var a=$("hiddenDivForOpenNodes");if(!a){return}a.toggleClassName("openWSNode"+b);return true},toggleGrpDiv:function(d,c){var b=$(d).fastUp("DIV","wsgroupset",false);b.toggleClassName("open");var a=$("hiddenDivForOpenNodes");if(!a){return}a.toggleClassName("openGroupsOf"+c);return true}};