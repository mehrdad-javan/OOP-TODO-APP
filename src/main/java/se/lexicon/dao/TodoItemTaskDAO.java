package se.lexicon.dao;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItemTask;

import java.util.List;

public interface TodoItemTaskDAO {

  TodoItemTask persist(TodoItemTask todoItemTask);
  TodoItemTask findById(int id);
  List<TodoItemTask> findAll();
  List<TodoItemTask> findByAssignedStatus(boolean assignedStatus);
  List<TodoItemTask> findByPersonId(int id);
  TodoItemTask addAssignee(int idTask, Person person);
  TodoItemTask removeAssignee(int idTask);
  void remove(int id);

}
