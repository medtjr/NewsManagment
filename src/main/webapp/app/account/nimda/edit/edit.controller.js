(function() {
    'use strict';

    angular
        .module('pfeApp')
        .controller('EditNewsController', EditNewsController);

    EditNewsController.$inject = ['$rootScope', '$scope','Nimda','$uibModalInstance','data','type'];

    function EditNewsController ($rootScope, $scope, Nimda,$uibModalInstance,data,type) {



        var vm = this;
        vm.cancel=function cancel () {
            $uibModalInstance.dismiss('cancel');
        }
        if(type === 'UPDATE'){
            vm.urgent=data.urgent;
            vm.titre=data.titre;
        }

        vm.mode=type==='CREATE'?'Création':'Edition';

        vm.editNews = function(){
            var news={
                titre:vm.titre,
                urgent:vm.urgent,
                image:vm.img
            };
            if(type === 'UPDATE'){
                news.id=data.id;
            }
            Nimda.post(news).then(function(){
                $uibModalInstance.close();

                $rootScope.$emit('edited');

            });
        };

        function getData() {
            Nimda.get().then(function(data){
                vm.news = data;

            });
        }




    }
})();
