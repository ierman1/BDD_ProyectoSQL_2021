package App.Popups;

import App.Connector;
import App.Models.Hechizo;
import App.Models.Personaje;
import App.Views.HechizosPersonaje;

import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static App.Connector.executeQuery;

public class popupResumen {

    private static boolean up = false;


    public static void show() {
        if (up)
            return;
        up = true;
        JFrame frame = new JFrame("Resumen");
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        JPanel panelRaiz = new JPanel();
        frame.add(panelRaiz);


        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                up = false;
            }
        });

        String bigSpellcaster =
                "select count (ha.*) as num, pj.nombre as nombre " +
                "from personajes pj join hechizos_aprendidos ha on pj.id = ha.id_personaje " +
                "group by pj.nombre " +
                "order by 1 " +
                "limit 1 ";

        JLabel lblBigSpellCaster = new JLabel();
        ResultSet rs = Connector.executeQuery(bigSpellcaster);
        String name = "";
        int qt = 0;
        try {
            while(rs.next()){
                        qt = rs.getInt("num");
                        name = rs.getString("nombre");
            }
        } catch (SQLException e) {

        }
        lblBigSpellCaster.setText("El personaje con mas hechizos es "+name+" con "+qt+" hechizos");


        String bigBountyHunters =
                "select sum(pj.oro) as oro, cl.nombre as nombre " +
                        "from personajes pj join clases cl on pj.id_clase = cl.id " +
                        "group by 2 " +
                        "order by oro " +
                        "limit 1";
        String nameBounty = "";
        int oro = 0;

        JLabel lblBigBountyHunter = new JLabel();
        rs = Connector.executeQuery(bigBountyHunters);
        try {
            while(rs.next()){
                oro = rs.getInt("oro");
                nameBounty = rs.getString("nombre");
            }
        } catch (SQLException e) {

        }
        lblBigBountyHunter.setText("La clase con más capital acumulado es "+nameBounty+" con unas arcas de "+oro+" de oro");

        String richRaze =
                "select sum(pj.oro) as oro, rz.nombre as nombre " +
                        "from personajes pj join razas rz on pj.id_raza = rz.id " +
                        "group by 2 " +
                        "order by oro " +
                        "limit 1";
        String nameRaza = "";
        int oroRaza = 0;

        JLabel lblRazeBounty = new JLabel();
        rs = Connector.executeQuery(richRaze);
        try {
            while(rs.next()){
                oroRaza = rs.getInt("oro");
                nameRaza = rs.getString("nombre");
            }
        } catch (SQLException e) {

        }
        lblRazeBounty.setText("La raza con más capital acumulado es "+nameRaza+" con unas arcas de "+oroRaza+" de oro");


        String commonSpell =
                "select count (ha.id_hechizo) as times, h.nombre as nombre " +
                        "from hechizos_aprendidos ha join hechizos h on h.id= ha.id_hechizo " +
                        "group by 2 " +
                        "order by 1 " +
                        "limit 1";
        String spell = "";
        int learn = 0;

        JLabel lblCommonSpell = new JLabel();
        rs = Connector.executeQuery(commonSpell);
        try {
            while(rs.next()){
                learn = rs.getInt("times");
                spell = rs.getString("nombre");
            }
        } catch (SQLException e) {

        }
        lblCommonSpell.setText("El hechizo mas comun es "+spell+ " aprendido "+learn+" veces");

        panelRaiz.add(lblBigSpellCaster);
        panelRaiz.add(lblBigBountyHunter);
        panelRaiz.add(lblRazeBounty);
        panelRaiz.add(lblCommonSpell);

    }

}
