<div class="hero-nav">
	<ul class="nav">
		<c:if test="${sessionScope.name ne null }">
			<li class="nav-item welcome"> Welcome Back , ${sessionScope.adminName }</li>

		</c:if>
		<li class="nav-item"><a class="nav-link" href="addCourse">Add New Course</a></li>
		<li class="nav-item"><a class="nav-link" href="courseList">View All Courses</a></li>
		

		<c:if test="${sessionScope.adminName ne null }">
			<li class="nav-item"><a class="nav-link" href="logout"> Logout</a></li>

		</c:if>

	</ul>
</div>