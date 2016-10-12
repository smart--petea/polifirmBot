package r.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="policompany")
public class PoliCompany {

    public PoliCompany(){}

    @Id
    @GeneratedValue
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    private String mail;
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    private String url;
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    private String phone;
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
