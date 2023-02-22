package social_network.domain;

import java.io.Serializable;

public class Entity<ID> implements Serializable {
    private static final long serialVersionUID = 73311534125924861L;

    private ID id;

    /**
     * Getter for ID.
     * 
     * @return
     */
    public ID getId() {
        return id;
    }

    /**
     * Setter for ID.
     * 
     * @param id
     */
    public void setId(ID id) {
        this.id = id;
    }
}
