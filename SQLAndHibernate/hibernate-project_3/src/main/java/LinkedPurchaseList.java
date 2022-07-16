import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseId id;

    @Column(name = "student_id",insertable = false,updatable = false)
    private int studentId;

    @Column(name = "course_id",insertable = false,updatable = false)
    private int courseId;

    public LinkedPurchaseId getId() {
        return id;
    }

    public void setId(LinkedPurchaseId id) {
        this.id = id;
    }
}
