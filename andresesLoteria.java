package ANDRESESLOTERIA;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class andresesLoteria {

		public static void main(String[] args) {
			Scanner sc = new Scanner (System.in);
			int opcion = 0;
			boolean boSalir = false;

	

			//Guardar decimos comprados
			ArrayList decimosComprados = new ArrayList<>();

			do {

				while(opcion > 5 | opcion < 1){
					System.out.println("");
					System.out.println("======================================");
					System.out.println("               LOTERIA");
					System.out.println("======================================");
					System.out.println("Seleccione una Opcion:");
					System.out.println("1. COMPRAR DECIMOS");
					System.out.println("2. VER BOLETOS COMPRADOS");
					System.out.println("3. JUGAR ! - VER RESULTADOS DEL SORTEO");
					System.out.println("4. Salir");
					System.out.println("=======================================");
					System.out.println("");
					opcion = sc.nextInt();

				}

				switch(opcion) {

				case 1:
					decimosComprados = pedirDecimo();
					break;

				case 2:
					mostrarDecimos(decimosComprados);
					break;

				case 3:
					sorteo(decimosComprados);
					break;

				case 4:
					boSalir=true;
					System.out.println("GRACIAS POR JUGAR !!!");
					break;

				default:
					System.out.println("Opción no valida.");


				}
				
				opcion = 0;

			}while(!boSalir);



		}
		
		public static ArrayList pedirDecimo() {

			Scanner sc = new Scanner (System.in);
			int cantidadDecimos = 0;
			int decimo = 0;
			ArrayList decimosComprados = new ArrayList();

			System.out.println("Cuantos decimos quiere Comprar: ");
			cantidadDecimos = sc.nextInt();
			for(int i = 0;i<cantidadDecimos; i++) {

				System.out.println("Introduce su " + (i+1) + " º decimo: ");
				decimo = sc.nextInt();

				while(Integer.toString(decimo).length() != 5) {
					System.out.println("");
					System.out.println("Su Decimo no contiene 5 Cifras");
					System.out.println("Vuelva a Introducirlo");
					decimo = sc.nextInt();
				}

				decimosComprados.add(decimo);

			}
			System.out.println("===========================");
			System.out.println("DECIMOS COMPRADOS CON EXITO");
			System.out.println("===========================");

			return decimosComprados;
		}
		
		public static void mostrarDecimos(ArrayList decimosComprados) {

			if(!decimosComprados.isEmpty()) {
				System.out.println("DECIMOS COMPRADOS: " + decimosComprados);

			}else {

				System.out.println("===============================================");
				System.out.println("NO TIENE DECIMOS COMPRADOS, VUELVA A INTENTARLO");
				System.out.println("===============================================");
			}
		}
		
		public static void sorteo(ArrayList decimosComprados) {
			int numero = 0;
			int numeroAleatorio = 0;
			int gordo = 0;
			int auxLista = 0;
			
			int iSesentaMil = 0;
			int iArrayVeinteMil = 0;
			int iArrayCien = 0;
			
			
			int flagGordo = 0;
			int flagSesentaMil = 6;
			int flagVeinteMil = 10;
			int flagCien = 2000;
			
			int salir = 0;
			int reintegro = 0;
			
			String misBoletosPremiadosSesentaMil = "";
			String misBoletosPremiadosVeinteMil = "";
			String misBoletosPremiadosCien = "";
			String misBoletosPremiadosGordo = "";
			String misBoletosPremiadosReintegro = "";
			
			
			int ultimaC = 0;
			int ultimaCGordo = 0;
			int ultimaCList = 0;
			
			int valor = 0;
			int totalL = 0;
			int haTocado = 0;
			
			  // -------------   guardar decimos que valen 60.000
			
			int arraySesentaMil[];
			arraySesentaMil = new int [3];
			
			 // -------------   guardar decimos que valen 20.000
			int arrayVeinteMil[];
			arrayVeinteMil = new int [5];
			
			// -------------   guardar decimos que valen 100 euro
			int arrayCien[];
			arrayCien = new int [1000];
			
		
			ArrayList numerosAleatoriosJugados = new ArrayList();
			

		
			
			do {
					//GENERO UN NUMERO ALEATORIO PARA MAS ADELANTE ENTRAR EN UN IF U OTRO Y ASI SEA ALEATORIO
					numero = random(3,0);
					
					//AQUI HAGO QUE LOS NUMEROS ALEATORIOS QUE SALGAN NO SE REPITAN
					if(auxLista == 1) {
						
						
						do {
							numeroAleatorio = (int)Math.floor(Math.random()*(99999+1));
							numerosAleatoriosJugados.add(numeroAleatorio);
							
							
						}while(numerosAleatoriosJugados.contains(numeroAleatorio) == false);
						 
					}
					
					numeroAleatorio = (int)Math.floor(Math.random()*(99999+1));
					numerosAleatoriosJugados.add(numeroAleatorio);
					
					auxLista = 1;
					
					
					
					
					if(numero == 0 ) {
						if(flagGordo == 0) {
							gordo = numeroAleatorio;
							flagGordo++;
							salir++;
							
							for(int j=0;j<decimosComprados.size();j++){
								
								   if(gordo == (int)decimosComprados.get(j) ) {
									   misBoletosPremiadosGordo += " " + gordo;
									   haTocado = 1;
								   }
								}
							
						}
					
						
					}else if(numero == 1) {
						if(flagSesentaMil > 3) {
							arraySesentaMil[iSesentaMil] = numeroAleatorio;
							iSesentaMil++;	
							flagSesentaMil--;
							salir++;
						}
						
						
					}else if(numero == 2) {
						if(flagVeinteMil > 5) {
							arrayVeinteMil[iArrayVeinteMil] = numeroAleatorio;
							iArrayVeinteMil++;
							flagVeinteMil--;
							salir++;
						}
						
						
						
					}else if(numero == 3) {
						if(flagCien > 1000) {
							arrayCien[iArrayCien] = numeroAleatorio;
							iArrayCien++;	
							flagCien--;
							salir++;
						}
						
					}
					
					if(flagGordo == 1) {
						ultimaC = numeroAleatorio % 10;
						ultimaCGordo = gordo % 10;
						
						if(ultimaC == ultimaCGordo) {
							reintegro = ultimaCGordo;
							
							
							
							
						}
						ultimaC = 0;
						ultimaCGordo = 0;
						
					}
					
					
					
			}while(salir < 1009);
			
			
			
			System.out.println("");
			System.out.println("==================================================");
			System.out.println("               RESULTADOS DEL SORTEO");
			System.out.println("==================================================");
			System.out.println("");
			System.out.println("EL GORDO ES: " + gordo);
			System.out.println("");
			
			
			
			
			System.out.print("- PREMIOS DE 60.000 $ : ");
			
			for(int i = 0;i<arraySesentaMil.length;i++) {
				
				System.out.print(arraySesentaMil[i] + " ");
				
				//AQUI GUARDO EN VALOR, EL NUMERO QUE HAY EN ARRAYSESENTAMIL[I], DESPUES COMPARO PARA VER SI SON IGUALES
				//CON MI LISTA, ESTO LO HAGO EN EL RESTO DE PREMIOS
				valor = arraySesentaMil[i];
				
				for(int j=0;j<decimosComprados.size();j++){
					
					   if(valor == (int)decimosComprados.get(j) ) {
						   misBoletosPremiadosSesentaMil += " " + arraySesentaMil[i];
						   haTocado = 1;
					   }
					}
				
			}
			
			
			
			System.out.println("");
		
			System.out.print("- PREMIOS DE 20.000 $ : ");
			
			for(int i = 0;i<arrayVeinteMil.length;i++) {
				
				System.out.print(arrayVeinteMil[i] + " ");
			
				valor = arrayVeinteMil[i];
				
				for(int j=0;j<decimosComprados.size();j++){
					
					   if(valor == (int)decimosComprados.get(j) ) {
						   misBoletosPremiadosVeinteMil += " " + arrayVeinteMil[i];
						   haTocado = 1;
					   }
					}
				
				
			}
			
			
			
			
			System.out.println("");
			System.out.print("- PREMIOS DE 100 $ : ");
		
			for(int i = 0;i<arrayCien.length;i++) {
				
				System.out.print(arrayCien[i] + " ");
				 
				valor = arrayCien[i];
				
				
				for(int j=0;j<decimosComprados.size();j++){
					
					   if(valor == (int)decimosComprados.get(j) ) {
						   misBoletosPremiadosCien += " " + arrayCien[i];
						   haTocado = 1;
					   }
					}
			
				
			}
			
			//AQUI CALCULO DE LOS DECIMOS COMPRADOS CUAL DE ELLOS TIENE EL REINTEGRO
			for(int j=0;j<decimosComprados.size();j++){
				
				ultimaCList =  (int)decimosComprados.get(j);
				
				
				totalL = ultimaCList % 10;
				
					if(totalL == reintegro) {
						misBoletosPremiadosReintegro = " " + ultimaCList;
						haTocado = 1;	
					}
				
				   
			}
			
			
	
			
			System.out.println(""); 
			
			System.out.print("- El REINTEGRO ES : ");
			System.out.print(reintegro);
			System.out.println("");
			System.out.println("");
			
			if(haTocado == 1){
				System.out.println("");
				System.out.println("=======================================");
				System.out.println("- SUS BOLETOS COMPRADOS PREMIADOS SON: ");
				System.out.println("=======================================");
				System.out.println("BOLETOS GORDO 3M $ -- " + misBoletosPremiadosGordo);
				System.out.println("BOLETOS 60.000 $ -- " + misBoletosPremiadosSesentaMil);
				System.out.println("BOLETOS 20.000 $ -- " + misBoletosPremiadosVeinteMil);
				System.out.println("BOLETOS 100 $ -- " + misBoletosPremiadosCien);
				System.out.println("BOLETOS 20 $ PREMIADOS CON EL REINTEGRO " + reintegro + " : " + misBoletosPremiadosReintegro);
				
				
			}else {
				System.out.println("");
				System.out.println("");
				System.out.println("=====================================");
				System.out.println("LO SIENTO, NO TIENE BOLETOS PREMIADOS");
				System.out.println("=====================================");
				System.out.println("");
			}
		
			
			
			
		}
		
		public static int random(int limite1, int limite2) {
			int numero = 0;
			
			numero = (int)Math.floor(Math.random()*(Math.max(limite1,limite2) - Math.min(limite1, limite2) + 1)+Math.min(limite1, limite2));
		
			return numero;
			
		}
		
		
}

