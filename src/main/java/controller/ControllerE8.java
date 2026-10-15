package controller;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerE8 {
	static Logger logger = LogManager.getLogger(ControllerE6.class);

	public static void main(String[] args) {
		ControllerE8 cl8 = new ControllerE8();
		File root = new File("c:/Users/alumno/eclipse-workspace/UD1boletin1");
		
		List<File> list = cl8.compararArchivo(root);
		
		logger.debug(list.size());
		
		List<File> list5 = list.stream().limit(5).collect(Collectors.toList());
		
		logger.debug(list5.size());
		logger.debug(list5);
	}
	
	public List<File> compararArchivo(File directory) {
		return Stream.of(directory.listFiles()).sorted(new ComparatorFileSize()).toList();
	}

}
