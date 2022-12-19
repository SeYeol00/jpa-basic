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

            // 비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");



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
