package designpatterns;

class Connection {
	private static volatile Connection conn;
	
	private Connection() {
		System.out.println("conn obj created successfully");
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			synchronized (Connection.class) {
				if(conn == null) conn = new Connection();
			}
		}
		return conn;
	}
	
	
}

public class Singleton {

	public static void main(String [] args) {
		Connection conn1,conn2;
		conn1 = Connection.getConnection();
		conn2 = Connection.getConnection();
		System.out.println(conn1 == conn2);
		
		
	}
	
}
