package pl.michal.SpendingTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long category_id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private BigDecimal amount;
    private LocalDate created;
    private String description;
}
