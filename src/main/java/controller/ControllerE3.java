package controller;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE3 {
	static Logger logger = LogManager.getLogger(ControllerE3.class);
	public static void main(String[] args) throws IOException {
		ControllerE3 cl3 = new ControllerE3();
		
		File directorio = new File(System.getProperty("user.home"), "miDirectorio");
		directorio.mkdir();
		
		if (directorio.exists()) {			
			File lectura = new File(directorio, "lectura.txt");
			lectura.createNewFile();
			lectura.setReadOnly();
			
			File normal = new File(directorio, "normal.txt");
			normal.createNewFile();
			
			cl3.mostrarPermisos(lectura);
			cl3.mostrarPermisos(normal);

			normal.renameTo(new File(normal.getParent() + File.separator + "renombrado.txt"));
			
			lectura.delete();
			lectura.setWritable(true);
			lectura.delete();
			
			File[] lista = directorio.listFiles();
			
			if (lista != null) {
				for (int i = 0; i < lista.length; i++) {
					File f = lista[i];
					
					logger.debug("--------------------------------------");
					logger.debug(f.getName());
					logger.debug(f.getAbsolutePath());
					logger.debug("--------------------------------------\n");
				}
			}
		}
	}
	
	public void mostrarPermisos(File f) {
		logger.debug(f.getName() + ": Puede leer -> " + f.canRead() + " Puede escribir-> " + f.canWrite() + " Puede ejecutar -> " + f.canExecute());
	}
}
