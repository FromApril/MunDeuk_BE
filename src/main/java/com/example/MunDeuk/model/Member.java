package com.example.MunDeuk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "members", orphanRemoval = true)
    @JoinColumn(name = "details_id")
    private MemberDetails memberDetails;



    @Builder
    public Member(String username, String password,MemberDetails memberDetails){
        this.username = username;
        this.password = password;
        this.memberDetails = memberDetails;
    }

}