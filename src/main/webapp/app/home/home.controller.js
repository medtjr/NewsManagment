(function() {
    'use strict';

    angular
        .module('pfeApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state','Nimda','$filter'];

    function HomeController ($scope, Principal, LoginService, $state,Nimda,$filter) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;

        var news = Nimda.get().then(function(data){
            //return data;
            vm.urgentNews = $filter('filter')(data, function (value) {
                return value.urgent;
            });
            vm.ugNews = vm.urgentNews.map(function(elem){
                return elem.titre;
            }).join('. ');
             vm.noramlNews =$filter('filter')(data, function (value) {
                return !value.urgent;
            });

        });
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

        function register () {
            $state.go('register');
        }
    }
})();
