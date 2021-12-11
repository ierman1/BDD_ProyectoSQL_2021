package App.Views;

import App.AppController;
import App.Models.Personaje;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoPersonaje extends View {

	private Personaje personaje;

	public InfoPersonaje(JFrame frame, Personaje personaje) {
		super(frame, personaje.getNombre() + ", Nivel: "+personaje.getNivel());
		this.personaje = personaje;
	}

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField informaciónBásicaTextField;
	private JCheckBox inspiradoCheckBox;

	public JPanel render() {


		return this.panel;
	}
	private void $$$setupUI$$$() {
		/**/
		JButton botonVolver = new JButton("Volver");

		// crear stats
		ArrayList<String> stats = new ArrayList();
		int modFuerza = (personaje.getFuerza() - 10) / 2;
		stats.add("Str: " + personaje.getFuerza() + " (" + modFuerza + ")");

		int modDestreza = (personaje.getDestreza() - 10) / 2;
		stats.add("Dex: " + personaje.getDestreza() + "(" + modDestreza + ")");

		int modConstitucion = (personaje.getConstitucion() - 10) / 2;
		stats.add("Con: " + personaje.getConstitucion() + " (" + modConstitucion + ")");

		int modInteligencia = (personaje.getInteligencia() - 10) / 2;
		stats.add("Int: " + personaje.getInteligencia() + " (" + modInteligencia + ")");

		int modSabiduria = (personaje.getSabiduria() - 10) / 2;
		stats.add("Wis: " + personaje.getSabiduria() + "(" + modSabiduria + ")");

		int modCarisma = (personaje.getCarisma() - 10) / 2;
		stats.add("Char: " + personaje.getCarisma() + " (" + modCarisma + ")");

		JList lista = new JList(stats.toArray());



		JScrollPane scrollLista = new JScrollPane();
		JPanel panelOpciones = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollLista, panelOpciones);

		lista.setSelectionInterval(-1, -1);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setVisibleRowCount(-1);
		scrollLista.setViewportView(lista);
		scrollLista.setMinimumSize(new Dimension(100, 200));

		/**/




		this.panel = new JPanel();
		this.panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
		this.panel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setText("Clase: ");
		panel2.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		textField1 = new JTextField();
		panel2.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		textField1.setText(personaje.getClase().getNombre());
		final JLabel label2 = new JLabel();
		label2.setText("Raza: ");
		panel2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		textField2 = new JTextField();
		panel2.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		textField2.setText(personaje.getRaza().getNombre());
		final JLabel label3 = new JLabel();
		label3.setText("Edad: ");
		panel2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		textField3 = new JTextField();
		textField3.setText(personaje.getEdad()+"");
		panel2.add(textField3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label4 = new JLabel();
		label4.setText("Altura: ");
		panel2.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		textField4 = new JTextField();
		textField4.setText(personaje.getAltura()+"");
		panel2.add(textField4, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label5 = new JLabel();
		label5.setText("Peso: ");
		panel2.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label6 = new JLabel();
		label6.setText("Vida Maxima: ");
		panel2.add(label6, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JTextField textField5 = new JTextField();
		textField5.setText(personaje.getPeso()+"");
		panel2.add(textField5, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JTextField textField6 = new JTextField();
		textField6.setText(personaje.getVida_max()+"");
		panel2.add(textField6, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label7 = new JLabel();
		label7.setText("Vida Actual: ");
		panel2.add(label7, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JTextField textField7 = new JTextField();
		textField7.setText(personaje.getVida_actual()+"");
		panel2.add(textField7, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label8 = new JLabel();
		label8.setText("Oro: ");
		panel2.add(label8, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JTextField textField8 = new JTextField();
		textField8.setText(personaje.getOro()+"");
		panel2.add(textField8, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

		informaciónBásicaTextField = new JTextField();
		informaciónBásicaTextField.setText("Información Básica: ");
		panel2.add(informaciónBásicaTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label9 = new JLabel();
		label9.setText("Trasfondo: ");
		panel2.add(label9, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JTextField textField9 = new JTextField();
		panel2.add(textField9, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		inspiradoCheckBox = new JCheckBox();
		inspiradoCheckBox.setText(personaje.getTrasfondo());
		panel2.add(inspiradoCheckBox, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


		// Mostrar el contenido
		this.panel.add(splitPane, BorderLayout.CENTER);
		this.panel.add(botonVolver, BorderLayout.PAGE_END);

		// Eventos
		botonVolver.addActionListener(e -> AppController.listaPersonajes());

	}
}
