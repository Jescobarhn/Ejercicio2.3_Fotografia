package com.example.ejercicio23_fotografia.configuracion;

public class Foto {

    //VARIABLES A UTILIZAR
    private String id = "Id";

    private String photo = "photo";

    private String description = "description";

    public Foto(String id, String photo, String description) {
        this.id = id;
        this.photo = photo;
        this.description = description;
    }


    public Foto() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
