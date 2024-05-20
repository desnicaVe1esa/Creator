package app.back.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "home_practice")
    private String publicationDate;

    @Column(name = "info")
    private String info;

    public Work() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work that = (Work) o;
        return id.equals(that.id) && publicationDate.equals(that.publicationDate) && info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publicationDate, info);
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", publicationDate='" + publicationDate + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
