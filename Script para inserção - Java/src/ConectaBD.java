import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
	
	private static final String user= "root";
	private static final String password= "";
	private static final String url= "jdbc:mysql://127.0.0.1:3306/geoprocessamento?useTimezone=true&serverTimezone=UTC";
	private static final String driver= "com.mysql.cj.jdbc.Driver";
	
	
	
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
		
	}
	
	/*public boolean insereDado(dados registro) {
		Conexao conn= open();
		System.out.println("Data: "+registro.getDataRegistro()+
				"\nOID: " + registro.getOID()+
				"\nID: "+registro.getId()+
				"\nXCoord: "+registro.getXCoord()+
				"\nYCoord: "+registro.getYCoord()+
				"\nRASTERVALU: "+registro.getRASTERVALU()+
				"\nCodVariavel: "+registro.getCodVariavel()+
				"\n");
		return true;
	}*/
	
}
