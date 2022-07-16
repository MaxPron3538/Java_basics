import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private Key id;

    @Column(name = "student_id",insertable = false,updatable = false)
    private int studentId;

    @Column(name = "course_id",insertable = false,updatable = false)
    private int courseId;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }
}
