package ch02.pr_0420;

//20260420 Ex06
// Member.java , MemberEx06
public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            {
                return true;
            }
        }
        return false;
    }
}
