package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.FarmOrder;
import com.spring.boot.springbootcontrolleradvice.Model.Item;
import com.spring.boot.springbootcontrolleradvice.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@Valid @RequestBody FarmOrder farmOrder) {
        orderService.addOrder(farmOrder);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order added successfully"));
    }


    @GetMapping("/list")
    public ResponseEntity<List<FarmOrder>> getOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
    }


    @PutMapping("/update/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer orderId,
                                         @Valid @RequestBody FarmOrder farmOrder) {

        orderService.updateOrder(orderId, farmOrder);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order updated successfully"));

    }


    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {

        orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order deleted successfully"));

    }

    // Extra #6
    @GetMapping("/filter/pending/{farmerId}")
    public ResponseEntity<?> getPendingOrders(@PathVariable Integer farmerId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getPendingOrders(farmerId));
    }

    // the item contains the orderId
    // Extra #14
    @PostMapping("/add/item")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
        orderService.addItem(item);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Item added successfully"));
    }


    @GetMapping("/list/items/{orderId}")
    public ResponseEntity<List<Item>> getItems(@PathVariable Integer orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getItems(orderId));
    }

    // Extra #15
    @PutMapping("/update/item/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable Integer itemId,
                                        @Valid @RequestBody Item item) {

        orderService.updateItem(itemId, item);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Item updated successfully"));

    }


    // Extra 12
    @DeleteMapping("/delete/item/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer itemId) {

        orderService.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Item deleted successfully"));

    }

    // Extra #7
    @PutMapping("/confirm/{orderId}/{farmerId}")
    public ResponseEntity<?> confirmOrder(@PathVariable Integer orderId, @PathVariable Integer farmerId){
        orderService.confirmOrder(orderId, farmerId);

        return ResponseEntity.status(HttpStatus.OK).body(new
                ApiResponse("Order confirmed successfully and stock updated"));
    }

    // Extra #8
    @PutMapping("/cancel/{orderId}/{farmerId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Integer orderId, @PathVariable Integer farmerId){
        orderService.cancelOrder(orderId,farmerId);

        return ResponseEntity.status(HttpStatus.OK).body(new
                ApiResponse("Order canceled successfully and stock updated"));
    }
    // Extra #9
    @PutMapping("/deliver/{orderId}/{farmerId}")
    public ResponseEntity<?> markDelivered(@PathVariable Integer orderId, @PathVariable Integer farmerId){
        orderService.markDelivered(orderId,farmerId);

        return ResponseEntity.status(HttpStatus.OK).body(new
                ApiResponse("Order marked delivered successfully"));
    }

    // Extra #10
    @GetMapping("/order-history/{buyerId}")
    public ResponseEntity<?> getOrderHistory(@PathVariable Integer buyerId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getBuyerOrders(buyerId));
    }

    // Extra #11
    @GetMapping("/sale-summary/{farmerId}")
    public ResponseEntity<?> getFarmerSalesSummary(@PathVariable Integer farmerId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getFarmerSalesSummary(farmerId));
    }
}
