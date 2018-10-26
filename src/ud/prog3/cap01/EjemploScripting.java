package ud.prog3.cap01;

import java.util.List;

import javax.script.*;

public class EjemploScripting {
	public static void main(String[] args) throws Exception {
		// Crea un script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// Crea un interprete JavaScript
		ScriptEngine engine = factory.getEngineByName( "JavaScript" );
		// Evalua codigo JavaScript
		engine.eval( "print('Hello, World')" );
		// Evalia codigo JavaScript incorrecto
		try {
			engine.eval( "print(Hello, World')" );
		} catch (ScriptException e) {
			System.out.println( "Error de ejecucion de script: " + e.getMessage() );
		}
		// Lista lenguajes disponibles:
		for (ScriptEngineFactory fact : factory.getEngineFactories()) {
		    System.out.println("ScriptEngineFactory Info");
		    String engName = fact.getEngineName();
		    String engVersion = fact.getEngineVersion();
		    String langName = fact.getLanguageName();
		    String langVersion = fact.getLanguageVersion();
		    System.out.printf("\tScript Engine: %s (%s)\n", 
		        engName, engVersion);
		    List<String> engNames = fact.getNames();
		    for(String name: engNames) {
		      System.out.printf("\tEngine Alias: %s\n", name);
		    }
		    System.out.printf("\tLanguage: %s (%s)\n", 
		        langName, langVersion);
		  }  		
	}
}