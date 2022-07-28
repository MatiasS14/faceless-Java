package faceless.archivos;


public class Texto extends Archivo{
	private Integer cantCaracteres;
		
	public Texto(Integer cantidadCaract) {
		this.cantCaracteres = cantidadCaract;
	}
	
	public Integer pesoArchivo() {
		return this.cantCaracteres;
	}
}
