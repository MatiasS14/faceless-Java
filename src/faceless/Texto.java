package faceless;


public class Texto extends Archivo{
	Integer cantCaracteres;
		
	public Texto(Integer cantidadCaract) {
		this.cantCaracteres = cantidadCaract;
	}
	
	public Integer pesoArchivo() {
		return this.cantCaracteres;
	}
}
