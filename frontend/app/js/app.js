(function(){
'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    // Angular modules
    'ngRoute',
    'ngResource',
    // 3rd Party Modules
    'ui.bootstrap',
    // System
    'constant'
])
    .config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/main'});
}])

.config(['$routeProvider',function ($routeProvider) {
    $routeProvider.when('/main',{
        templateUrl:'view/main.html',
        controller: 'mainController'
    })
}])

.controller('mainController',['$scope','webFactory',function ($scope, webFactory) {

    $scope.alerts = [
        { type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
        { type: 'success', msg: 'Well done! You successfully read this important alert message.' }
    ];

    $scope.addAlert = function() {
        $scope.alerts.push({msg: 'Another alert!'});
    };

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };
    
    
    $scope.requestDate = function () {
        var params = {
            category:'customer'
        }
        webFactory.doGet(params)
    }

}]);
}).call(this);