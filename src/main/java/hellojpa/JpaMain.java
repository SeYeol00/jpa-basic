package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            // 조회
            Member member = em.find(Member.class, 1L);

            // 수정 , 자바 컬렉션처럼 쓰는 거라 persist()를 안 해도 된다.
            member.setName("HelloJPA");


            // 트랜잭션 끝, 정상이면 커밋
            tx.commit();
        }catch (Exception e){
            // 문제가 생기면 롤백
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
        emf.close();
    }
}
