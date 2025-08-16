package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.Plant;
import com.spring.boot.springbootcontrolleradvice.Service.PlantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @PostMapping("/add")
    public ResponseEntity<?> addPlant(@Valid @RequestBody Plant plant) {
        plantService.addPlant(plant);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Plant added successfully"));
    }


    @GetMapping("/list")
    public ResponseEntity<List<Plant>> getPlants() {
        return ResponseEntity.status(HttpStatus.OK).body(plantService.getPlants());
    }


    @PutMapping("/update/{plantId}")
    public ResponseEntity<?> updatePlant(@PathVariable Integer plantId,
                                         @Valid @RequestBody Plant plant) {

        plantService.updatePlant(plantId, plant);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Plant updated successfully"));

    }


    @DeleteMapping("/delete/{plantId}")
    public ResponseEntity<?> deletePlant(@PathVariable Integer plantId) {

        plantService.deletePlant(plantId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Plant deleted successfully"));

    }

    // Extra #1
    @GetMapping("filter/plants/in-stock/{farmerId}")
    public ResponseEntity<?> getInStockPlants(@PathVariable Integer farmerId) {
        return ResponseEntity.status(HttpStatus.OK).body(plantService.getAllAvailablePlants(farmerId));
    }

    // Extra #2
    @GetMapping("filter/plants/out-of-stock/{farmerId}")
    public ResponseEntity<?> getOutOfStockPlants(@PathVariable Integer farmerId) {
        return ResponseEntity.status(HttpStatus.OK).body(plantService.getAllUnavailablePlants(farmerId));
    }

    // Extra #3
    @PutMapping("/increase-stock/{farmerId}/{plantId}/{stockAmount}")
    public ResponseEntity<?> increaseStock(
            @PathVariable Integer farmerId,
            @PathVariable Integer plantId,
            @PathVariable Integer stockAmount) {

        plantService.increaseStock(farmerId, plantId, stockAmount);
        return ResponseEntity.status(HttpStatus.OK).body(new
                ApiResponse(" increased by " + stockAmount + " successfully"));
    }

    // Extra #4
    @PutMapping("/decrease-stock/{farmerId}/{plantId}/{stockAmount}")
    public ResponseEntity<?> decrease(
            @PathVariable Integer farmerId,
            @PathVariable Integer plantId,
            @PathVariable Integer stockAmount) {

        plantService.decreaseStock(farmerId, plantId, stockAmount);
        return ResponseEntity.status(HttpStatus.OK).body(new
                ApiResponse(" decreased by " + stockAmount + " successfully"));
    }

    // Extra #5
    @GetMapping("/filter/price/between/{minPrice}/{maxPrice}/{farmerId}")
    public ResponseEntity<?> getPlantsWithinPriceRange(@PathVariable Integer farmerId,
                                                       @PathVariable Double minPrice,
                                                       @PathVariable Double maxPrice) {

        return ResponseEntity.status(HttpStatus.OK).body(
                plantService.getPlantsWithinPriceRange(farmerId, minPrice, maxPrice));
    }

    // Extra #13
    @GetMapping("/similar-sellers/{plantId}")
    public ResponseEntity<?> getFarmersSellingPlant(@PathVariable Integer plantId) {
        return ResponseEntity.status(HttpStatus.OK).body(plantService.getFarmersSellingPlant(plantId));
    }
}
