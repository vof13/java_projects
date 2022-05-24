import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    private static List<Student> studentList;
    private static List<Course> courseList;
    private static List<Purchaselist> purchaseList;
    private static List<LinkedPurchaseList> linkedPurchaseList;

    public static void main(String[] args)  {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Purchaselist> purchaselistQuery = builder.createQuery(Purchaselist.class);
        Root<Purchaselist> purchaseListRoot = purchaselistQuery.from(Purchaselist.class);
        purchaselistQuery.select(purchaseListRoot);

        CriteriaQuery<Student> studentCriteriaQuery = builder.createQuery(Student.class);
        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);
        studentCriteriaQuery.select(studentRoot);

        CriteriaQuery<Course> courseCriteriaQuery = builder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
        courseCriteriaQuery.select(courseRoot);

        CriteriaQuery<LinkedPurchaseList> linkedPurchaseListCriteriaQuery = builder.createQuery(LinkedPurchaseList.class);
        Root<LinkedPurchaseList> linkedPurchaseListRoot = linkedPurchaseListCriteriaQuery.from(LinkedPurchaseList.class);
        linkedPurchaseListCriteriaQuery.select(linkedPurchaseListRoot);

        purchaseList = session.createQuery(purchaselistQuery).getResultList();
        studentList = session.createQuery(studentCriteriaQuery).getResultList();
        courseList = session.createQuery(courseCriteriaQuery).getResultList();
        linkedPurchaseList = session.createQuery(linkedPurchaseListCriteriaQuery).getResultList();

//      очистка таблицы для тестирования
//        deleteAllInLinkedPurchaseList(session);
        createLinkedPurchaseList(session);
        sessionFactory.close();
    }

    private static void deleteAllInLinkedPurchaseList(Session session) {

        for (LinkedPurchaseList linkedPurchase:
                linkedPurchaseList) {
            session.beginTransaction();
            session.delete(linkedPurchase);
            session.getTransaction().commit();
        }



    }

    private static void createLinkedPurchaseList(Session session) {
        for (Purchaselist purchase:
                purchaseList) {
            session.beginTransaction();
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList(new Key());
            linkedPurchase.getId().setStudentId(findIdStudentByName(purchase.getId().getStudentName()));
            linkedPurchase.getId().setCourseId(findIdCourseByName(purchase.getId().getCourseName()));
            session.save(linkedPurchase);
            session.getTransaction().commit();
        }
    }

    private static int findIdCourseByName(String courseName) {
        for (Course course:
                courseList) {
            if (courseName.equals(course.getName())) {
                return course.getId();
            }
        }
        return 0;
    }

    private static int findIdStudentByName(String studentName) {
        for (Student student:
                studentList) {
            if (studentName.equals(student.getName())) {
                return student.getId();
            }
        }
        return 0;
    }

}


