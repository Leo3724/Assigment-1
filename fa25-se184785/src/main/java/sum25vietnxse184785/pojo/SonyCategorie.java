package sum25vietnxse184785.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SonyCategories")
public class SonyCategorie {

    @Id
    @Column(name = "CateID", nullable = false)
    private Integer cateID;

    @Column(name = "CateName", length = 50)
    private String cateName;

    @Column(name = "Status", length = 10)
    private String status;

    public SonyCategorie() {
    }

    public SonyCategorie(Integer cateID, String cateName, String status) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.status = status;
    }

    // Getter & Setter
    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
