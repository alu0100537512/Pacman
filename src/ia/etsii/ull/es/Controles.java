package ia.etsii.ull.es;

import java.awt.FlowLayout;

import javax.swing.*;

public class Controles extends JPanel {
  private JButton aleatorio = new JButton("Tablero aleatorio");
  private JButton iniciar = new JButton("Iniciar");
  private JRadioButton cesCorto = new JRadioButton("Cesped corto");
  private JRadioButton cesLargo = new JRadioButton("Cesped largo");
  private JRadioButton obstaculo = new JRadioButton("Obstculo");
  private JRadioButton cortaCesped = new JRadioButton("CortaCesped");
  private ButtonGroup opciones = new ButtonGroup();   // Creo un grupo de botones para no permitir seleccionar más de un RadioButton a la vez
  private JSlider porcentaje = new JSlider();
  private JLabel SelecDestino = new JLabel("Seleccionar destino");
  private JCheckBox destino = new JCheckBox();
  
  public Controles() {
	  getPorcentaje().setMaximum(100);
	  getPorcentaje().setPaintLabels(true);
	  getPorcentaje().setPaintTicks(true);
	  getPorcentaje().setMajorTickSpacing(25);
	  getPorcentaje().setMinorTickSpacing(5);
	  getPorcentaje().setPaintTrack(false);
	  getPorcentaje().setValue(0);
	  setLayout(new FlowLayout());
	  add(getIniciar());
	  add(getAleatorio());
	  add(getPorcentaje());
	  getOpciones().add(getCesCorto());
	  getOpciones().add(getCesLargo());
	  getOpciones().add(getObstaculo());
	  getOpciones().add(getCortaCesped());
	  add(getCesCorto());
	  add(getCesLargo());
    add(getObstaculo());
    add(getCortaCesped());
    add(getSelecDestino());
    add(getDestino());
  }
  
  // Método que nos indica que opción hemos elegido del grupo de radioButtons
  public int opcionSelec() {
    int opcion = 0;
    if (getCesCorto().isSelected())
      opcion = 0;
    else if (getCesLargo().isSelected())
      opcion = 1;
    else if (getObstaculo().isSelected())
      opcion = 2;
    else if (getCortaCesped().isSelected())
      opcion = 3;
    return opcion;
  }
  
  
  public JButton getIniciar() {
	return iniciar;
}

public void setIniciar(JButton iniciar) {
	this.iniciar = iniciar;
}

public JButton getAleatorio() {
    return aleatorio;
  }
  
  public void setAleatorio(JButton aleatorio) {
    this.aleatorio = aleatorio;
  }
  
  public JRadioButton getCesCorto() {
    return cesCorto;
  }
  
  public void setCesCorto(JRadioButton cesCorto) {
    this.cesCorto = cesCorto;
  }
  
  public JRadioButton getCesLargo() {
    return cesLargo;
  }
  
  public void setCesLargo(JRadioButton cesLargo) {
    this.cesLargo = cesLargo;
  }
  
  public JRadioButton getObstaculo() {
    return obstaculo;
  }
  
  public void setObstaculo(JRadioButton obstaculo) {
    this.obstaculo = obstaculo;
  }
  
  public JRadioButton getCortaCesped() {
    return cortaCesped;
  }
  
  public void setCortaCesped(JRadioButton cortaCesped) {
    this.cortaCesped = cortaCesped;
  }

  public ButtonGroup getOpciones() {
     return opciones;
   }

  public void setOpciones(ButtonGroup opciones) {
    this.opciones = opciones;
  }

  public JSlider getPorcentaje() {
	  return porcentaje;
  }

  public void setPorcentaje(JSlider porcentaje) {
	  this.porcentaje = porcentaje;
  }

  public JCheckBox getDestino() {
    return destino;
  }

  public void setDestino(JCheckBox destino) {
    this.destino = destino;
  }

  public JLabel getSelecDestino() {
    return SelecDestino;
  }

  public void setSelecDestino(JLabel selecDestino) {
    SelecDestino = selecDestino;
  }
}
