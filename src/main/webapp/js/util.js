/**
 * 用于完成对Ajax的通用封装
 * @param url
 * @param method
 * @param data
 * @param callback
 * @returns
 */
function myAjax(url,method,data,callback){
    let contentType="application/json";
    let options={url:url,type:method,contentType:contentType};
    if(data!=null) options.data=JSON.stringify(data);
    $.ajax(options)
        .done(function (obj) {
            callback(obj);
        })
}
/**
 * 用于将form中的域转换为JSON
 */
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};