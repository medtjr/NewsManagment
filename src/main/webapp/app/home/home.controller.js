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
        var news = Nimda.get();
        vm.urgentNews = $filter('filter')(news, function (value) {
                return value.urgent;
            });
        vm.noramlNews =$filter('filter')(news, function (value) {
            return !value.urgent;
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
