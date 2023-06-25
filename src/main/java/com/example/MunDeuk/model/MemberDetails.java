package com.example.MunDeuk.model;

import com.example.MunDeuk.dto.MemberDetailsReqeustDto;
import jakarta.persistence.*;

@Entity
@Table(name = "member_details")
public class MemberDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @OneToOne(mappedBy = "member_details", orphanRemoval = true)
    @JoinColumn(name = "locker_id")
    private Locker locker;


    public void setLocker(MemberDetails target, Locker locker){
        target.locker= locker;
    }


    public void updateMemberDetails(MemberDetails target, MemberDetailsReqeustDto dto){
        target.email = dto.getEmail();
        target.nickname = dto.getNickname();
    }

}
