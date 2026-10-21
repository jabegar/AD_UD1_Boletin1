package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ControllerE10 {
	static Logger logger = LogManager.getLogger(ControllerE10.class);
	public static void main(String[] args) {
		ControllerE10 cl10 = new ControllerE10();
		cl10.organizaCarpeta(new File("C:\\Users\\jesus\\Downloads"));
	}
	
	public void organizaCarpeta(File dir) {
		if (dir.exists() && dir.isDirectory()) {
			logger.debug("El directorio existe");
			File[] ficheros = dir.listFiles();
			
			if (ficheros != null) {
				logger.debug("El directorio tiene hijos");
				Set<String> exts = new HashSet<String>();
				Map<String, List<File>> extFileMap = new HashMap<String, List<File>>();
				for (File file : ficheros) {
					if (file.isFile()) {		
						logger.debug("El fichero hijo es un fichero");
						String filename = file.getName();
						int dotIndex = filename.lastIndexOf(".");
						String ext = filename.substring(dotIndex + 1);
						exts.add(ext);
						
						if (extFileMap.get(ext) != null) {
							extFileMap.get(ext).add(file);
						}
						else {
							extFileMap.put(ext, new ArrayList<File>());
							extFileMap.get(ext).add(file);
						}
					}
				}
				for (String ext : exts) {
					File directorio = new File(dir.getAbsolutePath() + File.separator + ext);
					directorio.mkdir();
					
					List<File> fileMismaExt = extFileMap.get(ext);
					
					for (File file : fileMismaExt) {
						File fileMovido = new File(directorio.getAbsolutePath() + File.separator + file.getName());
						
						if (fileMovido.exists()) {
							file.renameTo(new File(directorio.getAbsolutePath() + File.separator + file.getName().split("\\.")[0] + "(1)." + file.getName().split("\\.")[1]));							
						}
					}
				}
			}
			else {
				logger.debug("La carpeta no tiene hijos");
			}
		}
		else {
			logger.debug("La carpeta no existe o no es un directorio");
		}
	}
	
}
