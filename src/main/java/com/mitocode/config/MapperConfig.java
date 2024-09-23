package com.mitocode.config;

import com.mitocode.dto.MedicDTO;
import com.mitocode.model.Medic;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    @Primary  // Si prefieres hacer este el predeterminado
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean("medicMapper")
    public ModelMapper medicMapper(){
        ModelMapper mapper = new ModelMapper();

        // Mapeo de DTO a entidad (de MedicDTO a Medic)
        TypeMap<MedicDTO, Medic> typeMap1 = mapper.createTypeMap(MedicDTO.class, Medic.class);
        typeMap1.addMapping(MedicDTO::getPrimaryName, Medic::setFirstName);
        typeMap1.addMapping(MedicDTO::getSurname, Medic::setLastName);
        typeMap1.addMapping(MedicDTO::getCmpMedic, Medic::setCmp);
        typeMap1.addMapping(MedicDTO::getPhoto, Medic::setPhotoUrl);
    
    
    
        // Mapeo de entidad a DTO (de Medic a MedicDTO)
        TypeMap<Medic, MedicDTO> typeMap2 = mapper.createTypeMap(Medic.class, MedicDTO.class);
        typeMap2.addMapping(Medic::getFirstName, MedicDTO::setPrimaryName);
        typeMap2.addMapping(Medic::getLastName, MedicDTO::setSurname);
        typeMap2.addMapping(Medic::getCmp, MedicDTO::setCmpMedic);
        typeMap2.addMapping(Medic::getPhotoUrl, MedicDTO::setPhoto);
    
        return mapper;
    }
}
