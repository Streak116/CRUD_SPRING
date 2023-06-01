<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRUD Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            margin-bottom: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            margin-right: 10px;
        }
        .table-danger {
    background-color: red;
}

.table-primary {
    background-color: blue;
}

.table-success {
    background-color: green;
}

.table-secondary {
    background-color: brown;
}
        
    </style>
</head>
<body>
    <h1>CRUD Page</h1>
    <%
    //HttpSession session = httpRequest.getSession(true);
    String uname=(String)session.getAttribute("username");
    if(uname==null){
    	//httpResponse.sendRedirect("sorry.jsp");
    }
    out.println("<h1>Hello "+uname+"</h1>");
    %>
    
    <form id="crudForm" modelAttribute="superheroForm">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="alias">Alias:</label></td>
                <td><input type="text" id="alias" name="alias" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="gender">Gender:</label></td>
                <td><input type="text" id="gender" name="gender" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="age">Age:</label></td>
                <td><input type="number" id="age" name="age" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="powers">Powers:</label></td>
                <td><input type="text" id="powers" name="powers" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="team">Affiliation:</label></td>
                <td><input type="text" id="team" name="team" required class="form-control"></td>
            </tr>
            <tr>
                <td><label for="id">ID:</label></td>
                <td><input type="number" id="id" name="id" required class="form-control"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="button" onclick="performAction('add')" class="btn btn-primary">Add</button>
                    <button type="button" onclick="performAction('edit')" class="btn btn-primary">Edit</button>
                    <button type="button" onclick="performAction('read')" class="btn btn-primary">Read</button>
                    <button type="button" onclick="performAction('delete')" class="btn btn-danger">Delete</button>
                    <button type="submit" class="btn btn-success">Submit</button>
                </td>
            </tr>
        </table>
    </form>
    
    <div id="tab" name="tab">
        <table id="superheroesTable" class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Alias</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Powers</th>
                    <th>Team</th>
                    <th>ID</th>
                    <th>DOB</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

   <script >
       // Perform initial fetch when the page loads
      //performAction("fetch");
       //performAction("read");
       
function performAction(action) {
  var form = $("#crudForm");
  var formData = form.serializeArray(); // Serialize the form data as an array

  // Add the action attribute to the formData
  formData.push({ name: "action", value: action });

  // Convert formData to JSON string
  var jsonData = JSON.stringify(formData);
	if(action=="add")
		var url2="add"
	if(action=="delete")
		var url2="delete"
	if(action=="read")
		var url2="read"
	if(action=="edit")
		var url2="edit"
			
	
  $.ajax({
    url: url2,
    type: "POST",
    data: jsonData,
    contentType: "application/json", // Set the Content-Type header to indicate JSON data
  
    success: function(response) {
      // Successful response, do something with the response data
      if(url2=='read'){
          populateTable(response);
      }
      else{
      console.log(response);
      alert(response);
      
      }
    },
    error: function(xhr, status, error) {
      // Error occurred during the AJAX request
      console.log("Error: " + xhr.status);
    }
  });
}

       
 

       //function performAction2(action) {
    	 //   var form = document.getElementById("crudForm");
    	   // var formData = new FormData(form);
  //  	    formData.append("action", action); // Append the action value to the form data
//
  //  	    var xhr = new XMLHttpRequest();
    //	    var url2 = "crud";
    	//    
    	  //  xhr.open("GET", url2);
//    	    xhr.setRequestHeader("Content-Type", "application/json");
  //  	    xhr.onreadystatechange = function() {
    //	        if (xhr.readyState === XMLHttpRequest.DONE) {
    	//            if (xhr.status === 200) {
    	  //              // Handle the response from the servlet if needed
    	    //            console.log(xhr.responseText);
    	      //          if (action == 'fetch') {
    	        //            populateForm(xhr.responseText);
    	          //      }
    	            //    if (action == 'add') {
    	              //      alert(xhr.responseText);
//    	                }
  //  	                if (action == 'delete') {
    //	                    alert(xhr.responseText);
    	//                }
//
  //  	                if (action == 'read') {
    //	                    populateTable(xhr.responseText);
    	//                }
    	  //              if (action == 'edit') {
    	    //                alert(xhr.responseText);
    	      //          }
//
  //  	            } else {
    	                // Handle errors
    //	                console.error("AJAX request failed.");
    	//            }
    	  //      }
    	    //};

    	   // xhr.send(formData);
    	//}


       function populateForm(jsonData) {
           var data = JSON.parse(jsonData);

           document.getElementById("name").value = data.name;
           document.getElementById("alias").value = data.alias;
           document.getElementById("gender").value = data.gender;
           document.getElementById("age").value = data.age;
           document.getElementById("powers").value = data.powers;
           document.getElementById("team").value = data.team;
           document.getElementById("id").value = data.id;
           var dobDate = new Date(data.dob);
           var dobString = dobDate.toISOString().split("T")[0];
           document.getElementById("dob").value = dobString;
           
       }
       function populateForm2(jsonData) {
           var data = JSON.parse(jsonData);

           document.getElementById("name").value = data.name;
           document.getElementById("alias").value = data.alias;
           document.getElementById("gender").value = data.gender;
           document.getElementById("age").value = data.age;
           document.getElementById("powers").value = data.powers;
           document.getElementById("team").value = data.team;
           document.getElementById("id").value = data.id;
           document.getElementById("dob").value = data.dobString;
           
       }

       function populateTable(jsonData) {
    	    var data = JSON.parse(jsonData);
    	    var tableBody = $("#superheroesTable tbody");
    	    tableBody.empty(); // Clear existing table body

    	    for (var i = 0; i < data.length; i++) {
    	        var row = $("<tr>");

    	        var nameCell = $("<td>").text(data[i].name);
    	        row.append(nameCell);

    	        var aliasCell = $("<td>").text(data[i].alias);
    	        row.append(aliasCell);

    	        var genderCell = $("<td>").text(data[i].gender);
    	        row.append(genderCell);

    	        var ageCell = $("<td>").text(data[i].age);
    	        row.append(ageCell);

    	        var powersCell = $("<td>").text(data[i].powers);
    	        row.append(powersCell);

    	        var teamCell = $("<td>").text(data[i].team);
    	        row.append(teamCell);

    	        var idCell = $("<td>").text(data[i].id);
    	        row.append(idCell);

    	        var dobCell = $("<td>").text(data[i].dobString);
    	        row.append(dobCell);

    	        // Create the button cell and button element
    	        var buttonCell = $("<td>");
    	        var button = $("<button>")
    	            .text("Fill Form")
    	            .attr("type", "button")
    	            .click(createButtonClickHandler(data[i]));
    	        buttonCell.append(button);
    	        row.append(buttonCell);

    	        // Apply background color based on the team value
    	        var team = data[i].team.toLowerCase();
    	        if (team === "avengers") {
    	            row.addClass("table-danger");
    	        } else if (team === "justice league") {
    	            row.addClass("table-primary");
    	        } else if (team === "guardians of the galaxy") {
    	            row.addClass("table-success");
    	        } else if (team === "defenders") {
    	            row.addClass("table-secondary");
    	        }

    	        tableBody.append(row);
    	    }
    	}

       function createButtonClickHandler(rowData) {
           return function () {
               populateForm(JSON.stringify(rowData));
           };
       }
   </script>
</body>
</html>



