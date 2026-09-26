package mx.unam.fes.inicio;

import java.util.Random;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndiceFueraException;

public class Principal_Uno {
	
	public static void main(String[] args) {
		Arreglo<Integer>arrUno=new Arreglo<Integer>(100);
		Arreglo<Integer>arrDos=new Arreglo<Integer>(1000);
		try {
			
			//problema
			
			Random aleatorio = new Random();
			
			int c =0;
			while(arrUno.getLongitud()>arrUno.getIndice()) {
				c =aleatorio.nextInt(100);
				
					  arrUno.insertar(c);	
			}
			
			int mayor=0;
			int segundoMayor =0;
			int a= 0	;	
			int suma=0;
			int promedio=0;
			int numeroRepetido = 0;
		
			for(int i =0;i<arrUno.getLongitud();i++) {
				
				suma= suma + a;
				
				
				
				
				//mayor y segundo mayor
				a=arrUno.recuperarPosicion(i);
				if(a>mayor) {
					segundoMayor= mayor;
					mayor=a;
				} else if(a>segundoMayor && a!= mayor) {
					segundoMayor= a;
				}
				
				
				//repeticiones de numeros
				
					if(arrUno.recuperarPosicion(i).equals(i)) {
						numeroRepetido++;
						System.out.println(arrUno.recuperar() + " = " + numeroRepetido);
						numeroRepetido = 0;
						
					}
				
			
				
			}
			promedio= suma /100;
			System.out.println("hola" +mayor + "segundo " + segundoMayor + "el promedio es " +promedio);
			
				
			
			
			
			
			
			arrUno.imprimir();
			
			
		} catch (IndiceFueraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
