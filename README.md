1) Cuando se instancia un Thread, este genera un unico objeto y se asocia a el.
    Al implementar la interfaz Runnable, en cambio, se puede compartir el mismo objeto con multiples Threads.
    
Ciclo de Vida
![Alt Text](http://3.bp.blogspot.com/-Li6r7FoUe5A/UIFRJKK4_GI/AAAAAAAAAEk/wgcVoICNtDU/s1600/CicloVidaThreadBasico.bmp)

Start(): Inicia la ejecucion del thread que llama al metodo, y la JVM realiza un llamado al metodo Run() de este thread.

Sleep(): Se pone en pausa la ejecucion de un thread por unos segundos o un tiempo especificado por el programador.

Yield(): Un Thread que llame al metodo yield() le indica a la VM que le esta permitiendo a otros threads sean programados en su lugar. No esta garantizado que va a pasar.

Join(): Puede ser usado para "unir"(join) el inicio de la ejecucion de un thread con el final de la ejecucion de otro, para que de esta manera no se empiece a ejecutar hasta que otro thread haya finalizado.