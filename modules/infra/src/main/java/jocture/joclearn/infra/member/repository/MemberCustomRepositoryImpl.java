package jocture.joclearn.infra.member.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.data.dto.MemberCondition;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final EntityManager em;

    @Override
    public List<Member> findAll(MemberCondition condition) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);
        cq.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (condition != null) {
            if (StringUtils.hasText(condition.nicknameLike())) {
                Expression<String> nicknameValue = root.get("nickname").get("value");
                predicates.add(cb.like(cb.lower(nicknameValue), "%" + condition.nicknameLike().toLowerCase() + "%"));
            }

            if (StringUtils.hasText(condition.emailLike())) {
                Expression<String> emailValue = root.get("email").get("value");
                predicates.add(cb.like(cb.lower(emailValue), "%" + condition.emailLike().toLowerCase() + "%"));
            }

            if (condition.status() != null) {
                predicates.add(cb.equal(root.get("status"), condition.status()));
            }
        }

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        TypedQuery<Member> query = em.createQuery(cq);
        return query.getResultList();
    }
}
