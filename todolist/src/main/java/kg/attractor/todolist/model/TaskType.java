package kg.attractor.todolist.model;

public enum TaskType {
    NEW, WORK, COMPLETED;
    @Override
    public String toString() {
        return name().toLowerCase();
    }




}
