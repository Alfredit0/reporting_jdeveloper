package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/calius?"
                            + "user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from calius.alumnos");
            return writeResultSet(resultSet);
            
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private String writeResultSet(ResultSet resultSet) throws SQLException{
            String rows="";
            rows=rows+"<tr class=\"movierow\"><th class=\"column2\">Nombre Completo</th><th class=\"column1\">Licenciatura</th><th class=\"column3\">Grupo</th></tr>\n";
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String nom = resultSet.getString("alumnoNombre");
            String apellP = resultSet.getString("alumnoAp");
            String apellM = resultSet.getString("alumnoAm");
            String lic = resultSet.getString("alumnoLic");
            String grup = resultSet.getString("alumnoGrupo");
            rows=rows+"<tr class=\"movierow\"><td class=\"column2\">"+nom+" "+apellP+" "+ apellM+"</td><td class=\"column1\">"+
                 lic+"</td><td class=\"column3\">"+grup+"</td></tr>\n";
        }
        return rows;
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}