package com.count.icount.Trade.Sell.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name="user_id")
    @JsonIgnore
    private Business businessCode;

    @ManyToMany
    @JoinColumn(name="user")
    @JsonIgnore
    private User userName;

    @Column(nullable = false)
    private String detailNumber;




}
