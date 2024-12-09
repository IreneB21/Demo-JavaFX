package com.formation.basefx.vvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Notre classe d'accès aux données des personnages
public class CharacterDAO {

    /*
    Méthode qui renvoie une liste de personnages. Dans une vraie application, cette méthode devrait
    requérir une base de données ou un fichier de données externes. Dans notre cas, nous nous contentons de retourner
    une liste de personnages instanciés dans la méthode.
     */
    public List<Character> getCharacters() {
        // On instancie une liste de personnages
        List<Character> characters = new ArrayList<>();

        // On instancie des personnages
        Character oberyn = new Character("Oberyn", "Martell", 37);
        Character doran = new Character("Doran", "Martell", 41);
        Character ellia = new Character("Ellia", "Martell", 28);
        Character trystan = new Character("Trystan", "Martell", 23);

        // On les ajoute à notre liste de personnages
        Collections.addAll(characters, oberyn, doran, ellia, trystan);

        // On retourne la liste
        return characters;
    }
}
