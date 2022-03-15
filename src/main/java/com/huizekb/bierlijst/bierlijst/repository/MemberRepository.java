package com.huizekb.bierlijst.bierlijst.repository;


import com.huizekb.bierlijst.bierlijst.domain.Member;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@EnableScan
@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, String> {
}
