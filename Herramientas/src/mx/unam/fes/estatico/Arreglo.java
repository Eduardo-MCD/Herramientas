package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndiceFueraException;

public class  Arreglo <E>{
		private int indice;
		private int indiceUltimo;
		private final Object[] arreglo;
		private int variableRecuperada;
		public Arreglo(int longitud) {
			arreglo=new Object[longitud];
		}
		
		/**
		 * Metodo que inserta un valor E
		 * @param elemento
		 * @throws IndiceFueraException
		 */
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
		
		public void imprimir() {
			for(int i=0;i<arreglo.length;i++) {
				System.out.print(arreglo[i]+ ",");
			}
			System.out.print("");
		}
		
		public void insertarPosicion(E elemento, int posicion) throws IndiceFueraException{
			if(posicion >= 0 && posicion < arreglo.length) {
				arreglo[posicion]=elemento;
				this.indiceUltimo= posicion;
			}else {
				throw new IndiceFueraException("indice fuera del arreglo");
			
			}
		}
		
		public E recuperarPosicion(int posicion) throws IndiceFueraException {
			if(posicion >= 0 && posicion < arreglo.length) {
				
				return(E) arreglo[posicion];
			}else {
				throw new IndiceFueraException("Indice fuera del arreglo");
				
			}
			
		}
		
		public E recuperar() {
			
			return (E) arreglo[indiceUltimo];
		}
		
		public void limpiar() {
			for(int i=0;i<arreglo.length;i++) {
				arreglo[i] = null;
			}
			
			this.indice=0;
		}
		
		public void suprimir(int posicion) {
			
			if(posicion<arreglo.length) {
				arreglo[posicion]= null;
			}
			
		}
		
		public int localizar(E elemento) {
			int posicion = -1;
			
			for(int i=0;i<arreglo.length;i++) {
				
				if(arreglo[i] != null&&arreglo[i].equals(elemento)==true ) {
					posicion = i;
					
					
					break;
				}
			}
			
			
			return posicion;
			
		}
		
		public E siguiente(int indice) {
			if(indice >=0 &&(indice +1)<arreglo.length) {
				
				
				return (E) arreglo[indice+1];
			}return null;
			
		}
		
		public E anterior(int indice) {
			if(indice> 0 && indice <arreglo.length) {
				
				
				return (E) arreglo[indice-1];
			}return null;
			
		}

		public int getIndice() {
			return indice;
		}

		public void setIndice(int indice) {
			this.indice = indice;
		}
		
		public int getLongitud() {
			return arreglo.length;
		}
		
		
		
		
	}
	

