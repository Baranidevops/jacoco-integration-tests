<html>
<head>
   <title>Bookstores</title>
   
   <link href="../../css/jquery.dataTables.css" rel="stylesheet" />
      
   <script type="text/javascript" language="javascript" src="../../js/jquery.js"></script>
   <script type="text/javascript" language="javascript" src="../../js/jquery.dataTables.js"></script>
   
   <script type="text/javascript" charset="utf-8">
         $(document).ready(function() {
            $('#booksList').dataTable( {
               "bProcessing": true,
               "sAjaxSource": '/bookstore-interface/rest/books/search',
               "aoColumns":[
                  {"sWidth": '50px', "mDataProp": "id", "bVisible": false},
                  {"sWidth": '80px', "mDataProp": "isbn"},
                  {"sWidth": '800px', "mDataProp": "title"}
               ],
            } );
         } );
      </script>
</head>
<body>
   <h1>Book search</h1>
   <p>Greetings.</p>


   <table id="booksList">
      <thead>
         <tr>
            <th id="id">ID</th>
            <th id="isbn">ISBN</th>
            <th id="title">Title</th>
         </tr>
      </thead>
   </table>
</body>
</html>