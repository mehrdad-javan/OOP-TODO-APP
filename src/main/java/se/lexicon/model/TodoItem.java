package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {

  private int id;
  private String title;
  private String description;
  private LocalDate deadLine;
  private boolean done;
  private Person creator;

  public TodoItem(int id, String title, String description, LocalDate deadLine, boolean done, Person creator) {
    this(title, description, deadLine, done, creator);
    this.id = id;
  }

  public TodoItem(String title, String description, LocalDate deadLine, boolean done, Person creator) {
    setTitle(title);
    setDescription(description);
    setDeadLine(deadLine);
    setDone(done);
    setCreator(creator);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title is null or empty.");
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(LocalDate deadLine) {
    if (deadLine == null) throw new IllegalArgumentException("deadLine is null.");
    this.deadLine = deadLine;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Person getCreator() {
    return creator;
  }

  public void setCreator(Person creator) {
    if (creator == null) throw new IllegalArgumentException("creator is null.");
    this.creator = creator;
  }

  public boolean isOverdue() {
    return LocalDate.now().isAfter(deadLine);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TodoItem todoItem = (TodoItem) o;
    return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadLine, todoItem.deadLine) && Objects.equals(creator, todoItem.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, deadLine, done, creator);
  }

  @Override
  public String toString() {
    return "TodoItem{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", deadLine=" + deadLine +
            ", done=" + done +
            ", creator=" + creator +
            ", isOverdue=" + isOverdue() +
            '}';
  }
}
