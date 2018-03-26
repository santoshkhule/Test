<div class="col-md-12">	
	<div class="panel panel-info">
		<div class="panel-heading">ToDo Task</div>
		<div class="panel-body">
			<!-- View All Task  -->
			<div class="view-task" ng-show="viewAllTask">			
				<button type="button" class="btn btn-info btn-sm" ng-click="addTask()">
					Add new Task</button>				
				<table class="table table-bordered">
					<thead>
						<tr>
							<td>Id</td>
							<td>Task Name</td>
							<td>Task Status</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="task in taskList">
							<td>{{task.id}}</td>
							<td>{{task.name}}</td>
							<td>{{task.status}}</td>
							
							<td><span class="glyphicon glyphicon-edit" ng-click="updateTask(task)">
								</span>&nbsp;&nbsp;&nbsp;&nbsp;
								<span class="glyphicon glyphicon-trash" ng-click="deleteTask(task)">
								</span>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- Save todo task form  -->
			<div class="save-task" ng-show="saveTask">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-2 control-label"> Name : </label>				
						<div class="col-sm-10">
							<input required="required" type="text" class="form-control" 
								placeholder="Name" ng-model="task.name">
						</div>
					</div>				
					<div class="form-group">
						<label class="col-sm-2 control-label"> Status: </label>
						<div class="col-sm-10">
							<select class="form-control" required="required" ng-model="task.status">								
								<option>Pending</option>
								<option>Completed</option>
								<option>In Progress</option>							
							</select>
						</div>
					</div>
					<div class="form-group">
						<input name="taskId" ng-model="task.id" value="1" hidden="true">	
					</div>
											
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" ng-click="save(task)">Save</button>
							<button type="button" class="btn btn-default" ng-click="cancel()">Cancel</button>
						</div>						
					</div>
					
				</form>
			</div>
		</div>
	</div>	
</div>
