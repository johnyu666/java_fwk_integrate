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