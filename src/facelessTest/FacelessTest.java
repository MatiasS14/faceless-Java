package facelessTest;
import faceless.*;
import faceless.archivos.Archivo;
import faceless.archivos.Foto;
import faceless.archivos.Texto;
import faceless.archivos.Video;
import faceless.archivos.VideoHD;
import faceless.borrador.BorradorPublicacion;
import faceless.permisos.PermisoListaBlanca;
import faceless.permisos.PermisoListaNegra;
import faceless.permisos.PermisoPublico;
import faceless.permisos.PermisoSoloAmigos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

class FacelessTest {
	//Faceless
	Faceless faceless;
	//Usuarios	
	Usuario pepe     		; 
	Usuario martin   		;
	Usuario laura    		;
	Usuario florencia		;
	Usuario marcelo  		;
	Usuario adrian   		;
	Usuario carla    		;
	//Listas blanca y negra para permisos
	Set<Usuario> listaBlanca;
	Set<Usuario> listaNegra ;
	//Archivos
	Archivo foto1  ;
	Archivo foto2  ;
	Archivo foto3  ;
	Archivo video  ;
	Archivo video2 ;
	Archivo videoHD;
	Archivo texto1 ;
	Archivo texto2 ;
	Archivo texto3 ;
	//Permisos
	PermisoPublico permisoPublico	     ;
	PermisoListaBlanca permisoListaBlanca;
	PermisoListaNegra permisoListaNegra  ;
	PermisoSoloAmigos permisoSoloAmigosPepe  ;
	//Borradores Publicaciones
	BorradorPublicacion borradorPublicacionPepe1  ;
	BorradorPublicacion borradorPublicacionPepe2  ;
	BorradorPublicacion borradorPublicacionPepe3  ;
	BorradorPublicacion borradorPublicacionPepe4  ;
	BorradorPublicacion borradorPublicacionLaura  ;
	BorradorPublicacion borradorPublicacionMarcelo;
	BorradorPublicacion borradorPublicacionCarla  ;
	//Publicaciones
	Publicacion publicacionPepe1  ;
	Publicacion publicacionPepe2  ;
	Publicacion publicacionPepe3  ;
	Publicacion publicacionPepe4  ;
	Publicacion publicacionLaura  ;
	Publicacion publicacionMarcelo;
	Publicacion publicacionCarla  ;
	
	@BeforeEach
	public void setup() {
		//Instancia de faceless
		faceless    = new Faceless()       	;
		//Algunos usuarios
		pepe        = new Usuario(faceless)	;
		martin      = new Usuario(faceless)	;
		laura       = new Usuario(faceless)	;
		florencia   = new Usuario(faceless)	;
		marcelo     = new Usuario(faceless)	;
		adrian      = new Usuario(faceless)	;
		carla       = new Usuario(faceless)	;
		//Inicializacion de listas blanca y negra
		//para los permisos
		listaBlanca = new HashSet<Usuario>();
		listaNegra  = new HashSet<Usuario>();
		//Archivos para hacer publicaciones
		foto1   	= new Foto(10, 30, 2)	;//Foto de pepe 
		foto2   	= new Foto(20, 20, 2)	;//foto de laura
		foto3   	= new Foto(22, 10, 4)	;//foto de pepe
		video   	= new Video(15)      	;//video de pepe
		video2  	= new Video(30)      	;//video de marcelo
		videoHD 	= new VideoHD(30) 	 	;//video de carla
		texto1  	= new Texto(10)	  	 	;//texto de adrian
		texto2  	= new Texto (40)  	 	;//texto de florencia
		texto3  	= new Texto (80)  	 	;//texto de pepe
		//Listas blanca y negra de pepe
		listaBlanca = new HashSet<Usuario>();
		listaNegra  = new HashSet<Usuario>();
		//Permisos
		permisoPublico     = new PermisoPublico()               	;
		permisoListaBlanca = new PermisoListaBlanca(listaBlanca)	;//listaBlanca de pepe
		permisoListaNegra  = new PermisoListaNegra(listaNegra)  	;//listaNegra de pepe
		permisoSoloAmigosPepe  = new PermisoSoloAmigos(pepe);
		//Publicaciones
				//borradores publicaciones pepe
		borradorPublicacionPepe1 = new BorradorPublicacion(pepe, foto1, permisoPublico);
		borradorPublicacionPepe2 = new BorradorPublicacion(pepe, foto3, permisoListaBlanca);
		borradorPublicacionPepe3 = new BorradorPublicacion(pepe, video, permisoListaNegra);
		borradorPublicacionPepe4 = new BorradorPublicacion(pepe, texto3, permisoSoloAmigosPepe);
				//publicaciones pepe
		publicacionPepe1 = new Publicacion(borradorPublicacionPepe1);
		publicacionPepe2 = new Publicacion(borradorPublicacionPepe2);
		publicacionPepe3 = new Publicacion(borradorPublicacionPepe3);
		publicacionPepe4 = new Publicacion(borradorPublicacionPepe4);
				//borradores publicaciones laura
		borradorPublicacionLaura = new BorradorPublicacion (laura, foto2, permisoPublico);
				//publicacion laura
		publicacionLaura = new Publicacion (borradorPublicacionLaura);
	}
	
	@Test
	void testPermisoSoloAmigos() {
		//pepe agrega amigos
		pepe.agregarAmigo(laura);
		pepe.agregarAmigo(marcelo);
		pepe.agregarAmigo(florencia);
		pepe.agregarAmigo(adrian);
		pepe.agregarAmigo(carla);
		//pepe hace una publicacion
		pepe.realizarPublicacion(publicacionPepe4);
		assertFalse(martin.puedeVerPublicacion(publicacionPepe4));
		assertTrue(laura.puedeVerPublicacion(publicacionPepe4));
	}
	
	@Test
	void testPermisoPublico(){
		assertTrue(martin.puedeVerPublicacion(publicacionLaura));
		assertTrue(pepe.puedeVerPublicacion(publicacionLaura));
		assertTrue(carla.puedeVerPublicacion(publicacionLaura));
		assertTrue(adrian.puedeVerPublicacion(publicacionLaura));
	}
	
	@Test
	void testPermisoListaBlanca(){
		listaBlanca.add(laura);
		listaBlanca.add(marcelo);
		listaBlanca.add(carla);
		assertTrue(laura.puedeVerPublicacion(publicacionPepe2));
		assertTrue(marcelo.puedeVerPublicacion(publicacionPepe2));
		assertTrue(carla.puedeVerPublicacion(publicacionPepe2));
		assertFalse(adrian.puedeVerPublicacion(publicacionPepe2));
	}
	
	@Test
	void testPermisoListaNegra(){
		listaNegra.add(martin);
		listaNegra.add(adrian);
		assertFalse(adrian.puedeVerPublicacion(publicacionPepe3));
		assertFalse(martin.puedeVerPublicacion(publicacionPepe3));
		assertTrue(marcelo.puedeVerPublicacion(publicacionPepe3));
		assertTrue(carla.puedeVerPublicacion(publicacionPepe3));
	}
	
	@Test
    void testCaracterisiticasPublicaciones() {
		//peso de publicaciones
		assertEquals(publicacionPepe1.peso(), 600)	 ;
		assertEquals(publicacionPepe2.peso(), 880)	 ;
		assertEquals(publicacionPepe3.peso(), 15) 	 ;
		assertEquals(publicacionPepe4.peso(), 80) 	 ;
		//pepe hace las publicaciones
		pepe.realizarPublicacion(publicacionPepe1)	 ;
		pepe.realizarPublicacion(publicacionPepe2)	 ;
		pepe.realizarPublicacion(publicacionPepe3)	 ;
		pepe.realizarPublicacion(publicacionPepe4)   ;
		//chequea el peso total de las aplicaiones de pepe
		assertEquals(pepe.pesoPublicaciones(), 1575) ;
		//peso de archivos
		assertEquals(foto2.pesoArchivo(), 800)    ;
		assertEquals(video2.pesoArchivo(), 30)	  ;
		assertEquals(videoHD.pesoArchivo(), 90)	  ;
		assertEquals(texto1.pesoArchivo(), 10)    ;
		assertEquals(texto2.pesoArchivo(), 40)    ;
	}
	
	@Test
	void testAmigos() {
		//laura agrega amigos
		laura.agregarAmigo(adrian) 			   ;
		laura.agregarAmigo(marcelo)			   ;
		laura.agregarAmigo(martin) 			   ;
		laura.agregarAmigo(carla)  			   ;
		laura.agregarAmigo(pepe)  			   ;
		//adrian agrega amigos
		adrian.agregarAmigo(marcelo)		   ;
		adrian.agregarAmigo(martin) 		   ;
		adrian.agregarAmigo(carla)  		   ;
		//martin agrega a laura y adrian
		martin.agregarAmigo(laura)			   ;
		martin.agregarAmigo(adrian)			   ;
		//chequea que es amigo de los que agrego
		assertTrue(laura.esAmigoDe(adrian))    ;
		assertTrue(laura.esAmigoDe(marcelo))   ;
		assertTrue(laura.esAmigoDe(martin))    ;
		assertTrue(laura.esAmigoDe(carla))     ;
		//chequea que la cantidad de amigos es la correspondiente
		assertEquals(laura.cantidadAmigos(), 5);
		//laura elimina a marcelo
		laura.eliminarAmigo(marcelo)		   ;
		assertEquals(laura.cantidadAmigos(), 4);
		//chequea los amigos de laura 
		assertTrue(laura.esAmigoDe(adrian))	   ;
		assertTrue(laura.esAmigoDe(martin))	   ;
		assertTrue(laura.esAmigoDe(carla))	   ;
		assertTrue(laura.esAmigoDe(pepe))      ;
		assertFalse(laura.esAmigoDe(marcelo))  ;
		
		
		//laura tiene mas amigos que adrian
		assertTrue(laura.esMasAmistosoQue(adrian));
		assertFalse(adrian.esMasAmistosoQue(laura));
	}
	
	@Test
	void testMeGusta() {
		//pepe agrega amigos
		pepe.agregarAmigo(martin);
		pepe.agregarAmigo(laura);
		pepe.agregarAmigo(florencia);
		pepe.agregarAmigo(marcelo);
		pepe.agregarAmigo(adrian);
		//se registran las publicaciones en faceless
		pepe.realizarPublicacion(publicacionPepe1);
		pepe.realizarPublicacion(publicacionPepe2);
		pepe.realizarPublicacion(publicacionPepe3);
		pepe.realizarPublicacion(publicacionPepe4);
		//laura registra publicacion en faceless
		laura.realizarPublicacion(publicacionLaura);
		//laura recibe me gusta
		martin.darMeGusta(publicacionLaura);
		adrian.darMeGusta(publicacionLaura);
		pepe.darMeGusta(publicacionLaura)  ;
		carla.darMeGusta(publicacionLaura) ;
		
		//adrian agrega a pepe y laura como amigos
		adrian.agregarAmigo(laura);
		adrian.agregarAmigo(pepe);
		//amigo mas popular es laura
		//porque a pepe no se le dio me gusta aun
		assertEquals(adrian.amigoMasPopular(), laura);
		
		//se establecen las listas blanca y negra
		listaBlanca.add(florencia);
		listaBlanca.add(marcelo)  ;
		listaBlanca.add(laura)	  ;
		
		listaNegra.add(martin)	  ;
		listaNegra.add(adrian)	  ;
		
		//agregar usuario a lista negra y sacarlo
		assertTrue(laura.puedeVerPublicacion(publicacionPepe3));//puede ver publicacion
		permisoListaNegra.incluirAListaNegra(laura);//se incluye a laura a lista negra
		assertFalse(laura.puedeVerPublicacion(publicacionPepe3));//ya no puede ver publicacion
		permisoListaNegra.excluirDeListaNegra(laura);//se la retira de la lista negra 
		assertTrue(laura.puedeVerPublicacion(publicacionPepe3));//puede ver la publicacion nuevamente

		//agregar usuario a lista blanca y sacarlo
		assertFalse(adrian.puedeVerPublicacion(publicacionPepe2));//puede ver publicacion
		permisoListaBlanca.incluirAListaBlanca(adrian);//se incluye a laura a lista negra
		assertTrue(adrian.puedeVerPublicacion(publicacionPepe2));//ya no puede ver publicacion
		permisoListaBlanca.excluirDeListaBlanca(adrian);//se la retira de la lista negra 
		assertFalse(adrian.puedeVerPublicacion(publicacionPepe2));//puede ver la publicacion nuevamente

		//se empieza a dar me gusta en las publicaciones de pepe
		florencia.darMeGusta(publicacionPepe1);
		florencia.darMeGusta(publicacionPepe2);
		florencia.darMeGusta(publicacionPepe3);
		florencia.darMeGusta(publicacionPepe4);
		
		marcelo.darMeGusta(publicacionPepe1);
		marcelo.darMeGusta(publicacionPepe2);
		marcelo.darMeGusta(publicacionPepe3);
		marcelo.darMeGusta(publicacionPepe4);
		//ahora pepe es el amigo mas popular de adrian
		assertEquals(adrian.amigoMasPopular(), pepe);
		//se chequea la cantidad de megusta que recibe pepe
		assertEquals(pepe.cantidadDeMeGustaRecibidoDe(florencia), 4);
		assertEquals(pepe.cantidadDeMeGustaRecibidoDe(marcelo), 4)  ;
		assertEquals(pepe.cantidadDeMeGustaRecibidoDe(adrian), 0)   ;
		//chequea la cantidad total de me gusta recibidos de pepe
		assertEquals(pepe.meGustaRecibidos(), 8);
		//stalkers
		assertTrue(florencia.stalkeaA(pepe));
		assertTrue(marcelo.stalkeaA(pepe))	;
		assertFalse(adrian.stalkeaA(pepe))	;
		assertFalse(laura.stalkeaA(pepe))	;
		
		//Set para chequear mejores amigos de pepe
		Set<Usuario> mejoresAmigosEsperados = new HashSet<Usuario>();
		mejoresAmigosEsperados.add(florencia);
		mejoresAmigosEsperados.add(marcelo);
		mejoresAmigosEsperados.add(laura);
		//chequeamos que coincida el resultado con lo esperado
		assertEquals(pepe.mejoresAmigos(), mejoresAmigosEsperados);
		
		
		
		
	}
}
