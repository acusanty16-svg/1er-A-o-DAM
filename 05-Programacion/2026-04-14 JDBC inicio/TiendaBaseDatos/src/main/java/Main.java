import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/tienda_thepw_dam", "root", "");
            System.out.println(connection.getCatalog());
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos");
            System.out.println(e.getMessage());
        }

    }
}
