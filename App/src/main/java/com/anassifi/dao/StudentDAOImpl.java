package com.anassifi.dao;

import com.anassifi.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query query = session.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public void saveStudent(Student theStudent) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theStudent);
    }

    @Override
    public Student getStudent(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student theStudent = currentSession.get(Student.class, theId);
        return theStudent;
    }

    @Override
    public void deleteStudent(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Student sd = session.byId(Student.class).load(theId);
        session.delete(sd);
    }
}
