jQuery(document)
		.ready(
				function() {
					if($("#showMessage")[0]!=null){
					var a = $("#showMessage")[0].outerText;
			    	if(a.length>0)
			        	$("#myModal").modal('show');
					}
					/*
					 * Background slideshow
					 */
					$.backstretch([ "/BookManagement/resources/assets/img/backgrounds/1.jpg",
							"./resources/assets/img/backgrounds/2.jpg",
							"./resources/assets/img/backgrounds/6.jpg",
							"./resources/assets/img/backgrounds/7.jpg",
							"./resources/assets/img/backgrounds/8.jpg" ], {
						duration : 3000,
						fade : 750
					});

					/*
					 * Tooltips
					 */
					$('.links a.home').tooltip();
					$('.links a.blog').tooltip();

					// Button Clear click
					$('#btnClear').click(function() {
						$('input#bookId').val('');
						$('input#booktitle').val('')
						$('input#authorname').val('')
						$('input#publisher').val('')
						$('input#year').val('')
						$('input#month').val('')
						$('input#day').val('')
					});

					function alphanumericsonly(ob) {
						var invalidChars = /([^a-z0-9])/gi
						if (invalidChars.test(ob.value)) {
							ob.value = ob.value.replace(invalidChars, "");
						}
					}

					$('#bookId').keyup(function() {
						alphanumericsonly(this);

					});

					
					    	
					 
					 
					// Only number input
					/*$('input#bookId')
							.keypress(
									function(e) {
										// if the letter is not digit then
										// display error
										// and don't type anything
										if (e.which != 8
												&& e.which != 0
												&& (e.which < 48 || e.which > 57)) {
											// display error message
											$(this).find("label[for='bookId']").html("<span style='display:none' class='red'> - Please input number.</span>")
													.show().fadOut('slow');

											return false;
										}
									});*/


					/*function validateForm() {
						$(this).find("label[for='bookId']").html('Book Id:');
						  $(this).find("label[for='booktitle']").html('Book Title:'); 
						  $(this).find("label[for='authorname']").html('Author Name:');
						  $(this).find("label[for='publisher']").html('Publisher:'); 
						  $(this).find("label[for='publicationdate']").html('Publication Date:'); 
						  var bookId = $(this).find('input#bookId').val(); 
						  var booktitle = $(this).find('input#booktitle').val(); 
						  var authorname = $(this).find('input#authorname').val(); 
						  var publisher = $(this).find('input#publisher').val(); 
						  var year = $(this).find('input#year').val(); 
						  var month =  $(this).find('input#month').val(); 
						  var day = $(this).find('input#day').val();
						  
						  if (bookId == '') { 
							  $(this).find("label[for='bookId']").append( "<span style='display:none' class='red'> - Please enter the book id.</span>"); 
							  $(this).find("label[for='bookId'] span").fadeIn('medium'); 
							  return false; } 
						  if (booktitle == '') { 
							  $(this).find("label[for='booktitle']").append( "<span style='display:none' class='red'> - Please enter book title.</span>"); 
							  $(this).find( "label[for='booktitle'] span").fadeIn('medium'); 
							  return false; } 
						  if (authorname == '') { 
							  $(this).find( "label[for='authorname']").append( "<span style='display:none' class='red'> - Please enter a valid author name.</span>"); 
							  $(this).find("label[for='authorname'] span").fadeIn('medium'); 
							  return false; } 
						  if (publisher == '') { 
							  $(this).find("label[for='publisher']").append( "<span style='display:none' class='red'> - Please enter a valid publisher.</span>"); 
							  $(this).find("label[for='publisher'] span").fadeIn('medium'); 
							  return false; } 
						  if (year == '') { 
							  $(this).find("label[for='publicationdate']").append( "<span style='display:none' class='red'> - Please enter a valid year.</span>"); 
							  $(this).find("label[for='publicationdate'] span").fadeIn('medium');
						  return false; } 
						  if (month == '') { 
							  $(this).find("label[for='publicationdate']").append( "<span style='display:none' class='red'> - Please enter a valid year.</span>"); 
							  $(this).find("label[for='publicationdate'] span").fadeIn('medium');
						  return false; } 
						  if (day == '') { 
							  $(this).find("label[for='publicationdate']").append( "<span style='display:none' class='red'> - Please enter a valid year.</span>");
							  $(this).find("label[for='publicationdate'] span").fadeIn('medium');
						  return false; }
					}
					  $('#btnBookId').click( function() {
						  validateForm();
					  });*/

				});
