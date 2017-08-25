package ud.prog3.cap04;

import java.util.Random;

public class AquilesYLaTortuga {
	
	public static final double VEL_AQUILES = 10;   // metros / sg
	public static final double VEL_TORTUGA = 0.05; // m/sg (0.05m/sg = 1 metro cada 20 segs) 
	
	public static final double INICIO_AQUILES = 0;    // Aquiles empieza en el metro 0
	public static final double INICIO_TORTUGA = 1000; // La tortuga tiene 1 km de ventaja
	
	/** Devuelve la posicion de Aquiles en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posicion de Aquiles (en m)
	 */
	public static double dondeEstaAquiles( double t ) {
		return INICIO_AQUILES + VEL_AQUILES * t;
	}

	/** Devuelve la posicion de la tortuga en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posicion de la tortuga (en m)
	 */
	public static double dondeEstaLaTortuga( double t ) {
		return INICIO_TORTUGA + VEL_TORTUGA * t;
	}
	
	// Algoritmo recursivo
	// tIni <= tFin
	// En tIni aquiles no ha llegado
	// En tFin aquiles se ha pasado
	public static double cuandoSeEncuentran( double tIni, double tFin ) {
		numLlams++; // Auxiliar para contar el numero de llamadas
		if (numLlams< 1000) System.out.println( numLlams + " - params " + tIni + " y " + tFin );
		//if (Math.abs(tFin-tIni)<0.0000000000001) {
		if (tFin == tIni) {
			return tIni;
		} else {
			double tMedio = (tIni+tFin)/2;
			double sitioAquiles = dondeEstaAquiles(tMedio);
			double sitioTortuga = dondeEstaLaTortuga(tMedio);
			if (sitioAquiles > sitioTortuga) { // Aquiles ha pasado
				return cuandoSeEncuentran(tIni, tMedio );  // Aquiles ya ha pasado a la tortuga
			} else {  // Aquiles no ha pasado
				return cuandoSeEncuentran(tMedio, tFin);  // Aquiles no ha llegado a la tortuga
			}
		}
	}
	
	private static int numLlams = 0;
	public static void main(String[] args) {
		double t = 100;
		System.out.println( "Ejemplo. Tiempo = " + t + " segundos" );
		System.out.println( " Aquiles esta en " + dondeEstaAquiles(t));
		System.out.println( " La tortuga esta en " + dondeEstaLaTortuga(t));
		System.out.println( "Solucion:" );
		
		try {
			double tSol = cuandoSeEncuentran( 0, 100000 );
			//double tSol = cuandoSeEncuentran( 0, 100 );
			System.out.println( "Tiempo de encuentro = " + tSol );
			System.out.println( "  Distancia de encuentro = " + dondeEstaAquiles(tSol));
		} catch (StackOverflowError e) {
			System.out.println( "Stack overflow!! " + numLlams );
		}
		
	}
	
}
	
