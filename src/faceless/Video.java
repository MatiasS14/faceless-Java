package faceless;

public class Video extends Archivo{
	protected Integer segundosDuracion;
	
	public Video(Integer duracion) {
		this.segundosDuracion = duracion;
	}
	
	public Integer pesoArchivo() {
		return this.segundosDuracion;
	}
}
