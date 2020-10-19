package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Order;
import br.com.codeburger.codeburger.model.Sandwich;
import javafx.scene.SnapshotParameters;
import javassist.NotFoundException;

import java.util.List;

public interface SandwichService {
    public List<Sandwich> findAll();

    public Sandwich findById(Long id) throws NotFoundException;

    public Sandwich create(Sandwich sandwich);

    public Sandwich update(Sandwich sandwich);

    public void delete(Long id);
}
