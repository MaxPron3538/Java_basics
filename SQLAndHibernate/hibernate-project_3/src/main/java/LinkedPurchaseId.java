import jakarta.persistence.Column;

import java.io.Serializable;

public class LinkedPurchaseId implements Serializable {
    public LinkedPurchaseId(){}

    public LinkedPurchaseId(int studentId, int courseId){
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode(){
        return (1435 + Integer.valueOf(courseId).hashCode() + Integer.valueOf(studentId).hashCode())/35;
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
