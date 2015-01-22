/**
 * Created by Daniel on 22.01.2015.
 */
var eadChat = angular.module('ead-chat', ['ngResource']);

eadChat.controller('ChatCtrl', function ($scope, $http) {
    $scope.me = {
        "userId": 1,
        "appId":1,
        "username": "username"
    };

    $scope.message;

    $scope.user = {};

    $scope.users = [/*{
        "userId": 1,
        "appId": 1,
        "username": "name"
    },
        {
            "userId": 2,
            "appId": 1,
            "username": "name2"
        }*/];
    $scope.messages = [/*{
        "user": {
            "userId": 1,
            "appId": 1,
            "username": "name"
        },
        "recipient": {
            "userId": 2,
            "appId": 1,
            "username": "empfänger"
        },
        "message": "das ist ein Test",
        "timestamp": 1421935782
    }*/];

    $scope.register = function () {
        $scope.messages = [];
        $http.post('/rest/chatservice/registerToServer', $scope.me).success(function (data) {
            $scope.users = data.userList;
        });
    };

    $scope.changeUser = function (user) {
        $scope.user = user;
         $http.post('/rest/chatservice/getMessagesForUser/20', {"user": $scope.me, "recipient": user}).success(function (data) {
             $scope.messages = data.messageList;
        });
    };

    $scope.send = function () {
        $http.post('/rest/chatservice/sendMessage', {"user": $scope.me, "recipient": $scope.user, "message": $scope.message, "timestamp": (new Date(Date())).getTime()}).success(function (data) {
            $scope.message = '';
            $scope.changeUser($scope.user);
        });
    };
});