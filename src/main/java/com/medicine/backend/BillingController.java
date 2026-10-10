package com.medicine.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://moonlit-zuccutto-1672ce.netlify.app"
})
public class BillingController {

    @Autowired
    private MedicineRepository medicineRepository;

    @PostMapping
    public BillingResponse createBill(@RequestBody BillingRequest request) {

        Medicine medicine = medicineRepository
                .findByNameIgnoreCase(request.getMedicineName())
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        int requestedQuantity = request.getQuantity();

        if (requestedQuantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        if (requestedQuantity > medicine.getAvailableStock()) {
            throw new RuntimeException("Not enough stock available");
        }

        double pricePerTablet = medicine.getPrice();

        double totalAmount = requestedQuantity * pricePerTablet;

        int remainingStock =
                medicine.getAvailableStock() - requestedQuantity;

        medicine.setAvailableStock(remainingStock);

        medicineRepository.save(medicine);

        return new BillingResponse(
                medicine.getName(),
                medicine.getCategory(),
                requestedQuantity,
                pricePerTablet,
                totalAmount,
                remainingStock
        );
    }
}