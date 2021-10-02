package edu.episen.si.ing1.pds.backend.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionPool {
	
	private static ArrayList<Connection> myCon = new ArrayList<Connection>();
	private Properties props;
	
	public JDBCConnectionPool(Properties props) throws FileNotFoundException, IOException {
					this.props= props;
		try {
			Class.forName(props.getProperty("jdbc.driver"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}	
	
	private Connection connectionFactory() {
		Connection con = null;
		try {
			
			String url = props.getProperty("jdbc.url");
			String login = props.getProperty("jdbc.login");
			String pwd = props.getProperty("jdbc.password");
			con = DriverManager.getConnection(url, login, pwd);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void turnConnection(int size) {
		try {
			for (int i = 0; i < size;i++) {
				myCon.add(connectionFactory());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void removeConnection(Connection con) {
		synchronized (myCon) {
			while(true) {
				if(!myCon.isEmpty()) {
					myCon.remove(con);
					//con.notify();
					return;
				}
				else {
					try {
						myCon.wait(3000);
						addConnection();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				
			}
			
			
		}
	}
	
	public Connection addConnection() {
		Connection con = connectionFactory();
		myCon.add(con);
		return con;
	}
	
	public void closeConnection() {
		for(Connection con: myCon)
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}