/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import dao.MySessionFactory;
import entities.Admin;
import entities.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sessions.AdminSession;
import util.AdminState;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Transactional
@Repository
public class InsertDatabase {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    @Autowired
    AdminSession adminSession;

    @Transactional
    public List getAll() {
        Session session = mySessionFactoryInstance.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        return list;
    }

    @Transactional
    public void insert(User user) {
        Session session = mySessionFactoryInstance.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Transactional
    public void addAdmin(Admin admin) {
        Session session = mySessionFactoryInstance.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
    }

}
