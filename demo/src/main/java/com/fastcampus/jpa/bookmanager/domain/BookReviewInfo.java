package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long bookId;
    @OneToOne(optional = false) // null을 절대 허용치 않겠다
    private Book book;

    private float averageReviewScore;

    private int reviewCount; // primitive, Wrapper 타입을 사용하는 건 null을 허용하냐 안하냐 차이, wrapper 타입 사용시 null값도 찍을 수 있다.
}
