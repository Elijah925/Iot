
package uts.isd.model.dao;

import java.sql.Connection;

/**
 *
 * @author 47288
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db="productDB";
    protected String dbuser = "Elijah";
    protected String dbpassword = "Elijah";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
