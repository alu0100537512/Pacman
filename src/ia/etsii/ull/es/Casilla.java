package ia.etsii.ull.es;

public class Casilla {
  private Casilla arriba;
  private Casilla abajo;
  private Casilla izquierda;
  private Casilla derecha;
  private boolean visitada = false;
  private boolean visto = false;
  private boolean obstaculo = false;
  private int posX;
  private int posY;
  
public Casilla getArriba() {
	return arriba;
}
public void setArriba(Casilla arriba) {
	this.arriba = arriba;
}
public Casilla getAbajo() {
	return abajo;
}
public void setAbajo(Casilla abajo) {
	this.abajo = abajo;
}
public Casilla getIzquierda() {
	return izquierda;
}
public void setIzquierda(Casilla izquierda) {
	this.izquierda = izquierda;
}
public Casilla getDerecha() {
	return derecha;
}
public void setDerecha(Casilla derecha) {
	this.derecha = derecha;
}
public boolean isVisitada() {
	return visitada;
}
public void setVisitada(boolean visitada) {
	this.visitada = visitada;
}
public boolean isVisto() {
	return visto;
}
public void setVisto(boolean visto) {
	this.visto = visto;
}
public boolean isObstaculo() {
	return obstaculo;
}
public void setObstaculo(boolean obstaculo) {
	this.obstaculo = obstaculo;
}
public int getPosX() {
	return posX;
}
public void setPosX(int posX) {
	this.posX = posX;
}
public int getPosY() {
	return posY;
}
public void setPosY(int posY) {
	this.posY = posY;
}
  
  
}
