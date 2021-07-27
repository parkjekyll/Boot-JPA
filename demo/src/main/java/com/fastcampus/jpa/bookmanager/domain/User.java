package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor // 인자 없는 생성자
@AllArgsConstructor // 모든 인자가 담겨있는 생성자
@RequiredArgsConstructor // @NonNull 을 받아준다.
@Data // getter, setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder // 객체를 생성하고 값을 주입해줌.
@Entity
@EntityListeners(value = {UserEntityListener.class})
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames={"email"})})
public class User extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull // 필수값이 됨.
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    /*@Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;*/

    /*@Transient //영속성 컨텍스트에서 제외 실질적으로 디비에 저장 X
    private String testData;*/

    /*@OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;*/

   /* @PrePersist //인서트 메소드가 작동되기 전 실행
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        System.out.println(">>> prePersist");
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println(">>> preUpdate");
    }*/

}
