package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import modelo.Cliente;

//12.-create class ExportadorTxt: hashmap
public class ExportadorTxt extends Exportador {
	private Scanner sc = new Scanner(System.in);
	@Override
	public void exportar(String FileName, Map<String, Cliente> listaCliente) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Ingrese el nombre de usuario del equipo");

			String usuario = sc.next();
	
			String path = "C://Usuarios/" + usuario + "/Escritorio/";
			
			 File carpeta = new File(path);
	
			 File archivo = new File(path + FileName + ".txt");
			
			if (!carpeta.exists()) {
				carpeta.mkdirs();
				System.out.println("Directorio creado");
				
				try {
					carpeta.createNewFile();
					FileWriter fileescritor = new FileWriter(carpeta);
					BufferedWriter writ = new BufferedWriter(fileescritor);
					for (Entry<String, Cliente> client : listaCliente.entrySet()) {
						writ.write("Datos Cliente: ");
						writ.newLine();
						writ.write("Run Cliente: " +     client.getValue().getRunCliente());
						writ.newLine();
						writ.write("Nombre Cliente: " +  client.getValue().getNombreCliente());
						writ.newLine();
						writ.write("Apellido Cliente: " + client.getValue().getApellidoCliente());
						writ.newLine();
						writ.write("Años como Cliente: " + client.getValue().getAnionsCliente());
						writ.newLine();
						writ.write("Categoría Cliente: " + String.valueOf(client.getValue().getCategoria()));
						writ.newLine();
					}
					writ.close();

					System.out.println("Fichero creado");

				} catch (NullPointerException e) {
					System.out.println("Campos nulos");
				} catch (SecurityException e) {
					System.out.println("No hay acceso para modificar fichero");
				}
			} else {
				System.out.println("Directorio ya esta creado");
				
				try {
					archivo.createNewFile();
					FileWriter escritor = new FileWriter(archivo);
					BufferedWriter writ = new BufferedWriter(escritor);
					for (Entry<String, Cliente> client : listaCliente.entrySet()) {
						writ.write("Datos Cliente: ");
						writ.newLine();
						writ.write("Run Cliente: " +      client.getValue().getRunCliente());
						writ.newLine();
						writ.write("Nombre Cliente: " +   client.getValue().getNombreCliente());
						writ.newLine();
						writ.write("Apellido Cliente: " + client.getValue().getApellidoCliente());
						writ.newLine();
						writ.write("Años como Cliente: " + client.getValue().getAnionsCliente());
						writ.newLine();
						writ.write("Categoría Cliente: " + String.valueOf(client.getValue().getCategoria()));
						writ.newLine();
					}
					writ.close();

					System.out.println("Fichero creado");

				} catch (SecurityException e) {
					System.out.println("No se puede modificar fichero");
				}
		    
			  }

			} catch (IOException e) {
				System.out.println("no se pudo crear el fichero");
			}
		}

   }


