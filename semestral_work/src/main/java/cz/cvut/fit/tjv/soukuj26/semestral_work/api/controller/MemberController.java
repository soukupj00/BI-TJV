package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.MemberConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.MemberDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.MemberService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public Collection<MemberDto> all() {
        return MemberConverter.fromModelMany(memberService.readAll());
    }

    @PostMapping("/member")
    public MemberDto newMember(@RequestBody MemberDto newMember) {
        Member member = MemberConverter.toModel(newMember);
        try {
            this.memberService.create(member);
            member = this.memberService.read(member.getName());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return MemberConverter.fromModel(member);
    }

    @GetMapping("/member/{id}")
    public MemberDto one(@PathVariable String id) {
        try {
            return MemberConverter.fromModel(
                    memberService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/member/{id}")
    MemberDto updateMember(@RequestBody MemberDto memberDto, @PathVariable String id) {
        try {
            memberService.read(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Member member = MemberConverter.toModel(memberDto);
        try {
            this.memberService.update(member);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return memberDto;
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable String id) {
        try {
            memberService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
