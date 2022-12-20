package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // xml 파일에 지정해놓은 persistenceUnitName
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction();
        // 트랜젝션 시작
        tx.begin();

        //익셉션이 날 수도 있다.
        try{
            // 저장
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

//            // 조회
//            Member member = em.find(Member.class, 1L);
//
//            // 수정 , 자바 컬렉션처럼 쓰는 거라 persist()를 안 해도 된다.
//            member.setName("HelloJPA");
//
//            // JPQL 사용
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) // limit
//                    .setMaxResults(8) // offset JPQL은 페이징이 이렇게 쉽다.
//                    .getResultList();
//
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1.getName());
//            }

//            // 비영속
//            Member member = new Member();
//            member.setId(10L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            // select query가 안 나갔다 -> 영속성 컨텍스트에서 가져왔다.
//            Member findMember = em.find(Member.class, 10L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            // select query가 한 번만 나갔다 -> 영속성 컨텍스트에서 가져왔다.
//            Member findMember1 = em.find(Member.class, 10L);
//            Member findMember2 = em.find(Member.class, 10L);
//
//            // 1차 캐시를 통해 영속 엔티티의 동일성 보장
//            System.out.println("result = "+(findMember1 == findMember2));

//            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            // persist는 커밋 시점에 한꺼번에 호출된다.
//            em.persist(member1);
//            em.persist(member2);

//            // 변경은 따로 em이 필요 없다. 자바 컬렉션처럼 쓰는 느낌
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");

//            // 영속
//            Member member = new Member(20L, "member200");
//            em.persist(member);
//
//            // em.flush() => 쌓여있는 insert나 update, delete를 이 타이밍에 사용하는 메서드
//            // 물을 내리는 것처럼 내가 원하는 타이밍에 DDL을 사용한디.
//            // 1차 캐시는 유지된다.
//            em.flush();
//
//            // 참고로 JPQL 쿼리 실행시 플러시가 자동으로 호출된다.

//            // 영속
//            Member member = em.find(Member.class,150L);
//            member.setName("AAAAA");
//
//            // 준영속 -> 영속성 컨텍스트에서 해당 객체 빼버리기
//            em.detach(member);
//
//            // 준영속 -> 영속성 컨텍스트에서 모든 객체 빼버리기
//            em.clear();



            System.out.println("===================");

            // 트랜잭션 끝, 정상이면 커밋
            tx.commit();
        }catch (Exception e){
            // 문제가 생기면 롤백
            tx.rollback();
            throw e;
        }finally {
            // 엔티티 매니저는 쓰레드 간에 공유를 하면 안 된다.
            // 쓰레드가 끝날 떄 close()를 해주어야한다.
            em.close();
        }
        emf.close();
    }
}
