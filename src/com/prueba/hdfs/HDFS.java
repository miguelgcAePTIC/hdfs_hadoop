package com.prueba.hdfs;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFS {
	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration (true);
		conf.set("fs.defaultFS", "http://localhost:9870/explorer.html#/");

		System.setProperty("HADOOP_USER_NAME", "root");
		
		try {
			FileSystem fs =  FileSystem.get(conf);
			
			//Crear un nuevo directorio
			String home = fs.getHomeDirectory().toString();
			
			//Comprobamos si la carpeta existe previamente a crearla
			String rutaDirPrueba =  home + "/dirPrueba";
			if (!fs.exists(new Path(rutaDirPrueba))) {
				fs.mkdirs(new Path(rutaDirPrueba));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	}

}
