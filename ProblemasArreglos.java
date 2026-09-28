package mx.unam.fes.estatico;

import java.util.Random;

import mx.unam.fes.exepciones.IndiceFueraException;

public class ProblemasArreglos <E>{
	
	
	private int indice;
	private int indiceUltimo;
	private final Object[] arreglo;
	private int varRef;
	private int mayor, segundoMayor, prom;
	
	public ProblemasArreglos (int longitud) {
		arreglo=new Object[longitud];
		
		
	}
	
	public void insertar(E elemento) throws IndiceFueraException {
		if(indice< arreglo.length) {
			arreglo[indice] = elemento;
			this.indiceUltimo= indice;
			indice++;
		}else {
			throw new IndiceFueraException("indice fuera del arreglo");
		}
	}
	
	public boolean vacio() {
		
		if(indice<arreglo.length) {
			return false;
		}
		return true;
		
	}
	
	public Integer mayor() {
		mayor = (int) arreglo[0];
		segundoMayor = (int) arreglo[0];
		
		for(int i = 0; i < arreglo.length; i++) {
			
			varRef = (int) arreglo[i];
			if (varRef > mayor) {
				mayor = varRef;
					
				} else if (varRef > segundoMayor && varRef != mayor) {
				segundoMayor = varRef;
				
			}
				
		}
		System.out.println("El numero mayor del Arreglo es: "+mayor + " y el segundo mayor es: " +segundoMayor);
		return mayor;
	}
	
	public void numRepeticiones() {
		
		int [] contador = new int[102];
		
		for (int i=0 ; i<indice ; i++) {
			
			varRef = (int) arreglo[i];
			contador[varRef]++;
			
		}
		for (int i = 0 ; i < contador.length; i++) {
			if (contador[i] > 0) {
				System.out.println(+i+" = " + contador[i]);
			}
			
		}
			
	}
	
	public void promedio() {
		
		for (int i = 0 ; i < arreglo.length;i++) {
			
			prom= prom + (int) arreglo[i];
			
		}
		prom = (prom / arreglo.length);
		
		System.out.println("El promedio es: "+ prom);
	}
	
	public void imprimir() {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
}
