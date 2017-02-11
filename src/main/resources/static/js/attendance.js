(function($){
	var track=0;
	var COURSE_RESOURCE_MATH = "attendanceRecords/1";
	var COURSE_RESOURCE_SCIENCE = "attendanceRecords/2";
	var COURSE_RESOURCE_HISTORY = "attendanceRecords/3";




	$(function(){
		document.getElementById("create").onclick = function(){
			window.alert("SELECT A COURSE FIRST");

		}		

		document.getElementById("Math").onclick = function(){
			makeAttendanceRecordsRequest(COURSE_RESOURCE_MATH);
		}		

		document.getElementById("Science").onclick = function(){
			makeAttendanceRecordsRequest(COURSE_RESOURCE_SCIENCE);
		}	
		document.getElementById("History").onclick = function(){
			makeAttendanceRecordsRequest(COURSE_RESOURCE_HISTORY);
		}	



	});

	function makeAttendanceRecordsRequest(url) {

		$.getJSON(url, function(data) {

			console.log(data);

			displayCourseDetailsTable(data);

		});
	}

	function displayCourseDetailsTable(AttendanceArray) {

		var details =document.getElementById("Course_Details");
		details.innerHTML="";
		details.innerHTML+= "<div id=\"dets\"> </br><h3>"+AttendanceArray[0].course.name+ " </h3><strong>  Time and Date:-> </strong> " + AttendanceArray[0].course.timeDate + " </br> <strong> Units:-> </strong> " + AttendanceArray[0].course.units+" </br> <strong> Section:-> </strong> " + AttendanceArray[0].course.section+" </br> <strong> Classroom Location:-> </strong> "+ AttendanceArray[0].course.location+" </br><strong>  Instructor:-> </strong>"+ AttendanceArray[0].course.instructor+ " </br></div>";        


		//clear table body
		var table = document.getElementById("attendance-table-body");

		table.innerHTML="";
		var students=AttendanceArray[1].course.students;
		var numberofstudents=students.length;
		var i=AttendanceArray.length/students.length;

		var top = document.createElement('tr');
		top.appendChild( document.createElement('th') );	
		top.cells[0].appendChild(document.createTextNode("Student"));

		col2=1;

		AttendanceArray.forEach(function(current){

			if(students[0].name===current.student.name){
				top.appendChild( document.createElement('th') );	
				top.cells[col2].appendChild(document.createTextNode(current.activity));
				col2++;
			}
		});

		table.appendChild(top);

		students.forEach(function(student){
			var tr = document.createElement('tr');
			col=0;
			tr.appendChild( document.createElement('td') );	
			tr.cells[col].appendChild(document.createTextNode(student.name));
			col++;
			AttendanceArray.forEach(function(current){

				if(student.name===current.student.name){

					tr.appendChild( document.createElement('td') );	
					tr.cells[col].appendChild( document.createTextNode(current.status));
					if(current.status==="present"){
						tr.cells[col].style.backgroundColor="green";
					}
					else{
						tr.cells[col].style.backgroundColor="red";
					}
					col++;


				}
			});

			document.getElementById("create").onclick = function(){
				var x = document.createElement("INPUT");
				var y=top.insertCell(-1);
				x.setAttribute("type", "text");
				x.setAttribute("id", "activity_name");
				x.setAttribute("placeholder","Type Activity Name");
				y.appendChild(x);

				m=1;
				while(m<=numberofstudents){
					var label1= document.createElement("label");
					var label2= document.createElement("label");
					var label3= document.createElement("label");

					var description1 = document.createTextNode("present");
					var description2 = document.createTextNode("absent");
					var description3 = document.createTextNode("unknown");

					var checkbox1 = document.createElement("input");
					var checkbox2 = document.createElement("input");
					var checkbox3 = document.createElement("input");

					checkbox1.type="checkbox";
					checkbox1.id="status";
					checkbox1.setAttribute("class","status");

					checkbox1.label="present";

					checkbox2.type="checkbox";
					checkbox2.id="status";
					checkbox2.setAttribute("class","status");


					checkbox2.label="absent";

					checkbox3.type="checkbox";
					checkbox3.id="status";
					checkbox3.setAttribute("class","status");

					checkbox3.label="unknown";

					label1.appendChild(checkbox1);   // add the box to the element
					label1.appendChild(description1);

					label2.appendChild(checkbox2);   // add the box to the element
					label2.appendChild(description2);

					label3.appendChild(checkbox3);   // add the box to the element
					label3.appendChild(description3);

					var last=table.rows[m].insertCell(-1);
					last.appendChild(label1);
					last.appendChild(document.createElement("br")); 
					last.appendChild(label2);
					last.appendChild(document.createElement("br")); 
					last.appendChild(label3);


					m++;
				}



				document.getElementById("update").onclick = function() {
					if(document.getElementsByClassName("status").length==0){
						return;
					}

					for(var m=0;m<students.length;m++){
						var postData = {};
						postData.course_id = AttendanceArray[0].course.id;
						postData.activity_name = document.getElementById("activity_name").value;

						var statuses=document.getElementsByClassName("status");
						var realStatus=[];


						for (var i=0; i<statuses.length; i++) {
							if (statuses[i].checked) {
								realStatus.push(statuses[i]);
							}
						}			

						if(realStatus.length !== students.length){
							window.alert("PLEASE SELECT ONLY ONE ATTENDANCE PER STUDENT. REFRESH THE PAGE TO RESTART.")
						}


						postData.student_id=students[m].id;
						postData.status=realStatus[m].label;

						console.log(postData);


						$.ajax({
							type: "POST",
							url: "attendanceRecords",
							data: JSON.stringify(postData),
							contentType: "application/json; charset=utf-8",
							dataType: "json",
							success: function(data){
								console.log(data);
								if(AttendanceArray[0].course.id==1){
									makeAttendanceRecordsRequest(COURSE_RESOURCE_MATH);
								}
								if(AttendanceArray[0].course.id==2){
									makeAttendanceRecordsRequest(COURSE_RESOURCE_SCIENCE);
								}
								if(AttendanceArray[0].course.id==3){
									makeAttendanceRecordsRequest(COURSE_RESOURCE_HISTORY);
								}


							},
							failure: function(errMsg) {
								alert(errMsg);
							}
						});


					}

				}


			}


			table.appendChild(tr);
		});






	}


})(jQuery);