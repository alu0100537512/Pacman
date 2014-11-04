package ia.etsii.ull.es;

import java.util.ArrayList;

public class Sensor {
	private int posx = 0;
	private int posy = 0;
	private int alto = 0;
	private int ancho = 0;
	private ArrayList<ArrayList<Integer>> tabler = new ArrayList<ArrayList<Integer>>();;
	
	public Sensor(){
	  
	}
	
	public void inicializar() {
		alto = getTabler().size();
		//System.out.println(getTabler().size() + " Tamaño");
		ancho = getTabler().get(0).size();
	}
	
	public int getsensor_position(){
		//posicion actual del cortacesped
	  return tabler.get(getPosy()).get(getPosx());
	}
	
	public int getsensor_arriba(){
	  if (posy >= 1) {
	    return tabler.get(getPosy() - 1).get(getPosx());
	  } else {
		return -1;
	  }
	}
	
	public int getsensor_abajo(){
	  if (posy < getAlto() - 1) {
		  //System.out.println("bien");
		return tabler.get(getPosy() + 1).get(getPosx());
	  } 
	  else {
		  //System.out.println("mal");
		return -1;
	  }
	}
	
	public int getsensor_izquierda(){
	  if (posx >= 1) {
		return tabler.get(getPosy()).get(getPosx() - 1);
	  } else {
		return -1;
	  }
	}
	
	public int getsensor_derecha(){
	  if (posx < getAncho() - 1) {
		return tabler.get(getPosy()).get(getPosx() + 1);
	  } else {
		return -1;
	  }
	}

  public int getPosx() {
    return posx;
  }

  public void setPosx(int posx) {
    this.posx = posx;
  }

  public int getPosy() {
    return posy;
  }

  public void setPosy(int posy) {
    this.posy = posy;
  }

  public ArrayList<ArrayList<Integer>> getTabler() {
    return tabler;
  }

  public void setTabler(ArrayList<ArrayList<Integer>> tabler) {
    this.tabler = tabler;
  }

  public int getAlto() {
    return alto;
  }

  public void setAlto(int alto) {
    this.alto = alto;
  }

  public int getAncho() {
    return ancho;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }
}
