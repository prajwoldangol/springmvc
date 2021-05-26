<%@ include file="header.jspf" %>
    <div class="container-fluid profile-section">
        <div class="backend-navigation container">
          <%@ include file="adminNav.jsp" %>


        </div>			
    </div>
       <section class="courses-inner">
        <h2 class="text-center"> List Of Available Courses </h2>
        <div class="container">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Details</th>
                        <th>Total Enrolled Students</th>
                        <th> Action</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="course"  items="${courses }">
                    <tr>
                        <th>${course.courseTitle }</th>
                        <td>${course.coursePrice }</td>
                        <td>${course.courseDetails }</td>
                        <td>${course.enrolledStudents }</td>
                        <td>
                            <a href="updateCourse?courseId=${course.courseId }" class="btn btn-warning">Edit</a>
                            <a href="deleteCourse?courseId=${course.courseId }" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                  

                </tbody>
            </table>
        </div>
    </section>




<%@ include file="footer.jsp" %>
