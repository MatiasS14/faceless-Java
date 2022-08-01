package faceless;
import java.util.Set;

import faceless.Errores.ErrorPublicacion;
import faceless.archivos.Archivo;
import faceless.borrador.BorradorPublicacion;
import faceless.permisos.Permiso;

import java.util.HashSet;

public class Publicacion {
	private Usuario usuario     ;
	private Archivo archivo     ;
	private Permiso permiso     ;
	private Set<MeGusta> meGustaRecibidos;
	
	public Publicacion(BorradorPublicacion bPublicacion) {
		this.usuario = bPublicacion.getUsuario()               ;
		this.archivo= bPublicacion.getArchivo()                ; 
		this.permiso= bPublicacion.getPermiso()                ;
		this.meGustaRecibidos= new HashSet<MeGusta>();
	}
	
	public void publicar() throws ErrorPublicacion{
		verificarValidez();
		this.usuario.realizarPublicacion(this);
	}
	
	private void verificarValidez() throws ErrorPublicacion{
		if(this.usuario == null) {throw new ErrorPublicacion("Usuario invalido");};
		if(this.archivo == null) {throw new ErrorPublicacion("Seleccionar archivo");};
		if(this.permiso == null) {throw new ErrorPublicacion("Elegir permiso");};
	}
	
	public void recibirMeGusta(MeGusta megusta) {
		this.meGustaRecibidos.add(megusta);
	}
	
	public Integer peso() {
		return this.archivo.pesoArchivo();
	}
	
	public Usuario usuario() {
		return this.usuario;
	}
	
	public Integer cantidadMeGusta() {
		return this.meGustaRecibidos.size();
	}
	
	public Boolean recibioMeGustaDe(Usuario usuario) {
		Boolean ret = false;
		for(MeGusta meGusta : this.meGustaRecibidos) {
			ret = ret || meGusta.usuario() == usuario;
		}
	 return ret;
	}
	
	public Boolean dejarVerPublicacion(Usuario usuario) {
		return this.permiso.puedeVerPublicacion(usuario);
	}
}
