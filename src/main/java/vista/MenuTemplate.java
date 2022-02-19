package vista;

import java.util.Scanner;
import utilidades.Utilidad;

//7.- The main should be:
//listarCliente.
// agregarCliente.
//editarCliente.
//importarDatos.
// exportarDatos.
// terminarPrograma.

//8.- Override methods 
//- listarClientes, muestra lista de clientes agregados, ya sea por importación o
//agregando a mano.
//- agregarCliente, solicita ingreso de datos y llena objeto de tipo Cliente.
//- editarCliente, permite la edición de algún cliente en caso de requerirlo o
//cambiar el estado del cliente.
//- cargarDatos, ejecuta la carga de datos del archivo “DBClientes.csv”.
//- exportarDatos, llama a método para exportar clientes en formato “.txt” o
//“.csv”.
//terminarPrograma, el cual finaliza la ejecución del sistema.


public abstract class MenuTemplate {
	
	private Scanner sc = new Scanner(System.in);
		
	public abstract void listarClientes();
	
	public abstract void agregarClientes();
	
	public abstract void editarClientes();
	
	public abstract void importarDatos();
	
	public abstract void exportarDatos();
	
	public abstract void terminarPrograma();
	
	public final void iniciarMenu() {
		
		int opcion = 0;
		do {
		System.out.println("*****Bienvenido Sistema BonJovi*****");	
		System.out.println("*****Menu Principal*****");
		System.out.println("1.- Listar Clientes");
		System.out.println("2.- Agregar Cliente");
		System.out.println("3.- Editar Cliente");
		System.out.println("4.- Importar Datos");
		System.out.println("5.- Exportar Datos");
		System.out.println("6.- Salir");
		Utilidad.separador();
		
		opcion = sc.nextInt();
		
		switch(opcion) {
		
		case 1:
			
			listarClientes();
			break;
		case 2:
			Utilidad.separador();
			
			agregarClientes();
			break;
		case 3:
			editarClientes();
			break;
		case 4:
			importarDatos();
			break;
		case 5:
		    exportarDatos();
			break;
		case 6:
		 	terminarPrograma();
			
		default: System.out.print("La seleccion no es valida");
		break;
		}
	
		}while (opcion != 6);
		
	} 
}
