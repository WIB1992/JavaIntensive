package com.dmitriev.DAO;


import com.dmitriev.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public PositionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Position> getPositions() {
        Session session = sessionFactory.getCurrentSession();
        List<Position> allPositions = session.createQuery("select e from Position e", Position.class)
                .getResultList();
        return allPositions;

    }

    @Override
    public void savePosition(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(position);
    }

    @Override
    public Position getPosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Position.class, id);
    }

    @Override
    public void deletePosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Position.class,id));
    }
}
