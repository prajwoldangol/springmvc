
<c:if test = "${message ne null }" >

<div class="alert alert-success alert-dismissible fade show" role="alert">
 	${message}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
<form class="" action="register" method="post">

                        <div class="form-group">
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" class="form-control" name="studentName" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Name" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Phone</label>
                            <input type="phone" class="form-control" name="studentPhone" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" name="studentEmail" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="studentPassword" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
                        </div>

                        <button type="submit" class="btn btn-success">Register Now</button>

                    </form>