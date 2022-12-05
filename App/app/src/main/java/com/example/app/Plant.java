package com.example.app;

public class Plant {
    private String name;
    private String type;
    private String bday;

    Plant(String name, String type, String bday) {
        this.name = name;
        this.type = type;
        this.bday = bday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }
}
