package com.alejandrobr.petclinic.services.map;

import com.alejandrobr.petclinic.model.Specialty;
import com.alejandrobr.petclinic.model.Vet;
import com.alejandrobr.petclinic.services.SpecialtyService;
import com.alejandrobr.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty ->{
                if(specialty.getId()==null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            } );
        }
        return super.save( object);
    }
}
