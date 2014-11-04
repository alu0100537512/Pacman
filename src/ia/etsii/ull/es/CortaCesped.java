package ia.etsii.ull.es;

import java.util.ArrayList;

public class CortaCesped {
  private ArrayList<ArrayList<Integer>> visitado = new ArrayList<ArrayList<Integer>>();
  private Sensor sensor = new Sensor();
  private int posX = 0;
  private int posY = 0;
  private Pila pila = new Pila();
  private int sentido = 6;
  private int posXObj = 0;
  private int posYObj = 0;
  
  public void inicializar_visitado(){
		for (int i = 0; i < getSensor().getAlto(); i++){
			getVisitado().add(new ArrayList<Integer>());
			for (int j = 0; j < getSensor().getAncho(); j++){
				getVisitado().get(i).add(0);
			}
		}
		getVisitado().get(0).set(0,1);
		pila.push(new Punto(0,0));
  }
  
  public void movimiento(){
	  if ((getSensor().getsensor_abajo() == 0 || getSensor().getsensor_abajo() == 1) && getVisitado().get(getPosY() + 1).get(getPosX()) == 0){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosY(getPosY() + 1);
		  setSentido(6);
	  }
	  else if ((getSensor().getsensor_derecha() == 0 || getSensor().getsensor_derecha() == 1) && getVisitado().get(getPosY()).get(getPosX() + 1) == 0){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosX(getPosX() + 1);
		  setSentido(4);
	  }
	  else if ((getSensor().getsensor_izquierda() == 0 || getSensor().getsensor_izquierda() == 1) && getVisitado().get(getPosY()).get(getPosX() - 1) == 0){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosX(getPosX() - 1);
		  setSentido(5);
	  }
	  else if ((getSensor().getsensor_arriba() == 0 || getSensor().getsensor_arriba() == 1) && getVisitado().get(getPosY() - 1).get(getPosX()) == 0){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosY(getPosY() - 1);
		  setSentido(3);
	  }
	  else {
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  setPosX(getPila().getPila().get(getPila().getPila().size() - 1).getPosX());
		  setPosY(getPila().getPila().get(getPila().getPila().size() - 1).getPosY());
		  getPila().getPila().remove(getPila().getPila().size() - 1);
	  }
  }
  
  public void movCaminoMin() {
	  int mejor[] = new int[4];
	  for (int i = 0; i < 4; i++){
		  mejor[i] = -1;
	  }
	  if ((getSensor().getsensor_abajo() == 0 || getSensor().getsensor_abajo() == 1) && getVisitado().get(getPosY() + 1).get(getPosX()) == 0){
		  int auxX = getPosXObj() - getPosX();
		  int auxY = getPosYObj() - (getPosY() +1);
		  mejor[0] = (int) Math.sqrt(auxX * auxX + auxY* auxY);
	  }
	  if ((getSensor().getsensor_derecha() == 0 || getSensor().getsensor_derecha() == 1) && getVisitado().get(getPosY()).get(getPosX() + 1) == 0){
		  int auxX = getPosXObj() - (getPosX() +1);
		  int auxY = getPosYObj() - getPosY();
		  mejor[1] = (int) Math.sqrt(auxX * auxX + auxY* auxY);
	  }
	  if ((getSensor().getsensor_izquierda() == 0 || getSensor().getsensor_izquierda() == 1) && getVisitado().get(getPosY()).get(getPosX() - 1) == 0){
		  int auxX = getPosXObj() - (getPosX()-1);
		  int auxY = getPosYObj() - getPosY();
		  mejor[2] = (int) Math.sqrt(auxX * auxX + auxY* auxY);
	  }
	  if ((getSensor().getsensor_arriba() == 0 || getSensor().getsensor_arriba() == 1) && getVisitado().get(getPosY() - 1).get(getPosX()) == 0){
		  int auxX = getPosXObj() - getPosX();
		  int auxY = getPosYObj() - (getPosY() -1);
		  mejor[3] = (int) Math.sqrt(auxX * auxX + auxY * auxY);
	  }
	  int valormenor = 9999989;
	  int posmenor = -1;
	  System.out.println("Aqui empieza el for");
	  for(int i = 0; i < 4; i++){
		  System.out.println(mejor[i]);
		  if ((mejor[i] <= valormenor) && mejor[i] >= 0){
			  valormenor = mejor[i];
			  posmenor = i;
		  }
	  }
	  System.out.println("saliendo del for " + posmenor + " " + valormenor );
	  if (posmenor == 0){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosY(getPosY() + 1);
		  setSentido(6);
	  }
	  else if (posmenor == 1){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosX(getPosX() + 1);
		  setSentido(4);
	  }
	  else if (posmenor == 2){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosX(getPosX() - 1);
		  setSentido(5);
	  }
	  else if (posmenor == 3){
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  getPila().getPila().add(new Punto(getPosX(), getPosY()));
		  setPosY(getPosY() - 1);
		  setSentido(3);
	  }
	  else {
		  getVisitado().get(getPosY()).set(getPosX(), 1);
		  setPosX(getPila().getPila().get(getPila().getPila().size() - 1).getPosX());
		  setPosY(getPila().getPila().get(getPila().getPila().size() - 1).getPosY());
		  getPila().getPila().remove(getPila().getPila().size() - 1);
	  }
  }
    
  public ArrayList<ArrayList<Integer>> getVisitado() {
	  return visitado;
  }

  public int getSentido() {
	  return sentido;
  }

  public void setSentido(int sentido) {
	  this.sentido = sentido;
  }

  public void setVisitado(ArrayList<ArrayList<Integer>> visitado) {
	  this.visitado = visitado;
  }

  public Sensor getSensor() {
    return sensor;
  }
  
  public void setSensor(Sensor sensor) {
    this.sensor = sensor;
  }

  public int getPosX() {
	  return posX;
  }

  public void setPosX(int posX) {
	  getSensor().setPosx(posX);
	  this.posX = posX;
  }

  public int getPosY() {
	  return posY;
  }

  public void setPosY(int posY) {
	  getSensor().setPosy(posY);
	  this.posY = posY;
  }

  public Pila getPila() {
	  return pila;
  }

  public void setPila(Pila pila) {
	  this.pila = pila;
  }

  public int getPosXObj() {
    return posXObj;
  }

  public void setPosXObj(int posXObj) {
    this.posXObj = posXObj;
  }

  public int getPosYObj() {
    return posYObj;
  }

  public void setPosYObj(int posYObj) {
    this.posYObj = posYObj;
  } 
}
