package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.Farmer;
import com.spring.boot.springbootcontrolleradvice.Service.FarmerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/farmer")
@RequiredArgsConstructor
public class FarmerController {
    private final FarmerService farmerService;

    @PostMapping("/add")
    public ResponseEntity<?> addFarmer(@Valid @RequestBody Farmer farmer) {
        farmerService.addFarmer(farmer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Farmer added successfully"));
    }


    @GetMapping("/list")
    public ResponseEntity<List<Farmer>> getFarmers() {
        return ResponseEntity.status(HttpStatus.OK).body(farmerService.getFarmers());
    }


    @PutMapping("/update/{farmerId}")
    public ResponseEntity<?> updateFarmer(@PathVariable Integer farmerId,
                                          @Valid @RequestBody Farmer farmer) {

        farmerService.updateFarmer(farmerId, farmer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Farmer updated successfully"));

    }


    @DeleteMapping("/delete/{farmerId}")
    public ResponseEntity<?> deleteFarmer(@PathVariable Integer farmerId) {

        farmerService.deleteFarmer(farmerId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Farmer deleted successfully"));

    }
}
