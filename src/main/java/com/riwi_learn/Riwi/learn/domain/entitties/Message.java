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

@Entity(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Lob
    private String content;

    private LocalDate sent_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "sender_id",
        referencedColumnName = "id"
    )
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "receiver_id",
        referencedColumnName = "id"
    )
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "course_id",
        referencedColumnName = "id"
    )
    private Course course; 
}
