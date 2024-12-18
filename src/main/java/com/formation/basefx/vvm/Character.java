package com.formation.basefx.vvm;

public class Character {
    private String firstname;
    private String lastname;
    private int age;

    public Character(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Character() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Character other = (Character) obj;
        if (age != other.age) return false;
        if (lastname == null) {
            if (other.lastname != null) return false;
        } else if (!lastname.equals(other.lastname)) {
            return false;
        }
        if (firstname == null) {
            if (other.firstname != null) return false;
        } else if (!firstname.equals(other.firstname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne [nom = " + lastname + ", prénom = " + firstname + ", âge = " + age + "]";
    }
}
