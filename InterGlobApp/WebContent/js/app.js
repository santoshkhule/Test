/**
 * interGlobApp will executes different task related activities
 */
var interGlobApp = angular.module("interGlobApp", [ "ngRoute" ] );

/**
 * Routes the page to different pages
 * 
 * @param $routeProvider
 * @returns
 */
interGlobApp.config( function( $routeProvider ) {
	$routeProvider.when("/", {
		templateUrl : "views/task.jsp",
		controller : "taskController"
	}).when("/task", {
		templateUrl : "views/task.jsp",
		controller : "taskController"
	}).otherwise({
		redirectTo: "login"
    });
});

interGlobApp.factory( "taskService", function( $http ) {	
	return ({
		getTaskList : function (){
			return $http.get("task")
			.then( 
				function( response ) {
					return response.data;
				},
				function ( errorResponse ){ 
					return errorResponse;
				}
			);
		},
		saveTask : function( task ){			
			return $http.post("task", task )
			.then (
				function ( response ) {
					return response.data;
				},
				function ( errorResponse ) {
					return errorResponse;
				}
			);
		},
		deleteTask : function( taskId ){			
			return $http.delete("task/" + taskId )
			.then (
				function ( response ) {
					return response.data;
				},
				function ( errorResponse ) {
					return errorResponse;
				}
			);			
		}
	});		
});

/**
 * Task controller fetch,add,updates the todo task
 * 
 * @param $scope
 * @param $http
 * @returns
 */
interGlobApp.controller( "taskController", function( $scope, taskService ) {
	
	$scope.saveTask = false;
	$scope.viewAllTask = true;
	
	//fetching All tasks
	taskService.getTaskList()
		.then(
			function ( response ) {
				$scope.taskList = response;
			}
	);
	
	$scope.addTask = function () {
		$scope.task = {};
		$scope.saveTask = true;
		$scope.viewAllTask = false;		
	};
	
	$scope.cancel = function () {
		$scope.saveTask = false;
		$scope.viewAllTask = true;		
	};
	
	$scope.updateTask = function ( task ) {
		$scope.saveTask = true;
		$scope.viewAllTask = false;
		$scope.task = task;
	};
	
	// save task 
	$scope.save = function ( task ) {
		if ( task && task.name && task.status ) {
			taskService.saveTask( task )
			.then(
				function ( response ) {					
					$scope.taskList = response;
					$scope.saveTask = false;
					$scope.viewAllTask = true;
				}
			);	
		} else {
			alert("Value Required");
		}
	};
	
	//Delete Task
	$scope.deleteTask = function ( task ) {		
		taskService.deleteTask( task.id )
		.then(
			function ( response ) {					
				$scope.taskList = response;				
			}
		);	
		
	};
});
