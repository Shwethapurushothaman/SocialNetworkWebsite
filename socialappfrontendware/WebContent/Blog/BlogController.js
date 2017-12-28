myapp.controller("BlogController",function($scope,$http)
{
	$scope.blog={blogId:23,blogName:"",blogContent:"",createDate:"",likes:3,userid:"",status:"A"};
	$http.get("http://localhost:8080/SocialNetworkRestApp/getAllBlogs")
	.then(function(response)
	{
	$scope.blogdata=response.data;
	});
	
	$scope.addBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addBlog',$scope.blog)
		.then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}
	
	
});

