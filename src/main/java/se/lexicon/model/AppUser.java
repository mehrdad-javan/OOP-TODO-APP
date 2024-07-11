package se.lexicon.model;

import java.util.Objects;

public class AppUser {

  private String username;
  private String password;
  private AppRole role;

  public AppUser(String username, String password, AppRole role) {
    setUsername(username);
    setPassword(password);
    setRole(role);
  }

  public String getUsername() {
    return username;
  }

  /**
   * @param username unique String <b>Not null or blank</b>
   */
  public void setUsername(String username) {
    if (username == null || username.trim().isEmpty()) throw new IllegalArgumentException("username is null or empty.");
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  /**
   * @param password String representing AppUser password
   */
  public void setPassword(String password) throws IllegalArgumentException {
    if (password == null || password.trim().isEmpty()) throw new IllegalArgumentException("password is null or empty.");
    this.password = password;
  }

  public AppRole getRole() {
    return role;
  }

  public void setRole(AppRole role) {
    if (role == null) throw new IllegalArgumentException("role is null or empty.");

    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppUser appUser = (AppUser) o;
    return Objects.equals(username, appUser.username) && role == appUser.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, role);
  }

  @Override
  public String toString() {
    return "AppUser{" +
            "username='" + username + '\'' +
            ", role=" + role +
            '}';
  }
}