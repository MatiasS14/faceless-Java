package faceless;

public class VideoHD extends Video{
	
	public VideoHD(Integer duracion) {
		super(duracion);
	}
	
	public Integer pesoArchivo() {
		return super.pesoArchivo() * 3;
	}
}
