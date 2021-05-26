<%@ include file="header.jspf" %>
    <div class="container-fluid profile-section">
        <div class="backend-navigation container">
          <%@ include file="nav.jspf" %>


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
                   
                    <tr>
                        <th>1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                        <td>
                            <a href="#" class="btn btn-warning">Edit</a>
                            <a href="#" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                  

                </tbody>
            </table>
        </div>
    </section>




<%@ include file="footer.jsp" %>
