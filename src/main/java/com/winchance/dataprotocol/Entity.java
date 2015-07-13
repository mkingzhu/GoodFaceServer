package com.winchance.dataprotocol;

public class Entity<T> {
    private String id;

    private T model;

    public Entity() {
    }

    public Entity(T model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
