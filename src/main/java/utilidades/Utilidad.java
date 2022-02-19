package utilidades;
// clean view
public class Utilidad {
  public static void limpiarPantalla() {
	  for (int i = 0; i < 20; i++) {
		System.out.print("");
	}
  }
  
  public static void separador() {

		System.out.println("----------------------------------------------------------");

	}
  
}


// public static void esperar() {
//	 try {
//		 Thread.sleep(2000);  
//	 }catch(InterrptedException e) {
//		 
//		 
//	 }
// }