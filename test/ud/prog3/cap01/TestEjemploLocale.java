package ud.prog3.cap01;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.junit.Before;

public class TestEjemploLocale {
	private EjemploLocale ejl_;
	
	@Before
	public void setUp() {
		ejl_ = new EjemploLocale();
	}
	
	@Test
	public void testMuestraLocale() {
		// Coger el locale por defecto
		Locale l = Locale.getDefault();
		System.out.println( "   Idioma, Pais, Variante, Nombre" );
		System.out.println();
		System.out.println("Locale por defecto: ");
		ejl_.muestraLocale( l );
		//fail("Not yet implemented");
	}

}
