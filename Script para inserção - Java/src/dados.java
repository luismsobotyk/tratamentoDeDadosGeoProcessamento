import java.math.BigDecimal;

public class dados {
	
	private int OID;
	private int id;
	private BigDecimal XCoord;
	private BigDecimal YCoord;
	private BigDecimal RASTERVALU;
	private String dataRegistro;
	private String codVariavel;
	
	
	public int getOID() {
		return OID;
	}
	public void setOID(int oID) {
		OID = oID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getXCoord() {
		return XCoord;
	}
	public void setXCoord(BigDecimal xCoord) {
		XCoord = xCoord;
	}
	public BigDecimal getYCoord() {
		return YCoord;
	}
	public void setYCoord(BigDecimal yCoord) {
		YCoord = yCoord;
	}
	public BigDecimal getRASTERVALU() {
		return RASTERVALU;
	}
	public void setRASTERVALU(BigDecimal rASTERVALU) {
		RASTERVALU = rASTERVALU;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getCodVariavel() {
		return codVariavel;
	}
	public void setCodVariavel(String codVariavel) {
		this.codVariavel = codVariavel;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
