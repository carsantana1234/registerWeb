package org.register.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//import com.mysql.jdbc.Driver;

@WebListener
public class AppContextListener implements ServletContextListener{

	//private Driver driver = null;
	
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 arg0.getServletContext().log("INICIAR RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		/*
		this.driver = new OracleDriver(); // load and instantiate the class
        boolean skipRegistration = false;
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver instanceof OracleDriver) {
                OracleDriver alreadyRegistered = (OracleDriver) driver;
                if (alreadyRegistered.getClass() == this.driver.getClass()) {
                    // same class in the VM already registered itself
                    skipRegistration = true;
                    this.driver = alreadyRegistered;
                    break;
                }
            }
        }

        try {
            if (!skipRegistration) {
                DriverManager.registerDriver(driver);
            } else {
                LOG.debug("driver was registered automatically");
            }
            LOG.info(String.format("registered jdbc driver: %s v%d.%d", driver,
                    driver.getMajorVersion(), driver.getMinorVersion()));
        } catch (SQLException e) {
            LOG.error(
                    "Error registering oracle driver: " + 
                            "database connectivity might be unavailable!",
                    e);
            throw new RuntimeException(e);
        }
        */
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 arg0.getServletContext().log("DESTRUYENDO    OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
		 //DatasourceConnection.closeDatasource();
         
	        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
	         
	        while (drivers.hasMoreElements()) {
	            Driver driver = drivers.nextElement();
	            try {
	                DriverManager.deregisterDriver(driver);
	                arg0.getServletContext().log("(JDBC driver (" + driver.toString() +
	                        ") successfully deregistered");
	            } catch (SQLException ex) {
	            	arg0.getServletContext().log( ex.getMessage());
	            }
	 
	        }
	}

}
