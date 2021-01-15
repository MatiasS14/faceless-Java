package faceless;

public class Foto extends Archivo {
	private Integer alto ;
	private Integer ancho;
	private Integer factorDeCompresion;
	
	public Foto(Integer alto, Integer ancho, Integer factorDeCompresion) {
		this.alto = alto ;
		this.ancho= ancho;
		this.factorDeCompresion= factorDeCompresion;
	}
	
	public Integer pesoArchivo(){
		return this.alto * this.ancho * this.factorDeCompresion;
	}

}
