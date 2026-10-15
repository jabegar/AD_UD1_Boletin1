package controller;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE6 {
	static Logger logger = LogManager.getLogger(ControllerE6.class);

	public static void main(String[] args) {

		ControllerE6 cl6 = new ControllerE6();
		
		File d = new File("C:\\Users\\alumno\\miDirectorio");
		File[] lista = cl6.filtrar(d);
		
		for (File f : lista ) {
			logger.debug(f);
		}
	}
	
	public File[] filtrar(File d) {
		File[] list = null;
		if (d.isDirectory()) {
			FiltroArchivo fa = new FiltroArchivo();
			 list = d.listFiles(fa);
		}
		return list;
	}

}
