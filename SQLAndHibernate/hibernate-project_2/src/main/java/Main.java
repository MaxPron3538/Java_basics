import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.internal.MetadataImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Teacher> criteriaTeacher = builder.createQuery(Teacher.class);
        criteriaTeacher.from(Teacher.class);

        List<Teacher> teachers1 = session.createQuery(criteriaTeacher).getResultList();
        List<Student> students1 = teachers1.get(1).getCourses().stream().map(s -> s.getSubscriptions())
                .flatMap(List::stream).distinct().map(s -> s.getStudent()).collect(Collectors.toList());
        students1.forEach(s -> System.out.println(s.getName()));

        CriteriaQuery<Student> criteriaStudent = builder.createQuery(Student.class);
        criteriaStudent.from(Student.class);

        List<Student> students2 = session.createQuery(criteriaStudent).getResultList();
        List<Teacher> teachers2 = students2.get(1).getSubscriptions().stream().map(s -> s.getCourse().getTeacher()).collect(Collectors.toList());
        teachers2.forEach(s -> System.out.println(s.getName()));

        Subscription subscription = session.get(Subscription.class,new Key(1,2));
        Teacher teacher = subscription.getCourse().getTeacher();
        System.out.println(teacher.getName());

        sessionFactory.close();
    }
}
