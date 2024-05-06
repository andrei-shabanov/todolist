package api;

public class Aufgabe {

    private long aufgabe;
    private String name;
    private String date;
    private boolean uncompleted;

    public Aufgabe(long aufgabe, String name, String date, boolean uncompleted) {
        this.aufgabe = aufgabe;
        this.name = name;
        this.date = date;
        this.uncompleted = uncompleted;
    }

    public long getTask() {
        return aufgabe;
    }

    public void setTask(long task) {
        this.aufgabe = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isUncompleted() {
        return uncompleted;
    }

    public void setUncompleted(boolean uncompleted) {
        this.uncompleted = uncompleted;
    }

}
