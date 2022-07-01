import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
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

    private static int jump = 2;

    public static void main(String[] args){

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteria = builder.createQuery(Teacher.class);
        criteria.from(Teacher.class);
        List<Teacher> teachers = session.createQuery(criteria).getResultList();

        Teacher teacher = teachers.get(9);
        List<Course> courses = teacher.getCourses();
        int base = courses.stream().mapToInt(s->s.getName().length()).max().orElse(0) + jump;

        for (Course c : courses){
            int off = base - c.getName().length();
            String tab = Arrays.stream(new String[off]).map(s -> "" + " ").collect(Collectors.joining());

            System.out.println(teacher.getName() + " | " + c.getName() + tab + "| " + c.getStudentsCount());
        }

        sessionFactory.close();

    }
}
