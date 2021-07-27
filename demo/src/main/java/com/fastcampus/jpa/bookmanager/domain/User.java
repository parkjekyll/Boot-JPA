package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor // 인자 없는 생성자
@AllArgsConstructor // 모든 인자가 담겨있는 생성자
@RequiredArgsConstructor // @NonNull 을 받아준다.
@Data // getter, setter
@Builder // 객체를 생성하고 값을 주입해줌.
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames={"email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull // 필수값이 됨.
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



    /*@Transient //영속성 컨텍스트에서 제외 실질적으로 디비에 저장 X
    private String testData;*/

    /*@OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;*/

}
