package pl.michal.SpendingTracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michal.SpendingTracker.model.Operation;
import pl.michal.SpendingTracker.service.OperationService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @GetMapping("")
    public List<Operation> getOperations(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        return operationService.getOperations(year, month);
    }

    @GetMapping("/{id}")
    public Operation getSingleOperation(@PathVariable long id) {
        return operationService.getSingleOperation(id);
    }

    @GetMapping("/balance")
    public BigDecimal getBalance(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        return operationService.getBalance(year, month);
    }

    @PostMapping("")
    public Operation addOperations(@RequestBody Operation operation) {
        return operationService.addOperation(operation);
    }

    @PutMapping("/{id}")
    public Operation updateOperation(@PathVariable long id, @RequestBody Operation updatedOperation) {
        return operationService.updateOperation(id, updatedOperation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable long id) {
        operationService.deleteOperation(id);
    }
}