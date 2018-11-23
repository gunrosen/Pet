'use strict';

// Declare app level module which depends on views, and core components
angular.module('myApp', [
    'ngRoute',
    'ui.bootstrap',
    'viewMain'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/main'});
}]);


angular.module('viewMain',['ngRoute','ui.bootstrap'])
.config(['$routeProvider',function ($routeProvider) {
    $routeProvider.when('/main',{
        templateUrl:'view/main.html',
        controller: 'mainController'
    })
}])
.controller('mainController',function ($scope) {

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

});