package controller;

import java.io.File;
import java.text.DecimalFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE5 {
	static Logger logger = LogManager.getLogger(ControllerE5.class);

	public static void main(String[] args) {
		ControllerE5 cl5 = new ControllerE5();
		File root = new File("c:/Users/alumno/eclipse-workspace/UD1boletin1");
		double tamanio = 0.0;
		
		if(root.exists()) {
			tamanio = cl5.sumarTamanio(root);
		}
		
		String dec;
		tamanio = tamanio / 1024;
		if (tamanio > 1024) {
			tamanio = tamanio / 1024;
			 dec = new DecimalFormat("#.##").format(tamanio) + "MB";
		}
		else {
			dec = new DecimalFormat("#.##").format(tamanio) + "KB";
		}
		logger.debug(dec);
		
	}
	
	public double sumarTamanio(File d) {		
		double tamanio = 0.0;
		File[] list = d.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				File f = list[i];
				
				if (f.isDirectory()) {
					tamanio += sumarTamanio(f);
				}
				else {
					tamanio += f.length();
				}
			}	
		}
		return tamanio;
	}

}
