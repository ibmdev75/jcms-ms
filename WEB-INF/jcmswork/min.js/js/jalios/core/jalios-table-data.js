!function(b){var a=function(){c();b(document).on("jalios:refresh",c)};var c=function(){b(".table-data th .sort-link").each(function(d){var f=b(this).closest("th");var e=b(this).find(".pager-sort-active").exists();f.addClass("th-sort").addClass(e?"th-sort-active":"th-sort-inactive")})};b(document).ready(function(d){a()})}(window.jQuery);