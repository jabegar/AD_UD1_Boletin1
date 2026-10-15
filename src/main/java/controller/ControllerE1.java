package controller;

import java.awt.List;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.RutaNoValidaException;

public class ControllerE1 {
	public static void main(String[] args) throws RutaNoValidaException {
		Logger logger = LogManager.getLogger(ControllerE1.class);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribe la ruta a encontrar");
		String ruta = scanner.nextLine();
		scanner.close();
		
		File directorio = new File(ruta);
		
		if (directorio.exists() && directorio.isDirectory()) {
			File[] listado = directorio.listFiles();
			int countFicheros = 0;
			int countDirectorios = 0;
			
			for (int i = 0; i < listado.length; i++) {
				File ficheroActual = listado[i];
				
				if (ficheroActual.isFile()) {
					logger.debug("[F] " + ficheroActual.getName());
					countFicheros++;
				}
				else {
					logger.debug("[D] " + ficheroActual.getName());
					countDirectorios++;
				}
			}
			
			logger.debug("Numero total de ficheros: " + countFicheros);
			logger.debug("Numero total de directorios: " + countDirectorios);
		}
		else {
			throw new RutaNoValidaException("Ruta no encontrada");
		}
	}
}
