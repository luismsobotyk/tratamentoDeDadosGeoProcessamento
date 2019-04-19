import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;  
import java.sql.PreparedStatement;  

public class Main {	

	public static void main(String args []) throws SQLException{
		long tempoInicio = System.currentTimeMillis();		
		 Main obj = new Main();
		 try{
			 obj.run();
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		 System.out.println("Tempo de execução: "+(System.currentTimeMillis()-tempoInicio)+" ms");
	}

	public void run() throws Exception{
	//Listagem de Arquivos na pasta
	File folder = new File("CSV_Files/");
	File[] listOfFiles = folder.listFiles();
	
	//Leitura dos Arquivos
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    
    
    Connection con = ConectaBD.getConnection();
	String sql="INSERT INTO dados (OID, id, XCoord, YCoord, RASTERVALU, dataRegistro, codVariavel) values (?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement stmt = con.prepareStatement(sql);
	con.setAutoCommit(false);
    
    
    boolean primeiraLinha= true; // Variável a ser usada para pular a primeira linha
    for (int i = 0; i < listOfFiles.length; i++) { if (listOfFiles[i].isFile()) {
    	String data= listOfFiles[i].getName().substring(0,4)+"-"+listOfFiles[i].getName().substring(4,6)+"-"+listOfFiles[i].getName().substring(6,8);
    	String codVariavel= listOfFiles[i].getName().substring(9,15);
    	try {

    		br = new BufferedReader(new FileReader(listOfFiles[i]));
    		while ((linha = br.readLine()) != null) {
    			if(primeiraLinha) {
    				primeiraLinha= false;
    				continue;
    			}else {
    				
    				String[] dados = linha.split(csvDivisor);
    				
    				dados registro= new dados();
    				registro.setOID(Integer.parseInt(dados[0]));
    				registro.setId(Integer.parseInt(dados[1]));
    				registro.setXCoord(new BigDecimal(dados[2].replaceAll(",", ".")));
    				registro.setYCoord(new BigDecimal(dados[3].replaceAll(",", ".")));
    				registro.setRASTERVALU(new BigDecimal(dados[4].replaceAll(",", ".")));
    				registro.setDataRegistro(data);
    				registro.setCodVariavel(codVariavel);
    				
    				
    				
    				try {
    					stmt.setInt(1, registro.getOID());
    					stmt.setInt(2, registro.getId());
    					stmt.setBigDecimal(3, registro.getXCoord());
    					stmt.setBigDecimal(4, registro.getYCoord());
    					stmt.setBigDecimal(5, registro.getRASTERVALU());
    					stmt.setString(6, registro.getDataRegistro());
    					stmt.setString(7, registro.getCodVariavel());
    					//stmt.execute();
    					stmt.addBatch();
    					System.out.println("Progresso: "+(i*100/listOfFiles.length)+"%");
    				}catch(SQLException e) {
    					throw new RuntimeException(e);
    				}
    				
    				
    			
    				
    				//con.insereDado(registro);
    				
    				
    				/*System.out.println("Data: "+data+
    								"\nOID: " + dados[0]+
                					"\nID: "+dados[1]+
                					"\nXCoord: "+dados[2].replaceAll(",", ".")+
                					"\nYCoord: "+dados[3].replaceAll(",", ".")+
                					"\nRASTERVALU: "+dados[4].replaceAll(",", ".")+
                					"\nCodVariavel: "+codVariavel+
                					"\n"); // Replace "," por "." para posterior inserção em Banco de Dados*/
    			}    			
    		}
    		primeiraLinha= true;

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (br != null) {
    			try {
    				br.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	stmt.executeBatch();
    	con.commit();
    	
    }
    
    
}
    System.out.println("Progresso: 100%");
}



}



