package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.RutaNoValidaException;

public class ControllerE2 {

	public static void main(String[] args) throws RutaNoValidaException, IOException {
		Logger logger = LogManager.getLogger(ControllerE1.class);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribe la ruta a encontrar");
		String ruta = scanner.nextLine();
		scanner.close();
		
		File archivo = new File(ruta);
		
		if (archivo.exists()) {
			logger.debug("Nombre archivo: " + archivo.getName());
			logger.debug("Ruta ingresada: " + ruta);
			logger.debug("Ruta absoluta: " + archivo.getAbsolutePath());
			logger.debug("Ruta canonica: " + archivo.getCanonicalPath());
			logger.debug("Archivo padre: " + archivo.getParent());
			logger.debug("Es un directorio: " + archivo.isDirectory());
			logger.debug("Puede leerse: " + archivo.canRead());
			logger.debug("Puede escribirse: " + archivo.canWrite());
			logger.debug("Puede ejecutarse: " + archivo.canExecute());
			logger.debug("Archivo oculto: " + archivo.isHidden());
			logger.debug("Tamaño total: " + archivo.getTotalSpace());
			if (archivo.isDirectory()) {
				logger.debug("Número de hijos: " + archivo.listFiles().length);				
			}
			logger.debug("Fecha modificación: " + archivo.lastModified());
		}
		else {
			throw new RutaNoValidaException(ruta);
		}
		
	}

}
