package com.huizekb.bierlijst.bierlijst.service;


import com.huizekb.bierlijst.bierlijst.domain.Member;
import com.huizekb.bierlijst.bierlijst.exception.DataNotFoundException;
import com.huizekb.bierlijst.bierlijst.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Member create(Member member) {
        return repository.save(member);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Member update(Member member, String id) {

        Optional<Member> memberOptional = repository.findById(id);
        if (memberOptional.isPresent()) {
            memberOptional.get().setMemberName(member.getMemberName());
            memberOptional.get().setMemberLastname(member.getMemberLastname());

            return repository.save(memberOptional.get());
        }
        throw new DataNotFoundException("Member Id not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Member> getById(String id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Member> getAll() {
        return (List<Member>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
