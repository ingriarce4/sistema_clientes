package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {
	private Scanner sc = new Scanner(System.in);
	@Override
	public void exportar(String  FileName, Map<String, Cliente> listaCliente) {
		
		// TODO Auto-generated method stub
		try {
	
			
			System.out.println("Ingrese el nombre de usuario del equipo");

			String usuario = sc.next();

			String path = "C://Usuarios/" + usuario + "/Escritorio/";

			File carpeta = new File(path);

			File archivo = new File(path + FileName + ".csv");

		if (!carpeta.exists()) {

			
			carpeta.mkdirs();
			System.out.println("Directorio creado");
			try {
				archivo.createNewFile();
				FileWriter fileescritor = new FileWriter(archivo);
				BufferedWriter writ = new BufferedWriter(fileescritor);
				for (Entry<String, Cliente> client : listaCliente.entrySet()) {
					String cliente = String.format("%s, %s, %s, %s, %s", 
							client.getValue().getRunCliente(),
							client.getValue().getNombreCliente(), 
							client.getValue().getApellidoCliente(),
							client.getValue().getAnionsCliente(),
							String.valueOf(client.getValue().getCategoria()));
					writ.write(cliente);
					writ.newLine();
				}
				writ.close();

				System.out.println("Fichero creado");

			} catch (NullPointerException e) {
				System.out.println("Nulos");
			} catch (SecurityException e) {
				System.out.println("No hay acceso para modificar fichero");
			}
		} else {
			System.out.println("Directorio creado");
			try {
				archivo.createNewFile();
				FileWriter fileescritor = new FileWriter(archivo);
				BufferedWriter writ = new BufferedWriter(fileescritor);
				for (Entry<String, Cliente> client : listaCliente.entrySet()) {
					String cliente = String.format("%s, %s, %s, %s, %s", 
							client.getValue().getRunCliente(),
							client.getValue().getNombreCliente(), 
							client.getValue().getApellidoCliente(),
							client.getValue().getAnionsCliente(),
							String.valueOf(client.getValue().getCategoria()));
					writ.write(cliente);
					writ.newLine();
				}
				writ.close();

				System.out.println("Fichero creado");

			} catch (SecurityException e) {
				System.out.println("No se puede modificar fichero");
			 }
		   }
		} catch (IOException e) {
			System.out.println("No se pudo crear fichero");
	    }
	 }
	}
		
  
 