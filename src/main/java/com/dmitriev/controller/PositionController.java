package com.dmitriev.controller;

import com.dmitriev.entity.Position;
import com.dmitriev.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/positions")
    public List<Position> showAllPositions() {
        List<Position> allPositions = positionService.getPositions();
        return allPositions;
    }
    @GetMapping("/positions/{id}")
    public Position getPosition(@PathVariable int id) {
        Position position = positionService.getPosition(id);
        return position;
    }
    @PostMapping("/positions")
    public Position addNewPosition(@RequestBody Position position) {
        positionService.savePosition(position);
        return position;
    }
    @PutMapping("/positions")
    public Position updatePosition(@RequestBody Position position) {
        positionService.savePosition(position);
        return position;
    }
    @DeleteMapping("/positions/{id}")
    public String deletePosition(@PathVariable int id) {
        positionService.deletePosition(id);
        return "Position with id = " + id + " was deleted";
    }

}
