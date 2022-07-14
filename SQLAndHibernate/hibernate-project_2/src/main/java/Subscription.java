import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private Key id;

  @ManyToOne
  @JoinColumn(name = "course_id",insertable = false,updatable = false)
  private Course course;

  @ManyToOne
  @JoinColumn(name = "student_id",insertable = false,updatable = false)
  private Student student;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

  public Key getId() {
    return id;
  }

  public void setId(Key id) {
    this.id = id;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
