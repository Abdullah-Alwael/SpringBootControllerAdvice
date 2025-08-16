package com.spring.boot.springbootcontrolleradvice.Service;


import com.spring.boot.springbootcontrolleradvice.Api.ApiException;
import com.spring.boot.springbootcontrolleradvice.Model.Farmer;
import com.spring.boot.springbootcontrolleradvice.Repository.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmerService {
    private final FarmerRepository farmerRepository;

    public void addFarmer(Farmer farmer){
        farmerRepository.save(farmer);
    }

    public List<Farmer> getFarmers(){
        return farmerRepository.findAll();
    }

    public Farmer getFarmer(Integer farmerId){
        return farmerRepository.findFarmerById(farmerId);
    }

    public List<Farmer> getFarmersByIdIn(List<Integer> ids){
        return farmerRepository.findFarmersByIdIn(ids);
    }
    public void updateFarmer(Integer farmerId, Farmer farmer){
        Farmer oldFarmer = getFarmer(farmerId);

        if (oldFarmer == null){
            throw new ApiException("Error, farmer does not exist");
        }

        oldFarmer.setName(farmer.getName());
        oldFarmer.setAge(farmer.getAge());
        oldFarmer.setPhone(farmer.getPhone());
        oldFarmer.setEmail(farmer.getEmail());
        oldFarmer.setFarmName(farmer.getFarmName());
        oldFarmer.setLocation(farmer.getLocation());

        farmerRepository.save(oldFarmer);
    }

    public void deleteFarmer(Integer farmerId){
        Farmer oldFarmer = getFarmer(farmerId);

        if (oldFarmer == null){
            throw new ApiException("Error, farmer does not exist");
        }

        farmerRepository.delete(oldFarmer);
    }

    public Boolean doesNotExist(Integer farmerId){
        return !farmerRepository.existsById(farmerId);
    }
}
