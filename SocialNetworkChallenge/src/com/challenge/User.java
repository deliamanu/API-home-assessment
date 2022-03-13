package com.challenge;

/**
 * This class represents a user in a social network with a name
 *  **/
public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function check if a user is equal with another object. If the object is the type user,
     * it verifies if the name are the same.
     * @param obj
     * @return true, if the user is equal with the object, false else
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }

        User other = (User) obj;
        if(this.name == null || other.getName() == null) {
            return false;
        } else if(!this.name.equals(other.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 8;
        hash = 43 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.name;
    }
}