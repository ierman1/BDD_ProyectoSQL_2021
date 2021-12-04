import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Personaje> pjs = (ArrayList<Personaje>) Personaje.getList();
        for (Personaje pj : pjs) {
            System.out.println(pj.toString());
        }

    }

}
