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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull // 필수값이 됨.
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

}
