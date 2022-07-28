package faceless.borrador;

import faceless.Usuario;
import faceless.archivos.Archivo;
import faceless.permisos.Permiso;

public class BorradorPublicacion {
	private Usuario usuario ;
	private Archivo archivo;
	private Permiso permiso ;
	
	public BorradorPublicacion(Usuario usuario, Archivo archivo, Permiso permiso) {
		this.usuario = usuario;
		this.archivo = archivo;
		this.permiso = permiso;
	}
	
	public Usuario getUsuario() {return this.usuario;}
	public Archivo getArchivo() {return this.archivo;}
	public Permiso getPermiso() {return this.permiso;}
}
