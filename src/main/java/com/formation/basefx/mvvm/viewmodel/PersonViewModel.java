package com.formation.basefx.mvvm.viewmodel;

import com.formation.basefx.mvvm.model.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonViewModel {

    private Person person;
    // Propriétés observables pour le nom et le prénom
    private StringProperty firstName;
    private StringProperty lastName;

    public PersonViewModel(Person person) {
        this.person = person;
        // Les propriétés observables sont liées aux valeurs initiales du modèle
        this.firstName = new SimpleStringProperty(person.getFirstName());
        this.lastName = new SimpleStringProperty(person.getLastName());
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void saveChanges() {
        // Les valeurs modifiées dans les propriétés sont enregistrées dans le modèle
        person.setFirstName(firstName.get());
        person.setLastName(lastName.get());
        System.out.println(person);
    }
}
