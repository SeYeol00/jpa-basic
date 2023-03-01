package hellojpa;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    // 일대다 매핑에서 어떤 것이랑 연결하는지

    @OneToMany(mappedBy = "team")
    // 객체와 테이블 간에 연관관계를 맺는 차이를 알아야한다.
    // 객체는 연관관계가 2개지만 테이블은 하나다.
    // 객체의 양방향 관계는 사실 서로 다른 단방향 관계 2개다.
    // 외래키가 있는 곳을 주인으로 해라
    // ArrayList로 초기화하는 이유는 널포인터 익셉션을 피하기 위함이다.
    private List<Member> members= new ArrayList<>();
    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    // 둘 다 걸어 놓으면 문제는 무한 루프가 걸릴 수 있다.
    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
}
