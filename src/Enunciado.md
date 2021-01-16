##Ejercicio 9: Faceless 
Un grupo de inversores, que no quiere dar la cara, nos contrat� para llevar a cabo una red social. Faceless permite a los usuarios publicar diferentes tipos de contenidos, los cuales incluyen texto, fotos y videos, entre otros. Por cuestiones de almacenamiento en los servidores, nos interesar� saber cu�nto espacio ocupa cada publicaci�n, en KB: 
�	Las fotos tienen un alto y ancho dado en pixels; el espacio que ocupan se calcula como (alto * ancho) * factor de compresi�n. El factor de compresi�n actual para las fotos es de 0.7, pero probablemente cambiar� en el futuro. 
�	Las publicaciones de texto son mucho m�s f�ciles de calcular, ya que el espacio que ocupan es igual a la cantidad de caracteres que tiene.
�	Los videos, tienen un tama�o que depende de la calidad que tenga: para la calidad normal, el tama�o es igual a la duraci�n del video en segundos. Para los videos HD el tama�o es igual al triple de la duraci�n en segundos del video. Deben poderse agregar en un futuro m�s calidades sin modificar el c�digo existente.
Los usuarios que pueden ver una publicaci�n pueden indicar que esa publicaci�n les gusta, 
aumentando el n�mero de  �me gustas� de la misma. A Faceless le importa tanto la cantidad de �me gustas� que recibi� una publicaci�n, como saber qui�nes son los usuario que le dieron �me gustas�.
 Los usuarios de Faceless tienen �amigos�, pero no quieren compartir todas sus publicaciones con todos ellos.
 Por ejemplo, hay fotos y videos que no quieren que sus familias vean, por alguna extra�a raz�n. Para satisfacer esa necesidad, cada publicaci�n tiene asignado un permiso, que puede ser:
-	P�blico: cualquiera puede ver la publicaci�n 
-	s�lo amigos: s�lo los amigos pueden verla 
-	privado con lista blanca: los usuarios que pertenezcan a la lista pueden verla 
-	privado con lista negra: los usuarios que no pertenezcan a la lista pueden verla. 
Se pide:
1. Saber cu�nto espacio ocupa el total de las publicaciones de un usuario. 
2. Poder darle �me gusta� a una publicaci�n, y conocer cu�ntas veces fue votada de esta forma.
3. Saber si un usuario es m�s amistoso que otro: esto ocurre cuando tiene m�s amigos
4. Saber si un usuario puede ver una publicaci�n (porque tiene permisos). 
5. Determinar los mejores amigos de un usuario. Esto es, seg�n la gente de faceless, el conjunto de sus amigos que pueden ver todas sus publicaciones.
6. Saber cu�l es el amigo m�s popular que tiene un usuario. Es decir, el amigo que tiene m�s �me gusta� entre todas sus publicaciones. 
7. Saber si un usuario stalkea a otro. Lo cual ocurre si el stalker le dio �me gusta� a m�s del 90 % de sus publicaciones. 
Armar los siguientes escenarios como tests:
Hacer que un usuario publique un contenido dado, con un permiso dado. 
Publicar un video para que est� accesible s�lo para los amigos de un usuario
