package ia.etsii.ull.es;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Principal extends JFrame{

  private Tablero tablero;
  //private Controles controles = new Controles();
    
  public Tablero getTablero() {
	  return tablero;
	}

  public void setTablero(Tablero tablero) {
	this.tablero = tablero;
  }

  public Principal() {
    JScrollPane panel = new JScrollPane();
    setTablero(new Tablero(panel)); 
    panel.setViewportView(getTablero());
    add(panel);                                       
    add(getTablero().getControles(), BorderLayout.SOUTH);
  }
    
  public static void main(String[] args) {
    Principal ventana = new Principal();
    ventana.getTablero().setAncho(Integer.parseInt(args[0]));
    ventana.getTablero().setAlto(Integer.parseInt(args[1]));
    //System.out.println(" Antes de crearTablero");
    ventana.getTablero().crearTablero();
    ventana.setTitle("Cortacesped");
    ventana.setSize(1250, 700);
    ventana.setLocationRelativeTo(null);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    ventana.setVisible(true);
    //ventana.getTablero().mostrar();  
  }
}
