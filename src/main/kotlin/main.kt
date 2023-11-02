import java.sql.Connection

import java.sql.DriverManager

import java.sql.SQLException

import java.sql.ResultSet



fun main() {

    // Datos de conexión

    val jdbcUrl = "jdbc:mysql://localhost:3306/NOMINAS"

    val usuario = "ADRIAN"

    val contrasena = "ADRI"

    var empleado=Empleado()



    var conexion: Connection? = null



    try {

        // Cargar el controlador JDBC

        Class.forName("com.mysql.cj.jdbc.Driver")



        // Establecer la conexión

        conexion = DriverManager.getConnection(jdbcUrl, usuario, contrasena)



        // Realizar operaciones en la base de datos aquí

        var declaracion = conexion.createStatement()

        var consultaempleado = declaracion.executeQuery("SELECT * FROM EMPLEADO WHERE IDNOMINA=1111;")


        while (consultaempleado.next()){
            empleado.dni=consultaempleado.getString(1)
            empleado.nombre=consultaempleado.getString(2)
            empleado.apellidos=consultaempleado.getString(3)
            empleado.idnomina=consultaempleado.getInt(4)
            empleado.oficio=consultaempleado.getString(5)
        }

        empleado.imprimir()
        




        // Cerrar la conexión cuando hayas terminado

        conexion.close()

    } catch (e: SQLException) {

        e.printStackTrace()

    } finally {

        conexion?.close()

    }

}