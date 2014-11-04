package ia.etsii.ull.es;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class Tablero extends JComponent{
  private int ancho = 10;
  private int alto = 10;
  private final JScrollPane jScrollPane;
  private Timer timer = new Timer(300, new TimerListener());
  private CortaCesped cortaCesped = new CortaCesped();
  private ArrayList<ArrayList<Integer>> tabler = new ArrayList<ArrayList<Integer>>();
  private Entorno panelImagenes = new Entorno();
  private Controles controles = new Controles();
  private int selecX = 0;
  private int selecY = 0;
  private float starttime = 0;
  static final long NANOTIME = 1000000000;
  
  public Tablero(JScrollPane scroll) {
  	this.jScrollPane = scroll;
  	getControles().getAleatorio().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        crearAleatorio();
        setCortaCesped(new CortaCesped());
        getCortaCesped().getSensor().setTabler(getTabler());
    	  getCortaCesped().getSensor().inicializar();
        getCortaCesped().inicializar_visitado();
      }
  	});   
  	getControles().getIniciar().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        empezar();  	
      }
  	});   
  	addMouseListener(new MouseListener() {           // Añadimos los eventos del ratón, modificnado al función clicked para saber la
      public void mouseClicked(MouseEvent arg0) {    // posición del raton cuando se realiza un click. Dividimos su posición por el tamaño 
        if (!getControles().getDestino().isSelected()) {
          setSelecX(arg0.getX() / 55);                 // de una celda para saber la posición real en la matriz que queremos modificar
          setSelecY(arg0.getY() / 55);
          modificarTablero(getSelecX(), getSelecY());
        }
        else {
          getPanelImagenes().setSelectX(arg0.getX() / 55);
          getPanelImagenes().setSelectY(arg0.getY() / 55);
          getCortaCesped().setPosXObj(arg0.getX() / 55);
          getCortaCesped().setPosYObj(arg0.getY() / 55);
        }
      }
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) { }
    });
  }
  
  public void crearTablero() {
	  System.out.println(getAncho() + " " + getAlto());
	  for(int i = 0; i < getAlto(); i++) {
	    getTabler().add(new ArrayList<Integer>());
	    for (int j = 0; j < getAncho(); j++) {
	      getTabler().get(i).add(1);
	    }
	  }
	  getTabler().get(0).set(0, 3);
	  getPanelImagenes().setTabler(getTabler());
  	getPanelImagenes().setTamanoM(getAlto());             
  	getPanelImagenes().setTamanoN(getAncho());
  	setPreferredSize(new Dimension(getAncho() * 55 + 5, getAlto() * 55 + 5));
  	getCortaCesped().getSensor().setTabler(getTabler());
  	getCortaCesped().getSensor().inicializar();
  	getCortaCesped().inicializar_visitado();
  }
  
  public void inicializar() {
	  for(int i = 0; i < getAlto(); i++) {
	    for (int j = 0; j < getAncho(); j++) {
		    getTabler().get(i).set(j, 1);
	    }
	  }
  }
  
  public void mostrar() {	
	  for(int i = 0; i < getAlto(); i++) {
		  for (int j = 0; j < getAncho(); j++) {
			  System.out.print(getTabler().get(i).get(j));
		  }
		  System.out.println();
	  }
  }
  // Método para modificar un valor de la matriz y volver a repintar la interfaz
  public void modificarTablero(int posX, int posY) {
    getTabler().get(posY).set(posX, getControles().opcionSelec());   //En esta linea modificamos la matriz y el número nuevo a introducir lo obtenemos de
    getPanelImagenes().setTabler(getTabler());                       // el método opcionSelec() (ver la clase Controles para ver el método)
    getCortaCesped().getSensor().setTabler(getTabler());
    repaint();         //Repintamos
  }
  
  public void crearAleatorio () {
	inicializar();
  	double porcentaje = getControles().getPorcentaje().getValue();
  	porcentaje = (porcentaje / 100) * (getAncho() * getAlto()); 
  	Random r = new Random();
  	for (int i = 0; i < porcentaje; i++) {
  	  int posX = r.nextInt(getAncho());
  	  int posY = r.nextInt(getAlto());
  	  getTabler().get(posY).set(posX, 2);
  	}
  	getTabler().get(0).set(0, 3);
  	getCortaCesped().getSensor().setTabler(getTabler());
  	repaint();
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    getPanelImagenes().paintComponent(g);             // Creamos método paintComponent donde pintaremos el panel ya creado en la clase Entorno
    jScrollPane.repaint();
  }
  
  private class TimerListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	  if (!getControles().getDestino().isSelected()) {
	    if (!getCortaCesped().getPila().getPila().isEmpty()) {
		  getTabler().get(getCortaCesped().getPosY()).set(getCortaCesped().getPosX(), 0);
		  getCortaCesped().movimiento();
		  getTabler().get(getCortaCesped().getPosY()).set(getCortaCesped().getPosX(), getCortaCesped().getSentido());
		  
	    }
	    else {
	    	double estimatetime = System.nanoTime() - starttime;
	    	double tiempo_ejecucion = estimatetime/NANOTIME;
	    	System.out.println("Tiempo d eejecucion-> " + tiempo_ejecucion);
	    	repaint();
			  timer.stop();
	    	
	    }
	   }
	else {
		if (getCortaCesped().getPosX() != getCortaCesped().getPosXObj() || getCortaCesped().getPosY() != getCortaCesped().getPosYObj()) {
			  getTabler().get(getCortaCesped().getPosY()).set(getCortaCesped().getPosX(), 0);
			  getCortaCesped().movCaminoMin();
			  getTabler().get(getCortaCesped().getPosY()).set(getCortaCesped().getPosX(), getCortaCesped().getSentido());
			  
		    }
		    else {
		    	double estimatetime = System.nanoTime() - starttime;
		    	double tiempo_ejecucion = estimatetime/NANOTIME;
		    	System.out.println("Tiempo d eejecucion-> " + tiempo_ejecucion);
		    	repaint();
				  timer.stop();
				 
		    }
		   }
	}
  }
  
  public void empezar() {
	starttime= System.nanoTime();
	timer.start();
  }
  
  public int getposition(int x, int y){
	  return 1;
  }

  public ArrayList<ArrayList<Integer>> getTabler() {
    return tabler;
  }

  public void setTabler(ArrayList<ArrayList<Integer>> tabler) {
    this.tabler = tabler;
  }
  
  public Entorno getPanelImagenes() {
  	return panelImagenes;
  }
  
  public void setPanelImagenes(Entorno panelImagenes) {
  	this.panelImagenes = panelImagenes;
  }

  public int getSelecX() {
    return selecX;
  }

  public void setSelecX(int selecX) {
    this.selecX = selecX;
  }

  public int getSelecY() {
    return selecY;
  }

  public void setSelecY(int selecY) {
    this.selecY = selecY;
  }

  public Controles getControles() {
    return controles;
  }

  public void setControles(Controles controles) {
    this.controles = controles;
  }

  public CortaCesped getCortaCesped() {
    return cortaCesped;
  }

  public void setCortaCesped(CortaCesped cortaCesped) {
    this.cortaCesped = cortaCesped;
  }

  public int getAncho() {
	return ancho;
  }

  public void setAncho(int ancho) {
	this.ancho = ancho;
  }

  public int getAlto() {
	return alto;
  }

  public void setAlto(int alto) {
	this.alto = alto;
  }
}
