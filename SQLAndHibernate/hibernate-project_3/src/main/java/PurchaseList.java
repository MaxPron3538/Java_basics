import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseId id;

    @Column(name = "student_name",insertable = false,updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false,updatable = false)
    private String courseName;

    @Column(name = "price")
    private int price;

    @Column(name = "subscription_date",columnDefinition = "DATETIME")
    private Date subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public PurchaseId getId() {
        return id;
    }
}
