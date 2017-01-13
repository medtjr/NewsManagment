(function() {
    'use strict';

    angular
        .module('pfeApp')
        .controller('NimdaController', NimdaController);

    NimdaController.$inject = ['$rootScope', '$scope', 'Principal', '$timeout', 'LoginService', '$state', 'Auth','Nimda'];

    function NimdaController ($rootScope, $scope, Principal, $timeout, LoginService, $state, Auth, Nimda) {


        $rootScope.$on('edited', function(){
            console.log('coming from modal');
            getData();
        });


        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.logout = logout;
        vm.register = register;
        vm.deleteNews = function(id){
            if(confirm("est vous...")){
                Nimda.delete(id).then(function(){
                    getData();
                });
            }

        };

        vm.editNews = function(news,type){
            Nimda.open(news,type);
        };

        getData();

        function getData() {
            Nimda.get().then(function(data){
                vm.news = data;

            });
        }

        vm.urgent=false;

       // vm.submit=submit;

        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }

       /*function submit() {
           var news={
               titre:vm.titre,
               urgent:vm.urgent,
               image:vm.img
           };
           Nimda.post(news).then(function(){
               getData();
           });

        }*/
        function register () {
            $state.go('register');
        }


        function logout() {
            Auth.logout();
            $state.go('home');
        }
    }
})();
