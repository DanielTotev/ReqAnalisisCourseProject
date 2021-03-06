/*
 * This code has been generated by the Rebel: a code generator for modern Java.
 *
 * Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
 */
package org.pu.fmi.requirement.engineering.model;


import java.util.Objects;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return username != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}