(function () {
    'use strict';

    angular
        .module('pfeApp')
        .factory('Nimda', Nimda);

    Nimda.$inject = ['$http'];

    function Nimda ($http) {

        var service = {
            post: post,
            get : get,
            delete : deleteNews
        };
        return service;

        function post(news) {
            return $http.post('api/nimda/news/addupdate', news)
                .then(function (result) {
                    return result;
                }).catch(function (error) {
                    throw error;
                });
        }

        function deleteNews(id){
            return $http.delete('api/nimda/news/delete/'+id)
                .then(function (result) {
                    return result;
                }).catch(function (error) {
                    throw error;
                });
        }

        function get() {
             return $http.get('nimda/news').then(function (response) {
                return response.data;
            });
        }

    }
})();
