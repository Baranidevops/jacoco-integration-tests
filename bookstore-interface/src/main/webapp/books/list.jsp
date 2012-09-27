<html>
<head>
<title>Bookstores</title>

<link href="../../css/jquery.dataTables.css" rel="stylesheet" />
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/DT_bootstrap.css" rel="stylesheet" />

<script type="text/javascript" language="javascript"
   src="../../js/jquery.js"></script>
<script type="text/javascript" language="javascript"
   src="../../js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript"
   src="../../js/DT_bootstrap.js"></script>

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
	   $('#booksList').dataTable( {
	      "sDom": "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
	      "sPaginationType": "bootstrap",
	      "oLanguage": {
	         "sLengthMenu": "_MENU_ records per page"
	      },
	      "bProcessing" : true,
	         "sAjaxSource" : '/bookstore-interface/rest/books/search',
	      "aoColumns" : [ {
	            "sWidth" : '50px',
	            "mDataProp" : "id",
	            "bVisible" : false
	         }, {
	            "sWidth" : '80px',
	            "mDataProp" : "isbn"
	         }, {
	            "sWidth" : '800px',
	            "mDataProp" : "title"
	         } ],
	   } );
	} );
</script>
</head>
<body>
   <div class="navbar navbar-static-top navbar-inverse">
      <div class="navbar-inner">
         <div class="container">
            <a class="brand" href="../../index.jsp">Bookstore</a>
            <div class="nav-collapse">
               <ul class="nav">
                  <li class="active"><a href="./all">Books</a></li>
                  <li><a href="#">Authors</a></li>
                  <li><a href="#">Suggest</a></li>
                  <li><a href="#">Community</a></li>
                  <li><a href="#">About us</a></li>
               </ul>
            </div>
         </div>
      </div>
   </div>
   <div class="container">
      <div class="row">
         <div class="span12">
            <h1>Search engine</h1>

            <table id="booksList" class="table table-bordered table-hover">
               <thead>
                  <tr>
                     <th id="id">ID</th>
                     <th id="isbn">ISBN</th>
                     <th id="title">Title</th>
                  </tr>
               </thead>
            </table>
         </div>
      </div>
   </div>
</body>
</html>