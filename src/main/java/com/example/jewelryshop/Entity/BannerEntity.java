package com.example.jewelryshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(schema = "banner_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat
    private LocalDate initializeDate;

    private Byte[] image;

    @OneToOne
    @JoinColumn(
            name = "item_id"
    )
    private ItemEntity item;
}
