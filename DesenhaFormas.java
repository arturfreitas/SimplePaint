import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Classe que deseja todo o layout
public class DesenhaFormas extends JFrame{
	
	private static final long serialVersionUID = 1L;

	// JPanel 
	private JPanel controlsJPanel;
	
	// JComboBox to allow selection of a shape
	@SuppressWarnings("rawtypes")
	private JComboBox shapeJComboBox;
	
	// JButtons
	private JButton colorJButton, Desfazer, LimparTela,  colorJButton2;
	
	// PaintJPanel para desenhar figuras
	private PaintJPanel painterPaintJPanel;
	
	// Array de Tipos
	private String[] shapeTypes = { "Pincel" , "Linha", "Retangulo", "Quadrado", "Circulo", "Elipse" , "Triangulo" , "Borracha" };

	// JCheckBox de Preenchimento
	private JCheckBox Preenchimento;
	
	// JMenuBar
	private JMenuBar menuBar;
	
	// Jslider
	private JSlider slider1;

	
	// Construtor da classe
	public DesenhaFormas(){
		CriaInterfaceGrafica();
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void CriaInterfaceGrafica()
	{
		// Cria Container
		Container contentPane = getContentPane();
	
		// Layout NULL
		contentPane.setLayout(null);
		
		// JCheckBox de Preenchimento
		Preenchimento = new JCheckBox("Preenchimento");
		Preenchimento.setBounds(870,0,130,60);
		Preenchimento.setToolTipText("Clique para Ativar Preenchimento nas figuras desenhadas");
		Preenchimento.setBorder(BorderFactory.createLineBorder(Color.black));
		
		contentPane.add(Preenchimento);
		
		// ActionListener para Preenchimento
		Preenchimento.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent event ){
					
						PreenchimendoJCheckBoxActionPerformed( event );
					}});
		
		
		painterPaintJPanel = new PaintJPanel();
		painterPaintJPanel.setBounds( 0, 60, 1000, 450);
		painterPaintJPanel.setBackground( Color.WHITE );
		
		// Adiciona painterPaintJPanel
		contentPane.add( painterPaintJPanel );
		
		controlsJPanel = new JPanel();
		controlsJPanel.setBounds( 0, 0, 1000, 1000 );
		controlsJPanel.setLayout( null );
		
		// Adiciona ConstrolsJPanel
		contentPane.add( controlsJPanel );
	
		shapeJComboBox = new JComboBox( shapeTypes );
		shapeJComboBox.setBounds( 0, 0, 150, 60);
		controlsJPanel.add( shapeJComboBox );
	
		// ActionListener para JComboBox
		shapeJComboBox.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						shapeJComboBoxActionPerformed( event );
					}}); 

		
		// Criar Collor JButton 1 e 2
		colorJButton = new JButton();
		colorJButton.setBounds( 151, 0, 150, 60 );
		colorJButton.setText( "Cores" );
		
		colorJButton2 = new JButton();
		colorJButton2.setBounds( 302, 0, 150, 60 );
		colorJButton2.setText( "Plano de Fundo" );
		
		// Adiciona JButtons
		controlsJPanel.add( colorJButton );
		controlsJPanel.add( colorJButton2 );
		
		// ActionListener para JButton
		colorJButton.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						colorJButtonActionPerformed( event );
					}});

		// ActionListener para JButton
		colorJButton2.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						colorJButton2ActionPerformed( event );
					}});
		
		
		// JSlider para borda
		slider1 = new JSlider();
		// Valor inicial em 0
		slider1.setValue(0);
		
		slider1.setBorder(BorderFactory.createTitledBorder("Espessura Bordas"));
		slider1.setBounds( 460, 0 , 330 , 60 );
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMaximum(200);
		slider1.setMajorTickSpacing(20);
		
		// Change Listener para JSlider
		slider1.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		    	  // Espessura de acordo com o getValue de JSlider
		    	  painterPaintJPanel.setEspessura((float)  slider1.getValue()); 
		      }
		});

		// Adiciona slider1
		controlsJPanel.add(slider1);

		// Cria Desfazer
		Desfazer = new JButton(); 
		Desfazer.setBounds( 501 , 512, 500, 35);
		Desfazer.setText("Desfazer \u00DAltima A\u00E7\u00E3o");

		controlsJPanel.add(Desfazer);

		Desfazer.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						DesfazerJButtonActionPerformed( event );
					}});


		LimparTela = new JButton();
		LimparTela.setBounds( 0 , 512 , 500, 35);
		LimparTela.setText("Limpa Tela");

		 controlsJPanel.add(LimparTela);

		 LimparTela.addActionListener(
				 new ActionListener(){
					 public void actionPerformed( ActionEvent event ){
						 LimparTelaJButtonActionPerformed( event );
					 }});

		 
		 // MenuBar 
		 menuBar = new JMenuBar();
		 setJMenuBar(menuBar);

		 JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		 menuBar.add(mnOpes);

		 JMenuItem mntmNovo = new JMenuItem("Novo");
		 mntmNovo.setIcon(new ImageIcon(DesenhaFormas.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		 
		 mnOpes.add(mntmNovo);
		 mntmNovo.addActionListener(
				 new ActionListener(){
					 public void actionPerformed( ActionEvent event ){
						 LimparTelaJButtonActionPerformed( event );
					 }});

		 // Adiciona Separador
		 mnOpes.add(new JSeparator());
		 
		 JMenuItem mntmAbrir = new JMenuItem("Abrir");
		 mntmAbrir.setIcon(new ImageIcon(DesenhaFormas.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		 mnOpes.add(mntmAbrir);
		 
		 // Action Listener de Abrir
		 mntmAbrir.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0){
				AbreMenuItemActionPerformed(arg0);
			 }
		 });

		 // Adiciona Separador
		 mnOpes.add(new JSeparator());
		 
		 JMenuItem mntmSalvar = new JMenuItem("Salvar");
		 mntmSalvar.setIcon(new ImageIcon(DesenhaFormas.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		 mnOpes.add(mntmSalvar);
		 
		 // Action Listener de Salvar
		 mntmSalvar.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0){
				 try {
					SalvarMenuItemActionPerformed(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 });

		 // Adiciona Separador
		 mnOpes.add(new JSeparator());
		 
		 // Menu Item de Sair
		 JMenuItem mntmSair = new JMenuItem("Sair");
		 mntmSair.setIcon(new ImageIcon(DesenhaFormas.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		 mnOpes.add(mntmSair);
		 
		 // Action listener de Sair
		 mntmSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});

		 
		 
		 JMenu mnAjuda = new JMenu("Ajuda");
		 menuBar.add(mnAjuda);
		 
		 JMenuItem mntmSobre = new JMenuItem("Sobre");
		 mntmSobre.setIcon(new ImageIcon(DesenhaFormas.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		 mnAjuda.add(mntmSobre);

		 mntmSobre.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0){

				 String texto = "Como usar o programa :\n\n";  
				 texto += "- Op\u00E7\u00F5es voc\u00EA seleciona entre : Novo, Salvar, Abrir, e Sair\n\n";  
				 texto += "- Ajuda Voc\u00EA pode selecionar entre : Sobre e Creditos\n\n";
				 texto += "- Limpa tela -> limpar todo o painel de desenho\n\n - Desfazer -> Ultima opcao desfaz Ultimo desenhado\n\n";
				 texto += "- Primeira caixa seleciona entre as formas de figuras disponiveis para desenhar - >\n\tTriangulo, "
						 + "Retangulo, Circulo, Quadrado, Elipse, Linha e Borracha\n\n";
				 texto  += "- Cores -> Seleciona a Cor\n\n- Preenchimento -> Preenche a figura\n\n"
						 + "- Plano de Fundo -> altera a cor do plano de fundo\n\n";
				 texto += "\nQualquer duvida entre em contato.";
				 JOptionPane.showMessageDialog(null, texto, "Creditos" , JOptionPane.INFORMATION_MESSAGE);

			 }});

		 // Adiciona Separador
		 mnAjuda.add(new JSeparator());

		 JMenuItem mntmCreditos = new JMenuItem("Cr\u00E9ditos");
		 mnAjuda.add(mntmCreditos);

		 mntmCreditos.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0){

				 String texto = "Cr\u00E9ditos a : \n";  
				 texto += " \n\n";  
				 texto += "Felipe Moreira Moura 	, n\u00B0 USP 8066461 \n";
				 texto += "Pedro Morello Abbud		, n\u00B0 USP 8058718 \n";
				 texto += "Cristiano Jos\u00E9 dos Santos, n\u00B0 USP 8123040 \n";
				 texto += "\n\n";
				 JOptionPane.showMessageDialog(null, texto, "Cr\u00E9ditos" , JOptionPane.INFORMATION_MESSAGE);

			 }});

		// Titulo do Programa
		setTitle( "Editor de Imagens " );
		
		// Tamanho 1000 x 1000
		setSize( 1000, 600);
		
		// Visivel = true
		setVisible( true );

		// Nao Permitei Resize
		setResizable(false);
	} 

	
	// Action Listener do prenchimento
	private void PreenchimendoJCheckBoxActionPerformed( ActionEvent event ){
		
		//  prenchimento eh true
		if (Preenchimento.isSelected()){
			painterPaintJPanel.setFilled(true);
		
		// Senao false
		}else{
			painterPaintJPanel.setFilled(false);	
		}	
	}
	
	// ActionListener para JColorChooser para cores de desenho
	private void colorJButtonActionPerformed( ActionEvent event ){	
		Color selection = JColorChooser.showDialog( null,"Selecione uma Cor", Color.BLACK );
		
		if ( selection != null ){
			// Background do Jbutton na cor escolhida
			colorJButton.setBackground( selection );
			
			// Coloca a cor nas figuras a desenhar
			painterPaintJPanel.setCurrentColor( selection );
		}
	} 
	
	// ActionListener para JColorChooser para plano de fundo
	private void colorJButton2ActionPerformed( ActionEvent event ){	
		Color selection = JColorChooser.showDialog( null,"Selecione uma Cor", Color.BLACK );

		// Setta Background na cor escolhida
		if ( selection != null ){
			// Coloca a cor de background
			painterPaintJPanel.setBackground( selection );
		}
	} 

	// ActionListener para JcomboVox
	private void shapeJComboBoxActionPerformed( ActionEvent event ){	
		painterPaintJPanel.setCurrentShapeType( (String) shapeJComboBox.getSelectedItem() );
	} 

	// Limpa a Tela do JPanel
	private void  LimparTelaJButtonActionPerformed( ActionEvent event ){
		painterPaintJPanel.LimpaTela();
		painterPaintJPanel.setBackground(Color.WHITE);
	}

	// Desfazer Ultima Acao do Usuario
	private void DesfazerJButtonActionPerformed (ActionEvent event){
		painterPaintJPanel.DesfazUltima();
	}


	// Salvar Imagem no direitorio especificado pelo usuario, Com JFILECHOOSER
	public void SalvarMenuItemActionPerformed( ActionEvent event ) throws IOException {

		// Filename
		File Filename;

		// JfileChooser para salvar
		JFileChooser ArquivoDeSalvar = new JFileChooser("Salvar Arquivo");

		// Buffered image para salvar no arquivo
		BufferedImage Imagem = new BufferedImage( painterPaintJPanel.getWidth(), painterPaintJPanel.getHeight(), BufferedImage.TYPE_INT_ARGB ); 

		// Graphics 2D para ter a imagem
		Graphics2D g2d =  (Graphics2D) Imagem.createGraphics();
	
		// Pinta
		painterPaintJPanel.paint(g2d);
	
		// Retira os componentes
		g2d.dispose();

		// Chama JFileChooser para especificar onde salvar
		int aprovo = ArquivoDeSalvar.showSaveDialog(null);
		
		if (aprovo == JFileChooser.APPROVE_OPTION) {

			// Onde sera salva para filename
			Filename = ArquivoDeSalvar.getSelectedFile();

			// Salva imagem no formato png
			try {
				// Adiciona png no final do nome
				ImageIO.write( Imagem ,"png", new File( Filename.getAbsolutePath() + ".png"));
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo. Tente Novamente", "Erro" , JOptionPane.ERROR_MESSAGE);
				
				e.printStackTrace();
			}
		}
	}


	// ActionPerformed de Menu
	public void AbreMenuItemActionPerformed( ActionEvent event ){
		
		// Limpar a tela antes de carregar arquivo
		painterPaintJPanel.LimpaTela();
		painterPaintJPanel.setBackground(Color.WHITE);
		
		// Carrega Arquivo
		painterPaintJPanel.AbreArquivo();
	}	
}
