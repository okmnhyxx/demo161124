package com.emi.repository.Specification;

import com.emi.domain.User;
import com.emi.dto.UserSearchRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by emi on 2016/11/1.
 */
public class UserSpecification {

    public static Specification<User> findUserBy(final UserSearchRequest request) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmpty(request.getName())) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + request.getName() + "%"));
                }
                if (!StringUtils.isEmpty(request.getNickName())) {
                    predicateList.add(cb.like(root.get("nickName").as(String.class), "%" + request.getNickName() + "%"));
                }
                if (!StringUtils.isEmpty(request.getState())) {
                    predicateList.add(cb.equal(root.get("state").as(Integer.class), request.getState()));
                }
                if (!StringUtils.isEmpty(request.getCreateTimeFrom())) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), request.fetchCreateTimeFromDate()));
                }
                if (!StringUtils.isEmpty(request.getCreateTimeTo())) {
                    predicateList.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), request.fetchCreateTimeToDate()));
                }
                return query.where(predicateList.toArray(new Predicate[0])).getRestriction();
            }
        };
    }
}
