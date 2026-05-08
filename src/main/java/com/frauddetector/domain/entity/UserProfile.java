package com.frauddetector.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Builder.Default
    private BigDecimal avgTransactionAmount = BigDecimal.ZERO;

    @Builder.Default
    private BigDecimal stdDevAmount = BigDecimal.ZERO;

    @Builder.Default
    private Integer totalTransactions = 0;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;




}
