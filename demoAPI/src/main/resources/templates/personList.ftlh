
<html>
   <head>
      <title>Person List</title>
      <link rel="stylesheet"
           type="text/css"
           href="/css/style.css'/>"/>      
   </head>   
   <body>
     <h3>Person List</h3>
     <a href="addPerson">Add Person</a>
     <br><br>
      <div>
         
         <table border="1">
            <tr>
               <th>First Name</th>
               <th>Last Name</th>
            </tr>
            <#list ListEmployees as employee>
            <tr>
               <td>${employee.firstName}</td>
               <td>${employee.lastName}</td>
            </tr>
            </#list>
         </table>
      </div>
   </body>
</html>