(function ($) {
    $.fn.footer = function () {
        var wheight = $(window).height();
        var bheight = $(document.body).height();
        if (wheight > bheight) {
            var contentHeight = $("#footer").prev().height();
            $("#footer").prev().css("min-height", (wheight - bheight + contentHeight));
        }
    };

    DOMAIN = '${DOMAIN}';// 域

    OSS_UTIL = {
        /**
         * Ajax Post 请求
         *
         * @param url 地址
         * @param params post参数
         * @param callbackFun 函数
         * @param type 类型: html,json
         */
        post: function (url, params, callbackFun, type) {
            if (!type) {
                type = "json";
            }
            url = url.indexOf("?") > -1 ? url + "&" : url + "?";
            url += "ts=" + new Date().getTime();
            $.post(url, params, callbackFun, type);
        }
    };
})(jQuery);
