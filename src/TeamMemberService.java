import java.util.List;

public interface TeamMemberService {
    void addTeamMember(TeamMember member);
    TeamMember getTeamMember(int id);
    List<TeamMember> getAllTeamMembers();
    void updateTeamMember(TeamMember member);
    void removeTeamMember(int id);
}
