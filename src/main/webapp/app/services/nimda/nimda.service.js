(function () {
    'use strict';

    angular
        .module('pfeApp')
        .factory('Nimda', Nimda);

    Nimda.$inject = ['$http'];

    function Nimda ($http) {

        var service = {
            post: post,
            get : get
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

        function get() {
//           return [
//                {
//                    titre:"titre1",
//                    urgent:true,
//                    img:"img1"
//                },
//                {
//                    titre:"titre2",
//                    urgent:true,
//                    img:"img2"
//                },
//                {
//                    titre:"titre3",
//                    urgent:false,
//                    img:"img3"
//                }
//
//            ]
             $http.get('nimda/news').then(function (response) {
                return response.data;
            });
        }

    }
})();
