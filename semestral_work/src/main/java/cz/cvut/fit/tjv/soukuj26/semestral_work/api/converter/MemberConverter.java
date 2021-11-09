package cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.MemberDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;

import java.util.ArrayList;
import java.util.Collection;

public class MemberConverter {

    public static Member toModel(MemberDto memberDto) {
        return new Member(memberDto.getPersonalNumber(), memberDto.getEmail(), memberDto.getName());
    }

    public static MemberDto fromModel(Member member) {
        return new MemberDto(member.getPersonalNumber(), member.getEmail(), member.getName());
    }

    public static Collection<Member> toModelMany(Collection<MemberDto> memberDtos) {
        Collection<Member> members = new ArrayList<>();
        memberDtos.forEach((m) -> members.add(toModel(m)));
        return members;
    }

    public static Collection<MemberDto> fromModelMany(Collection<Member> members) {
        Collection<MemberDto> memberDtos = new ArrayList<>();
        members.forEach((m) -> memberDtos.add(fromModel(m)));
        return memberDtos;
    }
}
