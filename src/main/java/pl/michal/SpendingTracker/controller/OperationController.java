package pl.michal.SpendingTracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michal.SpendingTracker.model.Operation;
import pl.michal.SpendingTracker.service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @GetMapping("")
    public List<Operation> getOperations() {
        return operationService.getOperations();
    }

    @GetMapping("/{id}")
    public Operation getSingleOperation(@PathVariable long id) {
        return operationService.getSingleOperation(id);
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
