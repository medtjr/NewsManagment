(function() {
    'use strict';

    angular
        .module('pfeApp')
        .controller('NimdaController', NimdaController);

    NimdaController.$inject = ['$scope', 'Principal', '$timeout', 'LoginService', '$state', 'Auth','Nimda'];

    function NimdaController ($scope, Principal, $timeout, LoginService, $state, Auth, Nimda) {


        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.logout = logout;
        vm.register = register;

        vm.urgent=false;


        vm.submit=submit;

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

       function submit() {
           var news={
               titre:vm.titre,
               urgent:vm.urgent,
               img:vm.img
           };
           console.log(news);
           Nimda.post(news);

        }
        function register () {
            $state.go('register');
        }

        $scope.uploadFiles = function(file, errFiles) {
            $scope.f = file;
            $scope.errFile = errFiles && errFiles[0];
            if (file) {
                file.upload = Upload.upload({
                    url: 'https://angular-file-upload-cors-srv.appspot.com/upload',
                    data: {file: file}
                });

                file.upload.then(function (response) {
                    $timeout(function () {
                        file.result = response.data;
                    });
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                    file.progress = Math.min(100, parseInt(100.0 *
                        evt.loaded / evt.total));
                });
            }
        }

        function logout() {
            Auth.logout();
            $state.go('home');
        }
    }
})();
