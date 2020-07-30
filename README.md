PROBLEMA LECTORES-ESCRITORES

1.DESCRIPCIÓN:

Existe un personaje llamado gestor que radica en este  lugar y es utilizado para poder llevar varios procesos a la vez, entre estos procesos se encuentran el de escribir y el de leer, solo se puede realizar uno de estos procesos a la vez, es decir, o se puede estar escribiendo o se puede estar leyendo, pero definitivamente no se puede hacer al mismo tiempo o simultáneamente, teniendo en cuenta que si no se lleva a cabo ninguno de esos procesos en esos momentos se le da preferencia al proceso de escritura sobre el proceso de lectura.

2.PERSONAJES:
-	Gestor: Es el encargado del proceso en general, como su mismo nombre lo dice gestiona o permite cuando puede ingresar un lector o cuando un escritor
-	Lector: Se encarga de llevar a cabo el proceso de lectura.
-	Escritor: Se encarga de llevar a cabo el proceso de la escritu .
-	Recursos: Serían los libros por decirlo así que serán usados tanto por los lectores como los escritores y su uso solo es permitido por el gestor

3.REGLAS DE ACCESO:
-	Solo puede haber un escritor al mismo tiempo, si algún otro personaje quiere ingresar y hay un escritor usando el recurso, entonces será rechazado y deberá esperar hasta que se culmine dicho proceso.
-	A diferencia del escritor como se ya se dijo anteriormente, puede haber varios lectores al mismo tiempo usando el recurso o, mejor dicho, el libro, pero si un escritor desea ingresar mientras que los lectores usan ese recurso, también será rechazado y deberá esperar hasta que el lector termine su proceso.
-	El último lector en ingresar debe habilitarla para que pueda ingresar el siguiente escritor que se encontraba en espera o en todo caso, al siguiente proceso que requiere usarla.

4.PRIORIDADES:

4.1 PRIORIDAD ESCRITORES:

Cuando un escritor se encuentra en modo espera, debe escribir lo antes posible, es decir, ningún lector debe empezar dicho recurso si hay algún escritor esperando.

4.2 PRIORIDAD LECTORES:

Ningún lector debe esperar salvo que un escritor se encuentre escribiendo en ese momento; un lector no espera por el hecho que un escritor se encuentre esperando.

5. PROCESO: 

El proceso en general se encuentra repartido en dichas imágenes adjuntadas en la carpeta imágenesLE: la primera hace referencia al recurso que será el centro de este proceso (imagenN1.png), después vemos que dos lectores se acercan para poder usar dicho recurso y como se ve no hay problema con ello, ambos pueden usarlo (imagenN2.png), la cuestión viene cuando un escritor se acerca a usar dicho recurso, será rechazado y tendrá que esperar tal como se muestra (imagenN3.png), ahora vemos que mientras los lectores se encuentran usando dicho recurso pero el escritor se encuentra esperando, si viene una lector más a querer usar dicho recurso será rechazado al igual que el lector (imagenN4.png), ahora, el primer lector ya acabo de usar dicho recursos pero el segundo lector lo sigue usando, entonces el escritor y el tercer lector seguirán esperando hasta que se encuentre en desuso(imaegnN5.png) y por último una vez que el segundo lector termina de hacerle uso al recurso recién se le permite la entrada al escritor para poder realizar su recurso aunque aún el tercer lector siga esperando, claro hasta que el escritor termine su proceso (imagenN6.png).

6. CASO 1:

DOS LECTORES Y UN ESCRITOR: 
Cuando el lector se acerca al recurso, el gestor verifica si puede tomar el recurso y cuando confirma, lo acepta y lo deja pasar al lugar, si un escritor quiere tomar el mismo recurso que el lector, no va a poder ingresar, entonces es rechazado y se encontrará en modo de espera, pero,  si se acerca un lector para obtener un recurso, si es aceptado ya que pueden haber varios lectores a la vez y cuando terminan de usar el recurso se marchan, cuando los lectores se fueron los escritores recién pueden tomar el recurso y cuando acaba este también se marcha.

7. SOLUCIÓN DEL PROBLEMA:

El lector deberá obtener acceso al gestor a través de una operación en el semáforo, en donde se podrá verificar tanto el ingreso de los lectores y su salida con dos operaciones llamadas “openLector” y “closeLector” esta captura del código se pueden ver en la carpeta imagenesLC (codigoN1.png), de igual manera sucede con los escritores, para poder monitorear sus acciones a través del gestor, se creó dos operaciones llamadas “openEscritor” y “closeEscritor” (codigoN2.png) y los siguientes lectores simplemente incrementan su contador en su respectivo proceso (codigoN3.png). A medida que los lectores salen y culminan su proceso, se decrementará dicho contador(codigoN4.png) y el último realiza la operación en el semáforo, para poder permitir que un escritor ingrese, de igual manera sucede con el escritor, se incrementa su contador cuando ingresa usar el recurso (codigoN5.png), y cuando terminen su usar el recurso, se decrementará su contador y así se culmina este proceso de poco a poco(codigoN6.png).

8.REFERENCIAS/FUENTES:
https://www2.infor.uva.es/~cllamas/concurr/pract98/sisos30/index.html#:~:text=LOS%20LECTORES%2DESCRITORES-,PROBLEMA%20DE%20LOS%20LECTORES%2DESCRITORES,DESCRIPCION%20DEL%20PROBLEMA%3A&text=Solo%20puede%20utilizar%20el%20recurso,el%20escritor%20ante%20el%20lector).

https://prezi.com/llus9gxf4rsx/el-problema-de-los-lectores-y-escritores/

https://www.youtube.com/watch?v=HShMFlcAUJ0&t=1605s

https://www2.infor.uva.es/~cllamas/concurr/pract98/sisos30/algorit.html

https://www.youtube.com/watch?v=w7fEEtCte60&t=6s

VIDEO DE YOUTUBE EXPLICATIVO: https://youtu.be/rwzoS3a3vMQ


