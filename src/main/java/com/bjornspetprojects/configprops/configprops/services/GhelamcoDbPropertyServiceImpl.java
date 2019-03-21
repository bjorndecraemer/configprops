package com.bjornspetprojects.configprops.configprops.services;

import com.bjornspetprojects.configprops.configprops.entities.GhelamcoDbPropertyEntity;
import com.bjornspetprojects.configprops.configprops.repositories.GhelamcoDbPropertyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Service
public class GhelamcoDbPropertyServiceImpl implements GhelamcoPropertyService {

    private final GhelamcoDbPropertyRepository ghelamcoDbPropertyRepository;
    private Boolean valuesInitialized = false;
    private HashMap<String,String> props;

    public GhelamcoDbPropertyServiceImpl(GhelamcoDbPropertyRepository ghelamcoDbPropertyRepository) {
        this.ghelamcoDbPropertyRepository = ghelamcoDbPropertyRepository;
    }
    @PostConstruct
    private void initValues(){
        this.props = new HashMap<>();
        List<GhelamcoDbPropertyEntity> dbPropsList = ghelamcoDbPropertyRepository.findAll();
        if(dbPropsList == null || dbPropsList.isEmpty()){
            return;
        }
        dbPropsList.forEach(prop -> props.put(prop.getPropertyName(),prop.getPropertyValue()));
    }

    @Override
    public String findPropertyValueByName(String name) {
        if(!valuesInitialized){
            initValues();
        }
        return props.get(name);
    }
}
