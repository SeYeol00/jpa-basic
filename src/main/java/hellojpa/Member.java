package hellojpa;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
initialValue = 1,
allocationSize = 50)
//@Table(name = "MBR")
public class Member {

    @Id  //                                   null로 들어와야 디비에서 오토 인크리먼트가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String username;

    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)// 타임스탬프를 주어야한다.
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 최신 버전은 이거 쓰세요
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    @Lob // 큰 컨텐츠를 넣고 싶으면 Lob을 쓴다.
    private String description;
    public Member() {
    }

}
