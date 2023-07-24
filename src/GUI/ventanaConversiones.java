package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import LogicaConversiones.ProcesosConversiones;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.DecimalFormat;


public class ventanaConversiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_Resultado;
	private JComboBox cboSelectorMonedas;
    private JComboBox cboSelectorMonedasDestino;
    private DecimalFormat decimalFormat;
    private JLabel lblNewLabel;
    private JLabel lblPesosColombianos;
    
    

	

	/**
	 * Create the frame.
	 */
	public ventanaConversiones() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 285);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 87, 233, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 374, 246);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 // Asignar cboSelectorMonedas a la variable miembro
        cboSelectorMonedas = new JComboBox();
        cboSelectorMonedas.setBackground(Color.WHITE);
        cboSelectorMonedas.setForeground(new Color(0, 0, 0));
        cboSelectorMonedas.setBorder(null);
        cboSelectorMonedas.setBounds(242, 87, 107, 36);
        panel.add(cboSelectorMonedas);
        cboSelectorMonedas.setModel(new DefaultComboBoxModel(new String[] {"Dólar (USD)", "Euro", "Libras", "Yen", "Won Coreano", "Pesos (COP)"}));
        
        cboSelectorMonedas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversion();
                String monedaOrigen = cboSelectorMonedas.getSelectedItem().toString();
    	        String monedaDestino = cboSelectorMonedasDestino.getSelectedItem().toString();

    	        ProcesosConversiones conversiones = new ProcesosConversiones(1, monedaOrigen, monedaDestino);
    	        double resultado = conversiones.convertir();
                
                if(monedaOrigen.equals("Pesos (COP)") || monedaOrigen.equals("Won Coreano")  ) {
                 	decimalFormat = new DecimalFormat("#,##0.00000");
                }else {
                	decimalFormat = new DecimalFormat("#,##0.00"); 
                }
                

    	        String resultadoFormateado = decimalFormat.format(resultado);
    	        

    		    // Update the labels with the new currency values
    		    lblNewLabel.setText("1 " + monedaOrigen + " Es igual a");
    		    lblPesosColombianos.setText(resultadoFormateado + " " + monedaDestino);
            }
        });
		
		JButton btnInvertirSelecion = new JButton("⇅");
		btnInvertirSelecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invertirSeleccionMonedas();				
			}
		});
		btnInvertirSelecion.setBackground(new Color(153, 204, 255));
		btnInvertirSelecion.setBorder(null);
		btnInvertirSelecion.setBounds(96, 212, 39, 23);
		panel.add(btnInvertirSelecion);
		
		textField_Resultado = new JTextField();
		textField_Resultado.setEditable(false);
		textField_Resultado.setForeground(Color.BLACK);
		textField_Resultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Resultado.setColumns(10);
		textField_Resultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_Resultado.setBounds(10, 153, 233, 36);
		panel.add(textField_Resultado);
		
		cboSelectorMonedasDestino = new JComboBox();
        cboSelectorMonedasDestino.setModel(new DefaultComboBoxModel(new String[] {"Dólar (USD)", "Euro", "Libras", "Yen", "Won Coreano", "Pesos (COP)"}));
        cboSelectorMonedasDestino.setSelectedIndex(5);
        cboSelectorMonedasDestino.setForeground(Color.BLACK);
        cboSelectorMonedasDestino.setBorder(null);
        cboSelectorMonedasDestino.setBackground(Color.WHITE);
        cboSelectorMonedasDestino.setBounds(242, 153, 107, 36);
        panel.add(cboSelectorMonedasDestino);
        
        cboSelectorMonedasDestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarConversion();
                
                
                String monedaOrigen = cboSelectorMonedas.getSelectedItem().toString();
    	        String monedaDestino = cboSelectorMonedasDestino.getSelectedItem().toString();

    	        ProcesosConversiones conversiones = new ProcesosConversiones(1, monedaOrigen, monedaDestino);
    	        double resultado = conversiones.convertir();
    	        
    	        String resultadoFormateado = decimalFormat.format(resultado);

    		    // Update the labels with the new currency values
    		    lblNewLabel.setText("1 " + monedaOrigen + " Es igual a");
    		    lblPesosColombianos.setText(resultadoFormateado + " " + monedaDestino);
            }
        });
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarConversion();
				
			}
		});
		btnConvertir.setBounds(10, 212, 89, 23);
		panel.add(btnConvertir);
		btnConvertir.setBackground(new Color(153, 204, 255));
		btnConvertir.setBorder(null);
		
		String monedaOrigen = cboSelectorMonedas.getSelectedItem().toString();
        String monedaDestino = cboSelectorMonedasDestino.getSelectedItem().toString();

        ProcesosConversiones conversiones = new ProcesosConversiones(1, monedaOrigen, monedaDestino);
        double resultado = conversiones.convertir();
        
        // Inicializar el objeto decimalFormat con el patrón deseado

     	decimalFormat = new DecimalFormat("#,##0.00");        
     	decimalFormat.setGroupingUsed(true);
     	decimalFormat.setGroupingSize(3);
     	    

        String resultadoFormateado = decimalFormat.format(resultado);
		
		lblNewLabel = new JLabel("1 " + monedaOrigen + " Es igual a");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBackground(SystemColor.scrollbar);
		lblNewLabel.setBounds(10, 11, 153, 14);
		panel.add(lblNewLabel);
		
		lblPesosColombianos = new JLabel( resultadoFormateado + " " + monedaDestino );
		lblPesosColombianos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPesosColombianos.setBackground(SystemColor.scrollbar);
		lblPesosColombianos.setBounds(10, 27, 339, 36);
		panel.add(lblPesosColombianos);
		
		
		
		// DocumentListener para el campo de entrada (textField)
		textField.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        realizarConversion();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        realizarConversion();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        // Esta función no es necesaria para JTextField
		    }
		});
		
		
	}
	
	 private void realizarConversion() {
		 
		 String inputText = textField.getText().trim();
		 
		 if (inputText.isEmpty()) {
			 return; 
		    }
		 try {
	            double monto = Double.parseDouble(textField.getText());
	            String monedaOrigen = cboSelectorMonedas.getSelectedItem().toString();
	            String monedaDestino = cboSelectorMonedasDestino.getSelectedItem().toString();
	            
	            ProcesosConversiones conversiones = new ProcesosConversiones(monto, monedaOrigen, monedaDestino);
	            double resultado = conversiones.convertir();

	            String resultadoFormateado = decimalFormat.format(resultado);
	            textField_Resultado.setText(resultadoFormateado);
	        } catch (NumberFormatException ex) {
	            textField_Resultado.setText("Ingrese un número válido");
	        } catch (NullPointerException ex) {
	            textField_Resultado.setText("Error: Seleccione las monedas de origen y destino");
	        } catch (Exception ex) {
	            textField_Resultado.setText("Error desconocido: " + ex.getMessage());
	        }
	    }
	 
	 private void invertirSeleccionMonedas() {
		    // Obtenemos los índices de las selecciones actuales
		    int indiceMonedaOrigen = cboSelectorMonedas.getSelectedIndex();
		    int indiceMonedaDestino = cboSelectorMonedasDestino.getSelectedIndex();

		    // Intercambiamos las selecciones
		    cboSelectorMonedas.setSelectedIndex(indiceMonedaDestino);
		    cboSelectorMonedasDestino.setSelectedIndex(indiceMonedaOrigen);
		    
		    String monedaOrigen = cboSelectorMonedas.getSelectedItem().toString();
	        String monedaDestino = cboSelectorMonedasDestino.getSelectedItem().toString();

	        ProcesosConversiones conversiones = new ProcesosConversiones(1, monedaOrigen, monedaDestino);
	        double resultado = conversiones.convertir();

	        String resultadoFormateado = decimalFormat.format(resultado);

		    // Update the labels with the new currency values
		    lblNewLabel.setText("1 " + monedaOrigen + " Es igual a");
		    lblPesosColombianos.setText(resultadoFormateado + " " + monedaDestino);
		    

		}

	 
	
	
}
