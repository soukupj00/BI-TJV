package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.MemberConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.StaffConverter;
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

    @GetMapping("/member/{id}")
    public MemberDto one(@PathVariable String id) {
        try {
            return MemberConverter.fromModel(memberService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/member")
    public MemberDto newMember(@RequestBody MemberDto newMember) {
        try {
            Member member = MemberConverter.toModel(newMember);
            memberService.create(member);
            return MemberConverter.fromModel(member);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/member/{id}")
    MemberDto updateMember(@RequestBody MemberDto memberDto, @PathVariable String id) {
        try {
            memberService.read(id);
            Member member = MemberConverter.toModel(memberDto);
            memberService.update(member);
            return MemberConverter.fromModel(member);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable String id) {
        try {
            MemberConverter.fromModel(memberService.read(id));
            memberService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
