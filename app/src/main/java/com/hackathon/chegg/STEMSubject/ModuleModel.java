package com.hackathon.chegg.STEMSubject;

public class ModuleModel {
    String name,model,wikiname;

    public ModuleModel(String name, String model, String wikiname) {
        this.name = name;
        this.model = model;
        this.wikiname = wikiname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWikiname() {
        return wikiname;
    }

    public void setWikiname(String wikiname) {
        this.wikiname = wikiname;
    }
}
