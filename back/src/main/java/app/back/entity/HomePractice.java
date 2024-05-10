package app.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "home_practice")
public class HomePractice {
    @Id
    private Long id;

    @Column(name = "info")
    private String info;

    public HomePractice() {

    }

    public Long getId() {
        return id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomePractice that = (HomePractice) o;
        return Objects.equals(id, that.id) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info);
    }

    @Override
    public String toString() {
        return "HomePractice{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
