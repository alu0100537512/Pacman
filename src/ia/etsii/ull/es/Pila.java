package ia.etsii.ull.es;

import java.util.ArrayList;

public class Pila {
	private ArrayList<Punto> pila = new ArrayList<Punto>();
	public void push(Punto punto){
		getPila().add(punto);
	}
	public Punto pop(){
		Punto aux = getPila().get(getPila().size() - 1);
		getPila().remove(getPila().size() - 1);
		return aux;
	}
	public ArrayList<Punto> getPila() {
		return pila;
	}
	public void setPila(ArrayList<Punto> pila) {
		this.pila = pila;
	}
	
}
