<%@ page import="librerias.Conexion"%>
<%@ page import="java.sql.*"%>
<html><head><title>Empresa ABC - Listado de empleados</title></head>
    <body><h1>Empresa ABC - Listado de Empleados</h1>
        <table border="1">
        <%
            Conexion cnx=new Conexion();
            cnx.conectarBD();
            ResultSet datos=cnx.consulta();
            while(datos.next()){    
        %>
        <tr>
            <td><%out.println(datos.getInt(1));%></td>
             <td><%out.println(datos.getString(2));%></td>
             <td><%out.println(datos.getString(3));%></td>
             <td><%out.println(datos.getString(4));%></td>
                                            
            
        </tr>
        <%}
            cnx.cerrar();
            %>
        </table>
    </body>
</html>
