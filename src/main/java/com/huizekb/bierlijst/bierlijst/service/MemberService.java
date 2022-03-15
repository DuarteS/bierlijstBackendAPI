package com.huizekb.bierlijst.bierlijst.service;




import com.huizekb.bierlijst.bierlijst.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {


    /**
     * create new member
     *
     * @param member entity
     * @return entity that created
     */
    Member create(Member member);

    /**
     * Update member data
     *
     * @param member entity
     * @return entity modified
     */
    Member update(Member member, String id);


    /**
     * get Member by id
     *
     * @param id entity id
     * @return Optional entity Member
     */
    Optional<Member> getById(String id);

    /**
     * Get all entities
     *
     * @return list of entity Member
     */
    List<Member> getAll();

    void delete(String id);

}
