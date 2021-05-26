<%@ include file="header.jspf" %>

        <section class="courses-inner">
        <h2 class="text-center">  Student Login</h2>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-4 register-form">
                <c:if test = "${message ne null }" >

<div class="alert alert-danger alert-dismissible fade show" role="alert">
 	${message}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
                    <form class="" action="authenticate" method="post">


                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" name="studentEmail" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="studentPassword" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
                        </div>

                        <button type="submit" class="btn btn-success">Login</button>

                    </form>
                </div>
            </div>
        </div>
    </section>

<%@ include file="footer.jsp" %>


    