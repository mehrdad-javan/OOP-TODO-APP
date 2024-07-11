package se.lexicon.dao;

import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemDAO {

  TodoItem persist(TodoItem todoItem);
  TodoItem findById(int id);
  List<TodoItem> findAll();
  List<TodoItem> findAllByDoneStatus(boolean doneStatus);
  List<TodoItem> findByTitleContains(String query);
  List<TodoItem> findByPersonId(int id);
  List<TodoItem> findByDeadlineBefore(LocalDate date);
  List<TodoItem> findByDeadlineAfter(LocalDate date);
  void remove(int id);

}
