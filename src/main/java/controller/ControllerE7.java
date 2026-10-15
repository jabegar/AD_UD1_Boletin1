package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE7 {
	static Logger logger = LogManager.getLogger(ControllerE7.class);

	public static void main(String[] args) {
		ControllerE7 cl7 = new ControllerE7();
		
		List<File> list = cl7.buscar(new File("C:\\Users\\alumno\\miDirectorio"), "BUScaesTO");
		
		logger.debug(list);

	}
	
	List<File> buscar(File dir, String nombre) {
		List<File> list = new ArrayList<File>(); 
		
		if (dir.isFile() && dir.getName().toLowerCase().contains(nombre.toLowerCase())) {
			list.add(dir);
		}
		else if (dir.isDirectory()) {
			File[] hijos = dir.listFiles();
			for (File hijo : hijos) {
				list.addAll(buscar(hijo,nombre));
			}
		}
		
		return list;
	}

}
