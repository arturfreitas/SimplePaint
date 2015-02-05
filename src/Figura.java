import java.awt.Color;
import java.awt.Graphics2D;


// Classe abstrata Figura
public abstract class Figura extends Object{

	// Coordenadas (x, y)
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	// Cor da Figura
	private Color Cor;
	
	// Espessura da Figura
	private float espessura;
	
	// Boleano para preenchimento
	private boolean Fill;
	
	// Construtor Default
	public Figura(){
		
		 this( 0, 0, 0, 0, Color.BLACK, false, 0.0f);
		 
	}
	
	// Construtor com parametros
	public Figura(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){
		
		// Coordenadas
		setX1(NewX1);
		setX2(NewX2);
		setY1(NewY1);
		setY2(NewY2);
		
		// Cor
		setCor(NewColor);	
		
		// Preenchimento
		setFill(NewFill);
		
		// Tamanho da Espessura
		setEspessura(NewEspessura);
	}
	
	// Metodo de Desenhar
	public abstract void Desenha(Graphics2D g2d);
	
	// Getters
	public Color getCor() {	return Cor;	}
	
	public int getX1() {	return x1;	}
	public int getX2() {	return x2;	}

	public int getY1() {	return y1;	}
	public int getY2() {	return y2;	}
	
	public boolean isFill() {	return Fill; }
	
	public float getEspessura() {	return espessura;	}
	
	
	// Setters
	public void setCor(Color cor) {	Cor = cor;	}
	
	public void setX1(int x1) {	this.x1 = ( x1 >= 0 ? x1 : 0 );	}
	public void setX2(int x2) {	this.x2 = ( x2 >= 0 ? x2 : 0 );	}
	
	public void setY1(int y1) {	this.y1 = ( y1 >= 0 ? y1 : 0 );	}		
	public void setY2(int y2) {	this.y2 = ( y2 >= 0 ? y2 : 0 );	}

	public void setFill(boolean fill) {	Fill = fill; }

	public void setEspessura(float espessura) {	this.espessura = espessura;	}

}
