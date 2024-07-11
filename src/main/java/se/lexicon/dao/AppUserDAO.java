package se.lexicon.dao;

import se.lexicon.model.AppUser;

import java.util.List;

public interface AppUserDAO {

  AppUser persist(AppUser appUser);
  AppUser findByUsername(String username);
  List<AppUser> findAll();
  void remove(String username);

}
