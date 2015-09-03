import java.net.URL;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.UIManager;

/*
 * @author Dhruv
 * 
 * The following code is used to display a given html file: SampleEDDYResult.html
 * A main UI window is created, then a WebView is created within that, and lastly the WebView source is set
 * to the desired HTML file
 */

public class CytoscapeSwing {

	public static JFrame mainFrame;
	
	public static void main(String[] args) {

		mainFrame = new JFrame();
		JFXPanel cytoscapePanel = new JFXPanel();
		mainFrame.add(cytoscapePanel);

		
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		//Java FX, create the cytoscape panel with the given html
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(cytoscapePanel);
            }
       });
		
		// set frame dimensions, show GUI
		mainFrame.setSize(810, 660);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}


    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread, create the scene to hold all of the elements
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, 1000, 1000);
        
        //Webview used to display JS
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        URL myURL = CytoscapeSwing.class.getResource("SampleEDDYResult.html"); //the source file is set from witin the CytoscapeSwing class
        webEngine.load(myURL.toExternalForm());
        

        root.getChildren().add(browser);

        return (scene);
    }
}