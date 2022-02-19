package servicio;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;


public class ClienteServicioDev implements ClienteServicio {
	
//9.-
//-Crear la clase ClienteServicio en el package servicio con los siguientes requisitos:
//-Crear un atributo llamado List<Cliente> listaClientes en este caso Hashmap).
// Generar un constructor de ClienteServicio que tenga esta listaClientes.
//-Generar el método público sin valor de retornolistarClientes e implementar el
//ciclo más idóneo para recorrer cada uno de los clientes.
//-Generar un public void del método agregarCliente y pasarle los parámetros de
//la clase Cliente. Utiliza este método para guardar clientes en una instancia de cliente.
//-Generar un public void del método editarCliente y pasarle los parámetros de la clase Cliente.
//-Crear un getter de listaCliente y que pueda retornar una listaClientes
	
	private Map<String, Cliente> listaCliente = new HashMap<>();

	private Scanner sc = new Scanner(System.in);


	public ClienteServicioDev(Map<String, Cliente> listaCliente) {
		super();
		this.listaCliente = listaCliente;
	}

	
	
	public Map<String, Cliente> getListaCliente() {
		return listaCliente;
	}


	public void setListaCliente(Map<String, Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public ClienteServicioDev() {

		this.listaCliente = new HashMap<String, Cliente>();
	}
	//		@Override
//		public Cliente buscar(String rut) {
//			// TODO Auto-generated method stub
//				for (Cliente client : listaCliente) {
//					if (client.getRunCliente().equals(rut)) {
//						return client;
//				}
//			}
//			return null;
//		}
	
	
	public void creaCliente(Cliente client) {
		// TODO Auto-generated method stub
    	if(client !=null) {
    		listaCliente.put(client.getRunCliente(), client);
    	}
	}
    //
    public void agregarCliente(Cliente client) {
		// TODO Auto-generated method stub
    	
    	if(listaCliente.containsKey(client.getRunCliente()) == false){
 
    		listaCliente.put(client.getRunCliente(), client);
    	}else {
    		System.out.println("El cliente específicado ya existe, revise el RUN entregado");
    	}
    }

	
    
    public void editarEstado (Cliente client) {
    	if (listaCliente.containsKey(client.getRunCliente())) {
    		Cliente editado= listaCliente.get(client.getRunCliente());

			System.out.println("-----Actualizando el estado del Cliente----");
			System.out.printf("Estado actual del Cliente: %s\n", String.valueOf(editado.getCategoria()));
			System.out.println("1.-Cambio estado del Cliente a Inactivo");
			System.out.println("2.-Cambio estado del Cliente a Activo");
			System.out.println("Ingrese opción: ");
			int opcion = sc.nextInt();
			//reader SET
			if (opcion == 1) {
				editado.setCategoria(CategoriaEnum.INACTIVO);
				listaCliente.replace(editado.getRunCliente(), editado);
				System.out.printf("El estado del cliente %s se ha modificado \n", editado.getNombreCliente());
			} else if (opcion == 2) {
				editado.setCategoria(CategoriaEnum.ACTIVO);
				listaCliente.replace(editado.getRunCliente(), editado);
				System.out.printf("El estado del cliente %s se ha modificado  \n", editado.getNombreCliente());
			} else {
				System.out.println("La opción ingresada no es válida");
			}
    		
    	}
    }


  
	@Override
	public void editarCliente1(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo) {
		// TODO Auto-generated method stub
		
			Cliente client1= listaCliente.get(runCliente);
			System.out.println("Ingrese el RUN del Cliente a editar");
			System.out.printf("\n 1.- Run del Cliente es: %s \n", runCliente);
			System.out.printf("2.- Nombre del Cliente es: %s \n", nombreCliente);
			System.out.printf("3.-  Apellido del Cliente es: %s \n", apellidoCliente);
			System.out.printf("4.- Edad del Cliente son: %s \n\n", aniosCliente);
			System.out.println("Ingrese la opción a editar del cliente:\n");
			 int opcion= sc.nextInt();
		
		
			 switch (opcion){
				 case 1:
				 System.out.println("Ingrese nuevo RUN del Cliente: ");
				 String run = sc.next();
				 System.out.println("---------------------------------------");
				 client1.setRunCliente(run);
				 listaCliente.put(client1.getRunCliente(), client1);
				 listaCliente.remove(runCliente);
				 
				 System.out.println("Los Datos han sido cambiados");
			   
			     break;
				 case 2:
					 System.out.println("Ingrese nuevo Nombre del Cliente: ");
					 String nombre = sc.next();
					 System.out.println("---------------------------------------");
					 client1.setNombreCliente(nombre);
					 listaCliente.put(client1.getRunCliente(), client1); 
					 System.out.println("Los Datos han sido cambiados");
				 
				 break;
				 case 3:
					 System.out.println("Ingrese nuevo Apellido del Cliente: ");
					 String apellido = sc.next();
					 System.out.println("---------------------------------------");
					 client1.setApellidoCliente(apellido);
					 listaCliente.put(client1.getRunCliente(), client1); 
					 System.out.println("Los Datos han sido cambiados");
				 break;
					 
				 case 4:
						System.out.println("4.-Ingrese años correctos que ha sido Cliente:");
						String anios = sc.next() + " anios";
						System.out.println("---------------------------------------");
						client1.setAnionsCliente(anios);
						listaCliente.put(client1.getRunCliente(), client1);
						System.out.println("Datos cambiados con éxito");
				break;
				
				 case 5:
					 System.out.println("salir");
					 Utilidad.limpiarPantalla();

				default:
					System.out.println("La opción ingresada no es válida");
					break;
			  }
			   
	}

	@Override
	public void editarCliente(Cliente client) {
		// TODO Auto-generated method stub
		
	}

	
	}



