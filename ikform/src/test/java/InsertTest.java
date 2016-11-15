
import entities.AbstractEntity;
import entities.Admin;
import entities.Education;
import entities.EntityA;
import entities.User;
import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public class InsertTest {

    Configuration cfg;
    private final SessionFactory sessionFactory;
    private final Session session;

    public InsertTest() {
        cfg = new Configuration().addResource("hibernate.cfg.xml").configure();
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void downloadAndInsertEstate() {

        EntityA entityA = new EntityA();

        session.beginTransaction();
        session.save(entityA);
        session.getTransaction().commit();
    }

    @After
    public void tearDown() {
        session.close();
        sessionFactory.close();
    }

}
