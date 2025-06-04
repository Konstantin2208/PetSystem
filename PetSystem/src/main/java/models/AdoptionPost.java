package models;

public class AdoptionPost {
    private String title;
    private String description;
    private String status;
    private User owner;

    public AdoptionPost(String title, String description, User owner) {
        this.title = title;
        this.description = description;
        this.status = "pending";
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
