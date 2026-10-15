package controller;

import java.io.File;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE4 {
	static Logger logger = LogManager.getLogger(ControllerE4.class);

	public static void main(String[] args) {
		ControllerE4 cl4 = new ControllerE4();
		
		File root = new File("c:/Users/alumno/eclipse-workspace/UD1boletin1");
		
		if(root.exists()) {
			cl4.mostrarContenido(root);
		}
	}
	
	public void mostrarContenido(File d) {		
//		logger.debug("--------------------------------------");
//		logger.debug(d.getName());
//		logger.debug(d.getAbsolutePath());
//		logger.debug("--------------------------------------\n");
		
		File[] list = d.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				File f = list[i];
				
				if (f.isDirectory()) {
					this.mostrarContenido(f);
				}
				else {
					logger.debug("--------------------------------------");
					logger.debug(f.getName());
					logger.debug(f.getAbsolutePath());
					logger.debug("--------------------------------------\n");
				}
			}	
		}
	}

}
