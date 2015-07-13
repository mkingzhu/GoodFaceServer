package com.winchance.wechat.goodface.server.web;

import java.lang.reflect.Type;

import org.restlet.data.CharacterSet;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;

import com.winchance.util.GsonConvertor;

public class GsonRepresentation extends StringRepresentation {
    public GsonRepresentation(Object obj) {
        super(GsonConvertor.toJson(obj), MediaType.APPLICATION_JSON);
        this.setCharacterSet(CharacterSet.UTF_8);
    }

    public GsonRepresentation(Object obj, Type type) {
        super(GsonConvertor.toJson(obj, type), MediaType.APPLICATION_JSON);
        this.setCharacterSet(CharacterSet.UTF_8);
    }
}
