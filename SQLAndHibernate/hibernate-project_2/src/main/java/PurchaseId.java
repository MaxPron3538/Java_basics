import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PurchaseId implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int hashCode(){
        return (1636 + Integer.valueOf(studentName).hashCode() + Integer.valueOf(courseName).hashCode())/32;
    }

    @Override
    public boolean equals(Object object){
        if(this == object || this.equals(object) ){
            return true;
        }
        if(object == null || this.getClass() != object.getClass()){
            return  false;
        }
        return false;
    }
}
