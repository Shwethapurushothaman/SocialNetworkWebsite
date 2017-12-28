myapp.controller("UserController",function($scope,$http,$location)
{
	$scope.userDetail={userName:"",password:"",emailId:"",isOnline:"",role:"",userId:"25"};

	$scope.addUser=function()
	{
		//console.log('Entered into InsertBlog');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addUser',$scope.userDetail)
		.then(function(response)
				{
				console.log('Successful User Entered');
				});
	}
	$scope.login=function()
	{
		$http.post('http://localhost:8080/SocialNetworkRestApp/login',$scope.UserDetail)
		.then(function(response)
		{
			$scope.UserDetail=response.data;
			$location.path("/UserHome");
		});
	}
	
});
