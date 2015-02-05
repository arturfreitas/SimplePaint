import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

// Classe para desenhar no JPanel
public class PaintJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// Lista de Arrays
	private ArrayList<Figura> FormasArrayList = new ArrayList<Figura>();

	// Figura Atual para Desenha
	private Figura FiguraAtual;
	
	// Contador de Figuras
	private int NumeroFiguras;
	
	// Espessura
	private float Espessura;
	
	// Tipo Selecionado
	private String currentType = "Pincel";
	
	//Preenchimento 
	private boolean Filled;
	
	// Cor Atual , inicia com RGB 0,0,0 (Preto)
	private Color currentColor = new Color( 0, 0, 0 );
	
	// Boolean para Estado de Abrir Imagem
	private boolean Aberto;
	
	// Para Carregar Imagem Aberta
	private BufferedImage MinhaImagem;
	
	
	// Setters
	public void setCurrentShapeType( String shape ){	currentType = shape;			} 
	public void setCurrentColor( Color shapeColor ){	currentColor = shapeColor;		}
	public void setNumeroFiguras(int numeroFiguras){	NumeroFiguras = numeroFiguras;	}
	public void setFilled(boolean filled) 		   {	Filled = filled;				}
	public void setEspessura(float espessura)	   {	Espessura = espessura;			}
	public void setAberto(boolean aberto) 	 	   {	Aberto = aberto;				}
	
	
	// Getters
	public int getNumeroFiguras() {	return NumeroFiguras;	}
	public boolean isFilled() 	  {	return Filled;			}
	public float getEspessura()   {	return Espessura;		}
	public boolean isAberto() 	  {	return Aberto;			}
	
	
	// Construtor da classe
	public PaintJPanel(){

		// Zera Contador
		setNumeroFiguras(0);

		// Evento de Mouse
		addMouseListener(
				new MouseAdapter(){
					// Clicado
					public void mousePressed( MouseEvent event ){
						paintJPanelMousePressed( event );
					}}); // fim do  addMouseListener
		
		
		// Evento de Mouse
		addMouseMotionListener(
				new MouseMotionAdapter(){
					// Arrastado
					public void mouseDragged( MouseEvent event ){
						paintJPanelMouseDragged( event );
					}}); // fim do addMouseMotionListener
		
	}

	
	// Eventos quando mouse eh pressionado
	public void paintJPanelMousePressed( MouseEvent event ){
		
		setNumeroFiguras(getNumeroFiguras() + 1 );

		// Cria Linha
		if ( currentType.equals( "Linha" ) ){
			FiguraAtual = new Linha( event.getX(), event.getX(), event.getY(), event.getY(), currentColor , isFilled(), getEspessura() );

		// Cria Retangulo
		}else if ( currentType.equals( "Retangulo" ) ){
			FiguraAtual = new Retangulo( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		// Cria Circulo	
		}else if ( currentType.equals( "Circulo" ) ){
			FiguraAtual = new Circulo( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		// Cria Triangulo
		}else if ( currentType.equals( "Triangulo" ) ){
			FiguraAtual = new Triangulo( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		// Cria Triangulo
		}else if ( currentType.equals("Elipse")){
			FiguraAtual = new Elipse( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );
			
		// Cria Quadrado
		}else if ( currentType.equals("Quadrado")){
			FiguraAtual = new Quadrado( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		// Cria Pincel
		}else if ( currentType.equals("Pincel")){
			FiguraAtual = new Pincel( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		// Cria Borracha
		}else if ( currentType.equals("Borracha")){
			FiguraAtual = new Borracha( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

		}

		// Adiciona Figura ao FormasArrayList
		FormasArrayList.add( FiguraAtual );
	}
		
	// Evento Quando mouse eh arrastado
	public void paintJPanelMouseDragged( MouseEvent event ){
		
		// X2 e Y2 por mouse event
		FiguraAtual.setX2( event.getX() );
		FiguraAtual.setY2( event.getY() );
		
		
		// Pincel enquanto dragged
		if ( currentType.equals("Pincel")){
			
			// Novo Pincel no ArrayList
			FiguraAtual = new Pincel( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

			// Adiciona Figura ao FormasArrayList
			FormasArrayList.add( FiguraAtual);//TodasFiguras[getNumeroFiguras()]  );
			
			setNumeroFiguras( getNumeroFiguras() + 1 );
		}
		
		// Borracha enquanto dragged
		if ( currentType.equals("Borracha")){
			
			// Nova Borracha no ArrayList
			FiguraAtual = new Borracha( event.getX(), event.getX(), event.getY(), event.getY(), currentColor, isFilled(), getEspessura() );

			// Adiciona Figura ao FormasArrayList
			FormasArrayList.add( FiguraAtual );
			
			setNumeroFiguras( getNumeroFiguras() + 1 );			
		}
		
		// Repaint
		repaint();
	}
	
			
	// Desfazer a ultimo desenho
	public void DesfazUltima(){
		
		// Decrementa se for maior que 0 , senao joga para 0
		if ( (getNumeroFiguras() - 1 ) > 0){
			
			// Remove Ultima Figura
			FormasArrayList.remove(getNumeroFiguras() - 1);		
			
			// Decrementa Contador
			setNumeroFiguras( getNumeroFiguras() - 1 );
		
		}else{
			
			// se eh != 0 ele remove, senao nao tem desenho para retirar nem decrementar contador
			if( getNumeroFiguras() != 0 ){
				FormasArrayList.remove(getNumeroFiguras() - 1);				
				setNumeroFiguras(0);			
			}	
		}
		
		// Repaint para tirar UltimaOperacao
		repaint();
	}
	
	
	// Limpa Tela de Desenho
	public void LimpaTela(){
		
		// Zera Contador 
		setNumeroFiguras(0);
		
		// Seta Figura Aberto como falsa
		setAberto(false);
		
		// Zera Array List
		FormasArrayList.removeAll(FormasArrayList);
		
		// Repaint para limpar
		repaint();
	}
		
	
	// Desenha no JPanel
	public void paintComponent( Graphics g ){
		
		super.paintComponent( g );
		
		// Graphics 2d para desenhar
		Graphics2D g2d = (Graphics2D) g;
		
		// Aux de Figura
		Figura ProximaFigura;
		
		// Iterator
		Iterator<Figura> shapesIterator = FormasArrayList.iterator();

		// Pinta Imagem Carregada , se true
		if(isAberto() == true){
			g2d.drawImage(MinhaImagem, 0, 0, null);
		}
		
		
		// Desenha Figuras
		while ( shapesIterator.hasNext()){			
			ProximaFigura = shapesIterator.next();

			ProximaFigura.Desenha(g2d);
		}
		
	}

	// Abre Arquivo
	public void AbreArquivo(){

		// JFilseChooser para Abrir
		JFileChooser AbreArquivo = new JFileChooser("Abrir Arquivo");  

		// Filename para caminho do arquivo a abrir
		File Filename;

		// Abre Arquivo
		int aprovo = AbreArquivo.showOpenDialog(null);

		// Se Selecionado o arquivo
		if (aprovo == JFileChooser.APPROVE_OPTION) {

			// Onde sera salva para filename
			Filename = AbreArquivo.getSelectedFile();

			try {
				// Carrega Imagem
				MinhaImagem = ImageIO.read( new File( Filename.getAbsolutePath()));

				// seta Aberto
				setAberto(true);

				// Pinta Imagem Carregada
				repaint();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo. Tente Novamente", "Erro" , JOptionPane.ERROR_MESSAGE);

				e.printStackTrace();
			}
		}
	}
}