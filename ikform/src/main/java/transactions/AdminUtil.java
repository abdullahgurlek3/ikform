/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions;

import dao.MySessionFactory;
import entities.Admin;
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
public class AdminUtil {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    @Autowired
    AdminSession adminSession;

    public AdminState loginAdmin(String username, String password) {
        Session session = mySessionFactoryInstance.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Admin admin = (Admin) session.createCriteria(Admin.class)
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password)).uniqueResult();
        session.getTransaction().commit();;
        
        if (admin == null) {
            return AdminState.IDNOTDEFINED;
        } else {
            if (!admin.isIsActivated()) {
                return AdminState.NOTACTIVATED;
            }
            if (adminSession.getAdmin() == null) {
                adminSession.setAdmin(admin);
                return AdminState.LOGGING;
            } else {
                adminSession.setAdmin(admin);
                return AdminState.LOGIN;
            }
        }

    }

    public AdminState checkAdminSession() {
        if (adminSession.getAdmin() == null) {
            return AdminState.NOTLOGIN;
        } else {
            return AdminState.LOGIN;
        }
    }

    public AdminState checkAdminActivation(Long id, String key) {
        AdminState state = null;

        Session session = mySessionFactoryInstance.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Admin admin = (Admin) session.createCriteria(Admin.class)
                .add(Restrictions.eq("activationKey", key))
                .add(Restrictions.eq("id", id)).uniqueResult();

        if (admin == null) {
            state = AdminState.IDORKEYNOTDEFINED;
        } else {
            if (admin.isIsActivated()) {
                state = AdminState.ACTIVATED;
            } else {
                state = AdminState.BEINGACTIVE;
                admin.setIsActivated(true);
            }
        }

        session.getTransaction().commit();

        return state;
    }

    public AdminState logoutAdmin() {
        adminSession.setAdmin(null);
        return AdminState.NOTLOGIN;
    }
}
