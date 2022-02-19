package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;


//Crear el método cargarDatos que recibe por parámetro un String fileName, el
//cual indica el nombre del archivo a cargar. Se deben realizar las
//implementaciones correspondientes al interior del método usando FileReader
//y BufferedReader (para lectura de archivos).

//Crear el método exportar que será una herencia proveniente de la clase
//Exportador, cuyos parámetros serán los mismos que se van a implementar en
//el paso 8

public class ArchivoServicio extends Exportador{
	private Scanner sc = new Scanner(System.in);
	private ExportadorTxt exporTx = new ExportadorTxt();
	private ExportadorCsv exportCsv = new ExportadorCsv();
	



	public ArchivoServicio(ExportadorCsv exportCsv,ExportadorTxt exporTx ) {
		this.exporTx  = exporTx;
		this.exportCsv = exportCsv;
	}


	
	
	public Map<String, Cliente> subirDatos(String FileName) {
		File archivo;
		Map<String, Cliente> listaCliente = new HashMap<String, Cliente>();
		String usuario= sc.next();
		String path = "C://Usuarios/" + usuario + "/Escritorio/" + FileName;
		archivo = new File(path);
		
		if (archivo.exists()) {
			try { 
				FileReader cargar = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(cargar);

				String data = lector.readLine();
				while (data != null) {
					String[] datos = data.split(",");
					//user
					Cliente subir = new Cliente(data, data, data, data, null);

					subir.setRunCliente(datos[0]);
					subir.setNombreCliente(datos[1]);
					subir.setApellidoCliente(datos[2]);
					subir.setAnionsCliente(datos[3]);
					subir.setCategoria(CategoriaEnum.ACTIVO);
					listaCliente.put(datos[0], subir);
					data = lector.readLine();
					
				}
				lector.close();
			} catch (FileNotFoundException ex) {
				ex.printStackTrace(System.out);
				// Archivo no existe
			} catch (IOException e) {
				e.printStackTrace(System.out);
				// no pude leer el archivo
			}
		} else {
			System.out.println("Archivo no existe en la ruta especificada");
			return null;
		}

		return listaCliente;
	}
		


	@Override
	public void exportar(String FileName, Map<String, Cliente> listaCliente) {
		// TODO Auto-generated method stub
		
		
		int opcion =0;
	
		do {	
			System.out.println("-----------Exportar Datos-----------\n");
			System.out.println("Seleccione formato para exportar");
			System.out.println("1.-Formato csv");
			System.out.println("2.-Formato txt\n");
			System.out.print("Selecciona una opcion para exportar : ");
			Utilidad.separador();
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				exporTx.exportar(FileName, listaCliente);
				Utilidad.separador();
				break;
			case 2:
				
				exportCsv.exportar(FileName, listaCliente);
				
				Utilidad.separador();
				
				break;
			case 3:
				
				Utilidad.limpiarPantalla();
				break;
		
				
			default:
				break;
			}
		  }while (opcion!=3);
		}
	
	}

	
