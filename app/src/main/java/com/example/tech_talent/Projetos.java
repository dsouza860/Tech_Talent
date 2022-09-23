package com.example.tech_talent;

public class Projetos {
    private String id;
    private String title;
    private String description;
    private String start_date;
    private String expected_end_date;
    private String amount_people;

    public Projetos() {

    }

    public Projetos(String id, String title, String description, String start_date, String expected_end_date, String amount_people) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.expected_end_date = expected_end_date;
        this.amount_people = amount_people;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getExpected_end_date() {
        return expected_end_date;
    }

    public void setExpected_end_date(String expected_end_date) {
        this.expected_end_date = expected_end_date;
    }

    public String getAmount_people() {
        return amount_people;
    }

    public void setAmount_people(String amount_people) {
        this.amount_people = amount_people;
    }

    @Override
    public String toString() {
        return "Projetos{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_date='" + start_date + '\'' +
                ", expected_end_date='" + expected_end_date + '\'' +
                ", amount_people='" + amount_people + '\'' +
                '}';
    }
}
