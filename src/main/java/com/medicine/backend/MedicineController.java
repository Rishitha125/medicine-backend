package com.medicine.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin(origins = "http://localhost:5173")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    // Add new medicine
    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // Get all medicines
    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // Update medicine
    @PutMapping("/{id}")
    public Medicine updateMedicine(
            @PathVariable Long id,
            @RequestBody Medicine medicineDetails) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setName(medicineDetails.getName());
        medicine.setCategory(medicineDetails.getCategory());
        medicine.setPrice(medicineDetails.getPrice());
        medicine.setExpiryDate(medicineDetails.getExpiryDate());
        medicine.setAvailableStock(medicineDetails.getAvailableStock());

        return medicineRepository.save(medicine);
    }

    // Delete medicine
    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long id) {

        medicineRepository.deleteById(id);

        return "Medicine deleted successfully";
    }
}