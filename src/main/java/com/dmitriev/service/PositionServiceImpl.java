package com.dmitriev.service;

import com.dmitriev.DAO.PositionDAO;
import com.dmitriev.entity.Position;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionDAO positionDAO;

    public PositionServiceImpl(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }


    @Override
    @Transactional
    public List<Position> getPositions() {
        return positionDAO.getPositions();
    }

    @Override
    @Transactional
    public void savePosition(Position position) {
        positionDAO.savePosition(position);
    }

    @Override
    @Transactional
    public Position getPosition(int id) {
        return positionDAO.getPosition(id);
    }

    @Override
    @Transactional
    public void deletePosition(int id) {
        positionDAO.deletePosition(id);
    }
}
