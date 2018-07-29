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
 * @param form
 * @returns
 */
function form2json(form) {
    let obj={};
    $.each(form.children("[type!=submit]"),(index,item)=>{
        let $item=$(item);
        obj[[$item.attr("name")]]=$item.val();

    })
    return obj;
}
/**
 * 采用观察者模式，完成了模型，可用于通用项目
 * @param comp
 * @returns
 */
function Model(comp) {
    Array.call(this);
    if(typeof this.add!='function'){
        Model.prototype.add=function (c) {
            this.push(c)
            comp.render();
        }
    }
    if(typeof this.urd!='function'){
        Model.prototype.urd=function () {
            [].splice.apply(this,arguments);
            comp.render();
        }
    }
    if(typeof this.pushArray!='function'){
        Model.prototype.pushArray=function () {
            [].push.apply(this,arguments[0]);
            comp.render();
        }
    }
}
Model.prototype=new Array();


/**
 * 本页面中的“容器性质”的Component
 * @param $view
 * @param url
 * @returns
 */
function AppComponent($view,url) {
	//闭包形式，公开私有函数，用于数据更新出现错误时，调用
	this.refresh=refresh;
	//mv的绑定点，实现观察者模式
    let model=new Model(this);
    let updateComponent=null;
    new AddFormComponet($view.find("#addForm"),model,url);
    updateComponent=new UpdateFormComponet($view.find("#updateForm"),model,url);
    refresh();//此处无法使用this指针，所以需要用闭包公开
    //前端数据洗白
    function refresh(){
	    	myAjax(url,"GET",null, data=> {
	    		model.length=0;
	        model.pushArray(data);
	    });
    }
   //此render用于实现：观察者模式中的“Observer接口的接收通知方法”
    this.render=function () {
        let $tbody=$view.find("tbody");
        $tbody.empty();
        model.forEach((item,index)=>{
            $("<tr>")
                .append($("<td>").text(item.id))
                .append($("<td>").text(item.cname))
                .append($("<button>").text("删除").on("click",(e)=>{
                    this.delete(item);
                }))
                .on("dblclick",(e)=>{
                		//将更新表单重新渲染
                		updateComponent.render(item);
                })
                .appendTo($tbody);
        });
    }

    this.delete=function (item) {
        myAjax(url+item.id,"DELETE",null,data=>{
            if(data.error){
                alert("删除失败");
                this.refresh();
            }
            else{
                let index=model.indexOf(item);
                model.urd(index,1);
            }
        });
    }
}

//添加表单组件
function AddFormComponet($view,model,url) {
    $view.on("submit",(e)=>{
        e.preventDefault();
        let data=form2json($(e.target));
        myAjax(url,"POST",data,(c)=>{
            model.add(c);
        })
    })
}
//更新表单组件
function UpdateFormComponet($view,model,url) {
    let cur=null;
    // 为更新表单添加提交事件处理
    $view.on("submit",(e)=>{
        e.preventDefault();
        let data=form2json($(e.target));
        myAjax(url+cur.id,"PUT",data,(c)=>{
            let index=model.indexOf(cur);
            console.log(index)
            model.urd(index,1,c);
        })
    })

    this.render=function (item) {
        cur=item;
        $view.find("[name=cname]").val(item.cname);
    }
}

$(function () {
    let app=new AppComponent($("#app"),"http://localhost:8080/integrator/customers/");
});
