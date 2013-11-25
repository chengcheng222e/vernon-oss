/**
 * 提示信息
 *
 * @param msg 提示信息
 * @param url 跳转地址
 */
function confirmPrompt(msg, url) {
    if (window.confirm(msg)) {
        window.location = encodeURI(url);
    }
}