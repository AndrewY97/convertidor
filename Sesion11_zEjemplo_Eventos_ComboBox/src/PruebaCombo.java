import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;



class VentanaConversor extends JFrame implements ActionListener{
	
	JTextField cajaGradosC, cajaResultado;
	JComboBox<String> comboTemperaturas;
	JButton btnConvertir;
	double f,k,r;
	int c;
	
	public VentanaConversor() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Evento COMBOBOX");
		setSize(230, 350);
		setLocationRelativeTo(null);
		setVisible(true);	
		
		add(new JLabel("Ingresa ºC a convertir: ") );
		cajaGradosC = new JTextField("70", 10);
		add(cajaGradosC);
		
		add(new JLabel("Seleccion opcion a convertir: ") );
		String items[] = {"Selecciona...", "º Fahrenheit", "º Kelvin", "º Rankine"};
		comboTemperaturas = new JComboBox<>(items);
		comboTemperaturas.addActionListener(this);
		add(comboTemperaturas);
		
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.addActionListener(this);
		add(btnConvertir);
		
		cajaResultado = new JTextField(10);
		add(cajaResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		c=Integer.parseInt(cajaGradosC.getText());
		if(e.getSource()==comboTemperaturas) {
			Double grados = Double.parseDouble(cajaGradosC.getText());
			if(comboTemperaturas.getSelectedIndex()==1){ 
				f=(c*1.8)+32;
				cajaResultado.setText(String.valueOf(f));}
			else if(comboTemperaturas.getSelectedIndex()==2) {
				k=(c+273.15);
				cajaResultado.setText(String.valueOf(k));}
			else if(comboTemperaturas.getSelectedItem().equals("º Rankine")) {
				r=(c*1.8)+491.67;
				cajaResultado.setText(String.valueOf(r));}
			else
				cajaResultado.setText("OPCION INCORRECTA");
		}
	}
}

public class PruebaCombo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaConversor();
			}
		});

	}

}






