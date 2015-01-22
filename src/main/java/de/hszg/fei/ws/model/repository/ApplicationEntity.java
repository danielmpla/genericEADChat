package de.hszg.fei.ws.model.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Daniel on 22.01.2015.
 */
@Entity
@Table(name = "application")
public class ApplicationEntity {
    @Id
    private Long id;
    private String uri;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationEntity applicationEntity = (ApplicationEntity) o;

        if (id != null ? !id.equals(applicationEntity.id) : applicationEntity.id != null) return false;
        if (name != null ? !name.equals(applicationEntity.name) : applicationEntity.name != null) return false;
        if (uri != null ? !uri.equals(applicationEntity.uri) : applicationEntity.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
