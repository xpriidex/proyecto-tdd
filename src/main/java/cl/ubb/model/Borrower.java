package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
@Entity
public class Borrower {

    private String rut;
    private String name;
    private String cellPhone;
    private String email;

    public Borrower() {
    }

    public Borrower(String rut, String name, String cellPhone, String email) {
        this.rut = rut;
        this.name = name;
        this.cellPhone = cellPhone;
        this.email = email;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
