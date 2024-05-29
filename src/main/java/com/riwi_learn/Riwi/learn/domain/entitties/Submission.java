package com.riwi_learn.Riwi.learn.domain.entitties;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "submissions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Lob
    private String content;

    private LocalDate date;
    
    private double grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id"
    )
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "course_id",
        referencedColumnName = "id"
    )
    private Assigment assigment;
}
