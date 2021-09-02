package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JPanel panelImagen;
	private JPanel panelFecha;
	private JLabel lblFecha;
	private JLabel lblImagen;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldGitHubURL;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabInformation.setLayout(null);
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Arial", Font.BOLD, 12));
		lblLU.setBounds(15, 13, 70, 15);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 12));
		lblApellido.setBounds(15, 43, 70, 15);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(15, 73, 70, 15);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(15, 103, 70, 15);
		tabInformation.add(lblEmail);
		
		JLabel lblGitHubURL = new JLabel("Github URL");
		lblGitHubURL.setFont(new Font("Arial", Font.BOLD, 12));
		lblGitHubURL.setBounds(15, 133, 70, 15);
		tabInformation.add(lblGitHubURL);
		
		textFieldLU = new JTextField();
		textFieldLU.setColumns(10);
		textFieldLU.setBounds(90, 10, 312, 20);
		textFieldLU.setText(Integer.toString(studentData.getId()));
		tabInformation.add(textFieldLU);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(90, 40, 312, 20);
		textFieldApellido.setText(studentData.getLastName());
		tabInformation.add(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(90, 70, 312, 20);
		textFieldNombre.setText(studentData.getFirstName());
		tabInformation.add(textFieldNombre);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(90, 100, 312, 20);
		textFieldEmail.setText(studentData.getMail());
		tabInformation.add(textFieldEmail);
		
		textFieldGitHubURL = new JTextField();
		textFieldGitHubURL.setColumns(10);
		textFieldGitHubURL.setBounds(90, 130, 312, 20);
		textFieldGitHubURL.setText(studentData.getGithubURL());
		tabInformation.add(textFieldGitHubURL);
		
		panelImagen = new JPanel();
		panelImagen.setPreferredSize(new Dimension(154, 197));
		panelImagen.setLayout(null);
		contentPane.add(panelImagen, BorderLayout.EAST);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 154, 197);
		lblImagen.setIcon(new ImageIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())).getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
		panelImagen.add(lblImagen);		
		
		panelFecha = new JPanel();
		panelFecha.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelFecha, BorderLayout.SOUTH);
		
		lblFecha = new JLabel("Esta ventana fue generada el "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" a las: "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		lblFecha.setFont(new Font("Arial", Font.BOLD, 12));
		panelFecha.add(lblFecha, BorderLayout.WEST);
	}
}
