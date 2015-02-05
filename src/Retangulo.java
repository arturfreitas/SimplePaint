import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

// Classe de Retangulos
// subclasse de Figura
public class Retangulo extends Figura{

	// Desenha Retangulos
	@Override
	public void Desenha(Graphics2D g2d) {		
		
		// Operacoes nas Coordenadas
		int AcimaX = Math.min(getX1(), getX2());
		int AcimaY = Math.min(getY1(), getY2());
		
		int Largura = Math.abs( getX1() - getX2() );
		int Altura = Math.abs( getY1() - getY2());

		// Desenha ->
		// Com Preenchimento
		if (isFill() == true){
			
			g2d.setPaint(getCor());
		
			g2d.fill( new Rectangle2D.Double(AcimaX, AcimaY, Largura, Altura));
						
		// Sem preenchimento
		}else{
			
			g2d.setPaint(getCor());
			// Espessura do Retangulo
			g2d.setStroke( new BasicStroke(getEspessura()));
			
			g2d.draw( new Rectangle2D.Double(AcimaX, AcimaY, Largura, Altura));
		}		
	}
	
	// Construtor sem Parametros
	public Retangulo(){
		
		this( 0, 0, 0, 0, Color.BLACK, false, 0.0f);		
	}

	// Construtor Com Parametros
	public Retangulo(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){

		super(NewX1, NewX2, NewY1,NewY2, NewColor, NewFill, NewEspessura);	
	}
	
}
