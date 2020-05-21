package com.trello.mobile.model;

public class GroupData {
    private  String name;
    private  String type;
    private  String descriptions;

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withType(String type) {
        this.type = type;
        return this;
    }

    public GroupData withDescriptions(String descriptions) {
        this.descriptions = descriptions;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescriptions() {
        return descriptions;
    }
}
