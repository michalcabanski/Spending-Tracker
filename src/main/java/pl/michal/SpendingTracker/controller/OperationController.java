package pl.michal.SpendingTracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.michal.SpendingTracker.model.Operation;
import pl.michal.SpendingTracker.model.User;
import pl.michal.SpendingTracker.service.OperationService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/operations")
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @GetMapping("")
    public List<Operation> getOperations(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        return operationService.getOperations(user, year, month);
    }

    @GetMapping("/{id}")
    public Operation getSingleOperation(
            @AuthenticationPrincipal User user,
            @PathVariable long id
    ) {
        return operationService.getSingleOperation(user, id);
    }

    @GetMapping("/balance")
    public BigDecimal getBalance(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        return operationService.getBalance(user, year, month);
    }

    @PostMapping("")
    public Operation addOperations
            (@AuthenticationPrincipal User user,
             @RequestBody Operation operation
    ) {
        return operationService.addOperation(user, operation);
    }

    @PutMapping("/{id}")
    public Operation updateOperation(
            @AuthenticationPrincipal User user,
            @PathVariable long id,
            @RequestBody Operation updatedOperation
    ) throws Exception {
        return operationService.updateOperation(user, id, updatedOperation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(
            @AuthenticationPrincipal User user,
            @PathVariable long id
    ) throws Exception {
        operationService.deleteOperation(user, id);
    }
}
