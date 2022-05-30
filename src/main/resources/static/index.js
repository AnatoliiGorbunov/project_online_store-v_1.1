angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/api/v1/products/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };


    $scope.loadProduct();

    $scope.filterBetweenCost = function (minCost, maxCost) {
        $http({
            url: contextPath + '/products/filterBetweenCost',
            method: 'GET',
            params: {
                minCost: minCost,
                maxCost: maxCost
            }
        }).then(function (response) {
            $scope.loadProduct();
        });
    }

    $scope.deleteById = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProduct();
            });
    };

    $scope.loadProduct();

});