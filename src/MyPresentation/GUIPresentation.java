package MyPresentation;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIPresentation extends JFrame implements ActionListener{
    public JPanel panel; //borde;
    public JLabel foto, descripcion, hobbie;
   // public ImageIcon foto;
    public JButton btphoto, bthobbies, btdescrip;


    public GUIPresentation(){
        this.setTitle("MyPresentation");  //Establecemos el titulo de nuestra ventana
        this.setSize(600,400); //EStablecemos el tamaño de la ventana
        this.setVisible(true); //Con este metodo hacemos visible la ventana
        this.setLocationRelativeTo(null); //Establecemos que la ventana se abra en el centro del monitor
        iniciarComponente(); //Para poder ejecutar dicha clase
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Cuando cerramos la ventana, el programa termina de ejecutar
    }

    private void iniciarComponente(){
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
        eventos();
    }

    private void colocarPaneles(){
        panel = new JPanel();  //Creacion del panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE); //Establecemos el color del panel
        //TitledBorder title;
        //title = BorderFactory.createTitledBorder("title");
        //panel.setBorder(title);
        this.getContentPane().add(panel);  //Agregamos el panel a la ventana

    }

    private void colocarEtiquetas(){
        JLabel etiqueta = new JLabel("Si deseas conocerme un poco mas oprime los botones");
        //etiqueta.setBackground(Color.blue);
        etiqueta.setText("Si deseas conocerme un poco mas oprime los botones");
        etiqueta.setFont(new Font("Times New Roman",Font.BOLD,15)); //Establece la fuente del texto.
        etiqueta.setBounds(0,0, 600, 40);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta
        etiqueta.setBackground(Color.BLACK);
        panel.add(etiqueta);

    }

    private void eventos(){
        foto = new JLabel();
        foto.setBounds(225, 65, 150, 240);
        panel.add(foto);

        hobbie = new JLabel();
        hobbie.setBounds(70, 65, 440, 240);
        panel.add(hobbie);

        descripcion = new JLabel();
        descripcion.setBounds(80,70,400,200);
        descripcion.setFont(new Font("Arial",Font.BOLD,15));
        descripcion.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(descripcion);
    }

    private void colocarBotones() {
        btphoto = new JButton();
        bthobbies = new JButton();
        btdescrip = new JButton();
        btphoto.setText("Foto"); //Texto del botton
        btphoto.setBounds(75, 320, 100, 30); //Posicion del botton
        bthobbies.setText("Hobbies");
        bthobbies.setBounds(240, 320, 100, 30);
        btdescrip.setText("Expectativa");
        btdescrip.setBounds(395, 320, 130, 30);
        panel.add(btphoto); //Agregar el botton en el panel
        btphoto.addActionListener(this); //Agregar accion al presionar le botton
        panel.add(bthobbies);
        bthobbies.addActionListener(this);
        panel.add(btdescrip);
        btdescrip.addActionListener(this);
    }
        private  ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==btphoto) {
                setTitle("YO");
                hobbie.setIcon(null);
                descripcion.setText(null);
                this.image = new ImageIcon(getClass().getResource("/resources/sho1.jpg"));
                foto.setIcon(image);
            }
            else if (e.getSource()==bthobbies) {
                setTitle("HOBBIES");
                foto.setIcon(null);
                descripcion.setText(null);
                this.image = new ImageIcon(getClass().getResource("/resources/hobbies.png"));
                hobbie.setIcon(image);
            }
            else if (e.getSource()==btdescrip) {
                setTitle("Expectativas");
                foto.setIcon(null);
                hobbie.setIcon(null);
                descripcion.setText("<html>Mis expectativas es poder comprender JAVA, sentir GUSTO al programar en este lenguaje" +
                        " y obvio, PODER APROBAR EL CURSO. <html>");
                descripcion.setForeground(Color.BLACK);
            }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation GUI = new GUIPresentation();
            }
        });
    }
}