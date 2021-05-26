<%@ include file="header.jspf" %>
    <div class="container-fluid profile-section">
        <div class="backend-navigation container">
          <%@ include file="adminNav.jsp" %>


        </div>			
    </div>
    <section class="courses-inner">
        <h2 class="text-center">
        
         <c:choose>
					<c:when test="${courses ne null }">
						Update Existing Course
					</c:when>
					<c:otherwise>
						Add New Course
					</c:otherwise>
		</c:choose>
        </h2>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 register-form">
                <c:if test = "${message ne null }" >

					<div class="alert alert-success alert-dismissible fade show" role="alert">
					 	${message}
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>
				</c:if>
				<c:choose>
					<c:when test="${courses ne null }">
						<form class="" action="updatingCourse" method="post">
						<input type="hidden" value="${courses.courseId }" name="courseId"/>
					</c:when>
					<c:otherwise>
						<form class="" action="addingCourse" method="post">
					</c:otherwise>
				</c:choose>
                    
						
                        <div class="form-group">
                            <label for="exampleInputEmail1">Course Name</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" value="${courses.courseTitle }" name="courseTitle" aria-describedby="emailHelp" placeholder="Enter Course Title">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Price</label>
                            <input type="number" class="form-control" id="exampleInputEmail1" value="${courses.coursePrice }" name="coursePrice" aria-describedby="emailHelp" placeholder="Enter Price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Details</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" value="${courses.courseDetails }" name="courseDetails" aria-describedby="emailHelp" placeholder="Enter Details">
                        </div>


                        <button type="submit" class="btn btn-primary">
                        <c:choose>
					<c:when test="${courses ne null }">
						Update Course
					</c:when>
					<c:otherwise>
						Add Course
					</c:otherwise>
				</c:choose>
                        </button>

                    </form>
                </div>
            </div>
        </div>
    </section>




<%@ include file="footer.jsp" %>
