package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student student = new Student(121036, "Diz", "Facundo Matias", "facundodiz87@gmail.com", "https://github.com/FacundoDiz", "/images/fotoFacundoDiz.jpg");
            	SimplePresentationScreen simplePresentationScreen = new SimplePresentationScreen(student);
            	simplePresentationScreen.setVisible(true);
            }
        });
    }
}