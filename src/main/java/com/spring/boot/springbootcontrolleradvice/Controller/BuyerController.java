package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.Buyer;
import com.spring.boot.springbootcontrolleradvice.Service.BuyerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;

    @PostMapping("/add")
    public ResponseEntity<?> addBuyer(@Valid @RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Buyer added successfully"));
    }


    @GetMapping("/list")
    public ResponseEntity<List<Buyer>> getBuyers() {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.getBuyers());
    }


    @PutMapping("/update/{buyerId}")
    public ResponseEntity<?> updateBuyer(@PathVariable Integer buyerId,
                                         @Valid @RequestBody Buyer buyer) {

        buyerService.updateBuyer(buyerId, buyer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Buyer updated successfully"));

    }


    @DeleteMapping("/delete/{buyerId}")
    public ResponseEntity<?> deleteBuyer(@PathVariable Integer buyerId) {

        buyerService.deleteBuyer(buyerId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Buyer deleted successfully"));

    }

}
