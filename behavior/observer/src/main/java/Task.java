public class Task {

    private String name = "";

    private String notes = "";

    private Double timeRequired = 0D;

    public Task() {
    }

    public Task(String name, String notes, Double timeRequired) {
        this.name = name;
        this.notes = notes;
        this.timeRequired = timeRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(Double timeRequired) {
        this.timeRequired = timeRequired;
    }

    @Override
    public String toString() {
        return name + " " + notes;
    }
}
