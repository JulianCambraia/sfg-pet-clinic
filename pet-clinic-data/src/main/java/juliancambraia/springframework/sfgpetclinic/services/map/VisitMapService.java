package juliancambraia.springframework.sfgpetclinic.services.map;

import juliancambraia.springframework.sfgpetclinic.model.Visit;
import juliancambraia.springframework.sfgpetclinic.services.VisitService;

import java.util.Set;

/**
 * @author juliancambraia
 */

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final VisitService visitService;

    public VisitMapService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit!");
        }

        return visitService.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}