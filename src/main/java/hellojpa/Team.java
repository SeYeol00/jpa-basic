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
}
