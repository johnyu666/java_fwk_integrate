import "expose-loader?$!jquery";
import {AppComponent} from "./js/customer.manager";
$(function () {
    let app=new AppComponent($("#app"),"http://localhost:8080/integrator/customers/");
});