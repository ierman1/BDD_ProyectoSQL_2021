package App.Views;

import App.AppController;
import App.Models.Personaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CrearPersonaje extends View {

    private Personaje personaje;

    public CrearPersonaje(JFrame frame) {
        super(frame, "Crear personaje");
    }

    int elementHeight = 0;
    private static final int INCR_VERT = 35;

    public JPanel render() {
        JPanel panelBotones = new JPanel();
        JButton botonVolver = new JButton("Volver");
        JButton botonElegirClase = new JButton("Eligir clase");

        //campos del personaje
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(15, elementHeight += INCR_VERT, 75, 20);

        JTextField tfNombre = new JTextField();
        tfNombre.setBounds(100, elementHeight, 150, 20);

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("C:\\Users\\Guillem\\Downloads\\avatar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = myPicture.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        JLabel lblAvatar = new JLabel(new ImageIcon(dimg), SwingConstants.RIGHT);
        lblAvatar.setBounds(500,35, 75,75);
        lblAvatar.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(15, elementHeight += INCR_VERT, 75, 20);

        JTextField tfEdad = new JTextField();
        tfEdad.setBounds(100, elementHeight, 150, 20);

        JLabel lblTrasfondo = new JLabel("Trasfondo:");
        lblTrasfondo.setBounds(15, elementHeight += INCR_VERT, 75, 20);

        JTextArea taTrasfondo = new JTextArea();
        taTrasfondo.setBounds(15, elementHeight += INCR_VERT, 350, 100);





        // Mostrar el contenido
        panelBotones.setLayout(new BorderLayout(15,15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        panelBotones.add(botonVolver, BorderLayout.LINE_START);
        panelBotones.add(botonElegirClase, BorderLayout.LINE_END);

        panel.add(panelBotones, BorderLayout.PAGE_END);

        panel.add(lblNombre);
        panel.add(tfNombre);
        panel.add(lblAvatar, BorderLayout.NORTH);

        panel.add(lblEdad);
        panel.add(tfEdad);

        panel.add(lblTrasfondo);
        panel.add(taTrasfondo);





        // Eventos
        botonVolver.addActionListener(e -> AppController.listaPersonajes());
        botonElegirClase.addActionListener(e -> AppController.crearPersonajeFase2());
        lblAvatar.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                //test filepicker
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());

                    //foto nova imatge
                    BufferedImage myPicture = null;
                    try {
                        myPicture = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    Image dimg = myPicture.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                    JLabel lblAvatar = new JLabel(new ImageIcon(dimg), SwingConstants.RIGHT);
                    panel.add(lblAvatar);
                    //AIXO ENCARA NO FUNCIONA, NO SOBREEESCRIU LA IMATGE
                }
            }
        });

        return panel;
    }



}
