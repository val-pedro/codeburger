package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Sandwich;
import br.com.codeburger.codeburger.repository.SandwichRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {

    private SandwichRepository sandwichRepository;

    @Autowired
    public SandwichServiceImpl(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    public List<Sandwich> findAll() {
        return (List<Sandwich>) this.sandwichRepository.findAll();
    }

    @Override
    public Sandwich findById(Long id) throws NotFoundException {
        return this.sandwichRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
    }

    @Override
    public Sandwich create(Sandwich sandwich) {
        return this.sandwichRepository.save(sandwich);
    }

    @Override
    public Sandwich update(Sandwich sandwich) {
        return this.sandwichRepository.save(sandwich);
    }

    @Override
    public void delete(Long id) {
        this.sandwichRepository.deleteById(id);
    }
}
