/**
 * Created by Gun on 12/4/18.
 */
(function () {
'use strict';
angular.module('myApp').factory('webFactory',['$resource','ADDRESS_BACKEND',function ($resource,ADDRESS_BACKEND) {
    var url = ADDRESS_BACKEND +':who/:category/:subCategory/:id/:param/:action/:subAction';
    var defaultParameters = null;
    var actions = {
        doPost:{
            method: 'POST',
            headers:{'Content-Type':'application/json'}
        },
        doGet:{
            method: 'GET',
            headers:{'Content-Type':'application/json'}
        }
    }
    return $resource(url,defaultParameters,actions);
}])
}).call(this);