<%@ include file="header.jspf" %>

      <div class="container-fluid profile-section">
        <div class="profile-navigation container">
        <%@ include file="nav.jspf" %>


        </div>
    </div>
    <section class="courses-inner">
   		 <c:if test="${sessionScope.name ne null }">
    	<div class="container"><span>Welcome ${sessionScope.name }</span></div>
    </c:if>
        <h2 class="text-center"> Enrolled Courses </h2>
        <div class="container">
            <div class="row justify-content-center">
               
                   
                    
                     <c:forEach var="course"  items="${course}">
                    <div class="col-md-3 course">
                        <div class="course-content">
                            <h3>${course.courseTitle }</h3>
                            <img src="img/course.jpg" />
                            <span class="price">${course.coursePrice }</span>
                            <a href="unenroll?courseId=${course.courseId }" class="btn btn-danger custombtn"> Unenroll</a>
                        </div>            
                    </div>
               </c:forEach>
                </div>
            </div>
        </section>



<%@ include file="footer.jsp" %>


    