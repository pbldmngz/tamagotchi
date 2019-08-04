//CETYS UNIVERSIDAD CAMPUS ENSENADA, INGENIERÍA EN SOFTWARE, PFRA. LUCÍA BELTRÁN
//Objeto tamagotchi
package tamagotchi;

import java.io.Serializable;

/**
 *
 * @author Pablo A. Domínguez Medina
 */
public class tamagotchi implements Serializable{

    private String nombre, texto;
    private int vida, hambre, felicidad, sueño, sed, higiene;
    public boolean state;

    public tamagotchi() {
    }

    public void asInicial() {
        vida = 100;
        hambre = 100;
        felicidad = 100;
        sueño = 100;
        sed = 100;
        higiene = 100;
        state = true;
        texto = "Hola! Mi nombre es Knuckles!";
    }

    //Sets
    public void setVida(int var) {
        vida = var;
    }

    public void setHambre(int var) {
        hambre = var;
    }

    public void setFelicidad(int var) {
        felicidad = var;
    }

    public void setSueño(int var) {
        sueño = var;
    }

    public void setSed(int var) {
        sed = var;
    }

    public void setHigiene(int var) {
        higiene = var;
    }

    public void setNombre(String var) {
        nombre = var;
    }

    public void setState(boolean var) {
        state = var;
    }

    //Gets
    public int getVida() {
        return vida;
    }

    public int getHambre() {
        return hambre;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getSueño() {
        return sueño;
    }

    public int getSed() {
        return sed;
    }

    public int getHigiene() {
        return higiene;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTexto()
    {
        return texto;
    }
    
    public void setTexto(String t)
    {
        texto = t;
    }

}
