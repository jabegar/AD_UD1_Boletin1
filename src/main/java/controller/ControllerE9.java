package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE9 {
	static Logger logger = LogManager.getLogger(ControllerE9.class);

	public static void main(String[] args) {
		ControllerE9 cl9 = new ControllerE9();
		
		File dir = new File("src\\main\\resources\\borrar");
		cl9.borrarDirectorio(dir);
	}
	
	public void borrarDirectorio(File dir) {
		List<File> ficherosTotales = new ArrayList<File>();
		
		if (dir.exists()) {
			if(dir.isDirectory()) {
				ficherosTotales.addAll(this.obtenerSubdirectorios(dir));
			}
			ficherosTotales.add(dir);
			Scanner sc = new Scanner(System.in);
			logger.debug("Se van a borrar " + ficherosTotales.size() + " archivos, ¿Estás seguro?(Sí o no)");
			String res = sc.next();
			sc.close();
			if (res.equals("Sí")) {
				for (File file : ficherosTotales) {
					file.delete();
				}
				logger.debug("Se han borrado todos los ficheros");
			}
			else {
				logger.debug("No se ha borrado ningún mensaje");
			}
		}
		else {
			logger.debug("No existe el directorio");
		}
		
	}
	
	public List<File> obtenerSubdirectorios(File dir) {
		List<File> ficherosTotales = new ArrayList<File>();
		if (dir.exists()) {
			if (dir.isDirectory()) {
				File[] hijos = dir.listFiles();
				if (hijos != null) {
					for (File hijo : hijos) {
						ficherosTotales.addAll(this.obtenerSubdirectorios(hijo));
					}
				}
			}
			ficherosTotales.add(dir);
		}
		
		return ficherosTotales;
	}
}
