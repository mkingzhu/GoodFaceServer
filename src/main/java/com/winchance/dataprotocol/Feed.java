package com.winchance.dataprotocol;

import java.util.ArrayList;
import java.util.List;

public class Feed<T> {
    private String id;

    private List<Entity<T>> entities = new ArrayList<Entity<T>>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Entity<T>> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity<T>> entities) {
        this.entities = entities;
    }
}
