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
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "name")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    // ManyToOne이 있는 곳을 연관관계의 주인으로 해라
    // 외래키가 있는 곳을 주인으로 해라
    @JoinColumn(name = "TEAM_ID") // 관계와 조인하는 컬럼은 뭐야?
    private Team team;

//    private Integer age;
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)// 타임스탬프를 주어야한다.
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    // 최신 버전은 이거 쓰세요
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//    @Lob // 큰 컨텐츠를 넣고 싶으면 Lob을 쓴다.
//    private String description;
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    // 연관관계 편의 메소드를 작성하자
    // 이러면 양방향으로 걸린다.
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
