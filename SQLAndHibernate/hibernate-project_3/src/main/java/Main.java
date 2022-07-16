import com.mysql.cj.xdevapi.SqlResult;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<PurchaseList> criteria = builder.createQuery(PurchaseList.class);
        criteria.from(PurchaseList.class);

        List<PurchaseList> listPurchase = session.createQuery(criteria).getResultList();

        Map<String,Integer> mapLinkedPurchaseStudent = new HashMap<>();
        Map<String,Integer> mapLinkedPurchaseCourse = new HashMap<>();

        int countStudent = 1,countCourse = 1;

        session.beginTransaction();

        for(PurchaseList purchase : listPurchase){
            LinkedPurchaseList purchaseList = new LinkedPurchaseList();

            if(mapLinkedPurchaseStudent.get(purchase.getId().getStudentName()) != null) {
                purchaseList.setId(new Key(mapLinkedPurchaseStudent.get(purchase.getId().getStudentName()),countCourse));
                session.save(purchaseList);
                countCourse++;
                continue;
            }
            if(mapLinkedPurchaseCourse.get(purchase.getId().getCourseName()) != null) {
                purchaseList.setId(new Key(countStudent,mapLinkedPurchaseCourse.get(purchase.getId().getCourseName())));
                session.save(purchaseList);
                countStudent++;
                continue;
            }
            mapLinkedPurchaseStudent.put(purchase.getId().getStudentName(), countStudent);
            mapLinkedPurchaseCourse.put(purchase.getId().getCourseName(),countCourse);

            purchaseList.setId(new Key(countStudent, countCourse));
            session.save(purchaseList);
            countStudent++;
            countCourse++;
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
