<%@ include file="header.jspf" %>
    <div class="container-fluid hero-section">
        <div class="hero-navigation container">
 <%@ include file="nav.jspf" %>

            <div class="row hero-form-section">
                <div class="col-md-8 hero-content">
                    <h1 class="text-center"> Try Our Free Courses </h1>
                    <div class="row justify-content-center">
                        <div class="col-md-5 course">
                            <div class="course-content">
                                <h3>Course Title 1</h3>
                                <img src="img/course.jpg" />
                                <span class="price">Price</span>
                                <a href="#" class="btn btn-success custombtn"> Enroll</a>
                            </div>
                        </div>
                        <div class="col-md-5 course">
                            <div class="course-content">
                                <h3>Course Title 1</h3>
                                <img src="img/course.jpg" />
                                <span class="price">Price</span>
                                <a href="#" class="btn btn-success custombtn"> Enroll</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 hero-form">
                    <h2> Register as Student ?</h2>
                   <%@ include file="registerform.jsp" %>
                </div>
            </div>
        </div>
    </div>
        <section class="courses">
            <h2 class="text-center"> Available Courses</h2>
            <div class="container">
                <div class="row justify-content-center">
               <c:forEach var="course"  items="${courses }">
                    <div class="col-md-3 course">
                        <div class="course-content">
                            <h3>${course.courseTitle }</h3>
                            <img src="img/course.jpg" />
                            <span class="price">${course.coursePrice }</span>
                            <a href="enroll?courseId=${course.courseId }" class="btn btn-success custombtn"> Enroll</a>
                        </div>            
                    </div>
               </c:forEach>    
                        
                    </div>
                </div>
            </section>




      <%@ include file="footer.jsp" %>
