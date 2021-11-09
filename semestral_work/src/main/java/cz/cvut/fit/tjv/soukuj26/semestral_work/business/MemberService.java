package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Business logic operations related to Member domain type.
 */
@Component
public class MemberService {

    public MemberService() {}

    public Member create(Member member) throws Exception {
        if (Objects.equals(member.getName(), "adam")) {
            throw new Exception();
        }
        return new Member(member.getPersonalNumber(), member.getEmail(), member.getName());
    }

    public Member update(Member member) throws Exception {
        if (Objects.equals(member.getName(), "david")) {
            return new Member(member.getPersonalNumber(), member.getEmail(), member.getName());
        }
        throw new Exception();

    }

    public Member read (String name) throws Exception {
        if (Objects.equals(name, "david")) {
            return new Member(name);
        }
        throw new Exception();
    }

    public Collection<Member> readAll () {
        List<Member> tmp = new ArrayList<>();
        Member a = new Member("pepa");
        Member b = new Member("filip");
        tmp.add(a);
        tmp.add(b);
        return tmp;
    }

    public void delete(String name) throws Exception {
        if (Objects.equals(name, "david")) {
            return;
        }
        throw new Exception();
    }
}
