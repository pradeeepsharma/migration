package pk.playground.model;

import java.util.Objects;

public class Custom {
    private String id;
    private String name;

    public Custom(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Custom)) return false;
        Custom custom = (Custom) o;
        return Objects.equals(id, custom.id) &&
                Objects.equals(name, custom.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
