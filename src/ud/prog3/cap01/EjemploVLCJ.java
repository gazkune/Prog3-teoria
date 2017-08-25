package ud.prog3.cap01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery; 

public class EjemploVLCJ extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static EjemploVLCJ miVentana;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent;

	public EjemploVLCJ() {
		setTitle("Prueba vlcj");
		setSize(800, 600);
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		add( mediaPlayerComponent, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPlayPausa = new JButton( "Play/Pausa" );
		pBotonera.add( bPlayPausa );
		add( pBotonera, BorderLayout.SOUTH );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.getMediaPlayer().stop();
				mediaPlayerComponent.getMediaPlayer().release();
			}
		});
		bPlayPausa.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mediaPlayerComponent.getMediaPlayer().isPlaying())
					mediaPlayerComponent.getMediaPlayer().pause();
				else
					mediaPlayerComponent.getMediaPlayer().play();
			}
		});
	}

	private void lanza(String mrl) {
		mediaPlayerComponent.getMediaPlayer().playMedia(mrl);
	}

	public static void main(String[] args) {
		// Inicializar VLC. Probar con el buscador nativo...
		boolean found = new NativeDiscovery().discover();
		// Si no se encuentra probar otras opciones:
		if (!found) {
			// Buscar vlc como variable de entorno
		    String vlcPath = System.getenv().get( "vlc" );
		    if (vlcPath==null) {
		    	// Poner VLC a mano
		        System.setProperty("jna.library.path", "c:\\Program Files\\videolan\\VLC");
		        } else {
		        	// Poner VLC desde la variable de entorno
		            System.setProperty( "jna.library.path", vlcPath );
		        }		                
		}
		
		//System.setProperty("jna.library.path", "c:\\Archivos de programa\\videolan\\vlc-2.1.5");
		miVentana = new EjemploVLCJ();
		miVentana.lanza("test/res/[Official Video] Daft Punk - Pentatonix.mp4");
	}
	
}