(function () {
    'use strict';

    angular
        .module('pfeApp')
        .factory('Nimda', Nimda);

    Nimda.$inject = ['$http','$uibModal'];

    function Nimda ($http,$uibModal) {

        var service = {
            post: post,
            get : get,
            delete : deleteNews,
            open : open
        };

        var modalInstance = null;
        var resetModal = function () {
            modalInstance = null;
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



        function open (news,type) {
            if (modalInstance !== null) return;
            modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'app/account/nimda/edit/edit.html',
                controller: 'EditNewsController',
                controllerAs: 'vm',
                resolve : {
                    data : function (){return news;},
                    type : function (){return type;}
                }

            });
            modalInstance.result.then(
                resetModal,
                resetModal
            );
        }

    }
})();
