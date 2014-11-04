package ia.etsii.ull.es;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Entorno extends JPanel {
  final static int ESCALAR_X = 50;              //Constantes
  final static int ESCALAR_Y = 50;
  final static int SEPARACION_X = 55;
  final static int SEPARACION_Y = 55;
  
  private ImageIcon cespedCorto = new ImageIcon("cesped.jpg");
  private ImageIcon cespedLargo = new ImageIcon("883770.jpg") ;
  private ImageIcon cortaCesped = new ImageIcon("cortacesped-yanko-02.jpg");
  private ImageIcon piedra = new ImageIcon("piedra.jpg");
  private ImageIcon cortaCespedDer = new ImageIcon("cortacesped-yanko-02-derecha.jpg");
  private ImageIcon cortaCespedIzq = new ImageIcon("cortacesped-yanko-02-izquierda.jpg");
  private ImageIcon cortaCespedAbj = new ImageIcon("cortacesped-yanko-02-abajo.jpg");
  private int tamanoN = 0;
  private int tamanoM = 0;
  private int selectX = -1;
  private int selectY = -1;
  private ArrayList<ArrayList<Integer>> tabler = new ArrayList<ArrayList<Integer>>(); // Copia de la matriz de la clase Tablero
  
  public Entorno() {
    //Escale las imágenes a un tamaño más pequeño
    setCespedCorto(new ImageIcon(getCespedCorto().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setCespedLargo(new ImageIcon(getCespedLargo().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setPiedra(new ImageIcon(getPiedra().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setCortaCesped(new ImageIcon(getCortaCesped().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setCortaCespedAbj(new ImageIcon( getCortaCespedAbj().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setCortaCespedDer(new ImageIcon( getCortaCespedDer().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
    setCortaCespedIzq(new ImageIcon( getCortaCespedIzq().getImage().getScaledInstance(ESCALAR_X, ESCALAR_Y, Image.SCALE_DEFAULT)));
  }
  
  public void paintComponent(Graphics g) {
  	super.paintComponent(g);
  	g.setColor(Color.BLACK); 
  	g.fillRect(0, 0, getTamanoN() * 55 + 5, getTamanoM() * 55 + 5); // Pintamos un rectángulo de color negro que ocupe todo el jardín, así
  	int posX = 0;                                                   // no hace falta pintar las lineas que separan cada cuadrado de cesped
  	int posY = 5;
  	// En este bucle pintamos una imagen en la ventana dependiendo del valor númerico de la matriz tabler
  	for (int i = 0; i < getTamanoM(); i++) {
  	  posX = 5;
  	  for (int j = 0; j < getTamanoN(); j++) {
  		if (getSelectX() == j && getSelectY() == i) {
    		g.setColor(Color.RED);
    	  	  g.fillRect(posX - 5, posY - 5, 60, 60);
    	  	  g.setColor(Color.BLACK);	
    	}
    	if (getTabler().get(i).get(j) == 0)
    	  getCespedCorto().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 1)
    	  getCespedLargo().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 2)
    	  getPiedra().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 3)
    	  getCortaCesped().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 4)
      	  getCortaCespedDer().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 5)
      	  getCortaCespedIzq().paintIcon(this, g, posX, posY);
    	else if (getTabler().get(i).get(j) == 6)
      	  getCortaCespedAbj().paintIcon(this, g, posX, posY);
    	posX += SEPARACION_X;		
  	  }
  	  posY += SEPARACION_Y;
  	}
  }

  public ImageIcon getCortaCespedDer() {
	return cortaCespedDer;
}

public void setCortaCespedDer(ImageIcon cortaCespedDer) {
	this.cortaCespedDer = cortaCespedDer;
}

public ImageIcon getCortaCespedIzq() {
	return cortaCespedIzq;
}

public void setCortaCespedIzq(ImageIcon cortaCespedIzq) {
	this.cortaCespedIzq = cortaCespedIzq;
}

public ImageIcon getCortaCespedAbj() {
	return cortaCespedAbj;
}

public void setCortaCespedAbj(ImageIcon cortaCespedAbj) {
	this.cortaCespedAbj = cortaCespedAbj;
}

public ImageIcon getCespedCorto() {
    return cespedCorto;
  }

  public void setCespedCorto(ImageIcon cespedCorto) {
    this.cespedCorto = cespedCorto;
  }

  public ImageIcon getCespedLargo() {
    return cespedLargo;
  }

  public void setCespedLargo(ImageIcon cespedLargo) {
    this.cespedLargo = cespedLargo;
  }

  public ImageIcon getCortaCesped() {
    return cortaCesped;
  }

  public void setCortaCesped(ImageIcon cortaCesped) {
    this.cortaCesped = cortaCesped;
  }

  public ImageIcon getPiedra() {
    return piedra;
  }

  public void setPiedra(ImageIcon piedra) {
    this.piedra = piedra;
  }

  public int getTamanoN() {
    return tamanoN;
  }

  public void setTamanoN(int tamanoN) {
    this.tamanoN = tamanoN;
  }
  
  public int getTamanoM() {
    return tamanoM;
  }

  public void setTamanoM(int tamanoM) {
    this.tamanoM = tamanoM;
  }

  public ArrayList<ArrayList<Integer>> getTabler() {
    return tabler;
  }

  public void setTabler(ArrayList<ArrayList<Integer>> tabler) {
    this.tabler = tabler;
  }

  public int getSelectX() {
	return selectX;
  }

  public void setSelectX(int selectX) {
	this.selectX = selectX;
  }

  public int getSelectY() {
	return selectY;
  }

  public void setSelectY(int selectY) {
	this.selectY = selectY;
  }
}
