package ud.prog3.cap04;

import java.util.ArrayList;

public class SacaLista {
	public static void sacaLista(ArrayList<String> al, int ind){
		if (ind==al.size()){
			// Nada que hacer (caso base)
			return;
		}
		else { // caso recursivo			
			//System.out.println(al.get(ind)); //1
			sacaLista( al, ind+1 ); //2
			System.out.println(al.get(ind)); //1
		}
	}
	
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		al.add("Lunes");
		al.add("Martes");
		al.add("Miercoles");
		sacaLista(al, 0);
		
	}

}
