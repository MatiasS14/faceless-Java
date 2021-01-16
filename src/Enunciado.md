##Ejercicio 9: Faceless 
Un grupo de inversores, que no quiere dar la cara, nos contrató para llevar a cabo una red social. Faceless permite a los usuarios publicar diferentes tipos de contenidos, los cuales incluyen texto, fotos y videos, entre otros. Por cuestiones de almacenamiento en los servidores, nos interesará saber cuánto espacio ocupa cada publicación, en KB: 
•	Las fotos tienen un alto y ancho dado en pixels; el espacio que ocupan se calcula como (alto * ancho) * factor de compresión. El factor de compresión actual para las fotos es de 0.7, pero probablemente cambiará en el futuro. 
•	Las publicaciones de texto son mucho más fáciles de calcular, ya que el espacio que ocupan es igual a la cantidad de caracteres que tiene.
•	Los videos, tienen un tamaño que depende de la calidad que tenga: para la calidad normal, el tamaño es igual a la duración del video en segundos. Para los videos HD el tamaño es igual al triple de la duración en segundos del video. Deben poderse agregar en un futuro más calidades sin modificar el código existente.
Los usuarios que pueden ver una publicación pueden indicar que esa publicación les gusta, 
aumentando el número de  “me gustas” de la misma. A Faceless le importa tanto la cantidad de “me gustas” que recibió una publicación, como saber quiénes son los usuario que le dieron “me gustas”.
 Los usuarios de Faceless tienen “amigos”, pero no quieren compartir todas sus publicaciones con todos ellos.
 Por ejemplo, hay fotos y videos que no quieren que sus familias vean, por alguna extraña razón. Para satisfacer esa necesidad, cada publicación tiene asignado un permiso, que puede ser:
-	Público: cualquiera puede ver la publicación 
-	sólo amigos: sólo los amigos pueden verla 
-	privado con lista blanca: los usuarios que pertenezcan a la lista pueden verla 
-	privado con lista negra: los usuarios que no pertenezcan a la lista pueden verla. 
Se pide:
1. Saber cuánto espacio ocupa el total de las publicaciones de un usuario. 
2. Poder darle “me gusta” a una publicación, y conocer cuántas veces fue votada de esta forma.
3. Saber si un usuario es más amistoso que otro: esto ocurre cuando tiene más amigos
4. Saber si un usuario puede ver una publicación (porque tiene permisos). 
5. Determinar los mejores amigos de un usuario. Esto es, según la gente de faceless, el conjunto de sus amigos que pueden ver todas sus publicaciones.
6. Saber cuál es el amigo más popular que tiene un usuario. Es decir, el amigo que tiene más “me gusta” entre todas sus publicaciones. 
7. Saber si un usuario stalkea a otro. Lo cual ocurre si el stalker le dio ”me gusta” a más del 90 % de sus publicaciones. 
Armar los siguientes escenarios como tests:
Hacer que un usuario publique un contenido dado, con un permiso dado. 
Publicar un video para que esté accesible sólo para los amigos de un usuario
