package vista;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ClienteServicioDev;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

// Create classe Menu with the following atributes

// 6.- Create the classe Menu with the following attributes 
//clienteServicio, instancia de ClienteServicio.
// archivoServicio, instancia de ArchivoServicio.
// exportadorCsv, instancia de ExportarCsv.
// exportarTxt, instancia de ExportarTxt.
// Definir un String fileName = “Clientes” (para exportar el archivo)
// Definir un String fileName1 = “DBClientes.csv” (para importar el archivo)
// scanner, instancia de Scanner para recibir valores a través del teclado.
//del scanner. Contiene la lógica para denotar los demás métodos en base a la
//entrada del teclado.


public class Menu extends MenuTemplate{
	
	private ClienteServicioDev cliSer = new ClienteServicioDev();
	private ExportadorCsv exportCsv = new ExportadorCsv();
	private ExportadorTxt exporTx = new ExportadorTxt();
	private ArchivoServicio archivoServicio =new ArchivoServicio(exportCsv,exporTx);
	private String FileName = "Clientes";

	private Scanner sc = new Scanner(System.in);
	

	@Override
	public void listarClientes() {
	    
		// TODO Auto-generated method stub
		
		cliSer.getListaCliente().entrySet().forEach(entry -> { Cliente client = entry.getValue();
		System.out.println("El RUN del Cliente : "     +  client.getRunCliente());
		System.out.println("El Nombre del Cliente : "  +   client.getNombreCliente());	
		System.out.println("El Apellido del Cliente : " + client.getApellidoCliente());
		System.out.println("La edad del cliente es: " +     client.getAnionsCliente());
		System.out.println("El estado del Cliente es: " + client.getCategoria());
		System.out.println("************************");
		System.out.println();
	});
	}
	
	@Override
	public void agregarClientes() {
		// TODO Auto-generated method stub
		Utilidad.separador();
		System.out.println("***************Agregar Cliente***************");
		Utilidad.separador();

		Utilidad.separador();
		System.out.println("Ingresa RUN del Cliente");
		Utilidad.separador();
		String run = sc.nextLine();

		Utilidad.separador();
		System.out.println("Ingresa Nombre del Cliente");
		Utilidad.separador();
		String nombre = sc.nextLine();

		Utilidad.separador();
		System.out.println("Ingresa Apellido del Cliente");
		Utilidad.separador();
		String apellido = sc.nextLine();

		Utilidad.separador();
		System.out.println("Ingresa Años del Cliente");
		Utilidad.separador();
		String anios = sc.nextLine();

		Cliente client = new Cliente(run, nombre, apellido, anios,CategoriaEnum.ACTIVO);

		cliSer.agregarCliente(client);
		

	}

	@Override
	public void editarClientes() {
		// TODO Auto-generated method stub
	
		int opcion= 0;
		String run="";
	
		do { 
			System.out.println("-------------Editar Cliente-------------");
			Utilidad.separador();
			System.out.println("Seleccione qué desea hacer: ");
			System.out.println("1.- Cambiar el estado del Cliente");
			Utilidad.separador();
			System.out.println("2.- Editar los datos del Cliente");
			Utilidad.separador();
			System.out.println("3.- Salir");
			System.out.println();
			Utilidad.separador();
			System.out.println("Ingrese una opción: ");
			opcion= sc.nextInt();
			
			System.out.println("---------------------------------------");
			
			switch (opcion) {
			case 1:
				System.out.println("Ingrese el RUN del Cliente a editar para cambiar estado");
				
				run = sc.next();
				cliSer.editarEstado(cliSer.getListaCliente().get(run));
				System.out.println("---------------------------------------");
				break;
			case 2:
				//llamar al metodo 
				System.out.println("Ingrese el RUN del Cliente a editar");
				run = sc.next();
				Cliente client1= cliSer.getListaCliente().get(run);
				                 cliSer.editarCliente1(run, client1.getNombreCliente(), client1.getApellidoCliente(), client1.getAnionsCliente(),
						client1.getCategoria());

				break;
			case 3:
				Utilidad.limpiarPantalla();
				
				break;

			default:
				break;
			}
		} while (opcion != 3);
	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub
		cliSer.setListaCliente(archivoServicio.subirDatos(FileName));
	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		archivoServicio.exportar(FileName, cliSer.getListaCliente());
				
	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub
		Utilidad.limpiarPantalla();
		System.out.println("Cesión finalizada ");
		
	
	}

// 

// 
	
	
}
