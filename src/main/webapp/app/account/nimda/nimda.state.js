(function() {
    'use strict';

    angular
        .module('pfeApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('nimda', {
            parent: 'app',
            url: '/nimda',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/account/nimda/nimda.html',
                    controller: 'NimdaController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
