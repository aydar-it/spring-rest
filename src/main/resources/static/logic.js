var app = angular.module('app', []);
var contextPath = 'http://localhost:8189'
app.controller('booksController', function ($scope, $http) {
    fillTable = function () {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/books/filter'
        }).then(function (response) {
                $scope.page = response.data;
            });
    };
    $scope.page = {};
    $scope.bookForm = {
        title: "",
        minPrice: 0,
        maxPrice: 999999,
        publishYear: ""
    };
    fillTable();
    $scope.applyFilter = function () {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/books/filter',
            params: {
                minPrice: $scope.bookForm.minPrice,
                maxPrice: $scope.bookForm.maxPrice,
                publishYear: $scope.bookForm.publishYear,
                title: $scope.bookForm.title
            }
        }).then(function (response) {
            $scope.page = response.data;
        });
    }

    $scope.changePage = function (index) {
            $http({
                method: 'GET',
                url: contextPath + '/api/v1/books/filter',
                params: {
                    p: index,
                    minPrice: $scope.bookForm.minPrice,
                    maxPrice: $scope.bookForm.maxPrice,
                    publishYear: $scope.bookForm.publishYear,
                    title: $scope.bookForm.title
                }
            }).then(function (response) {
                $scope.page = response.data;
            });
        }
});