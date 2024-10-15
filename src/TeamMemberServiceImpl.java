import java.util.List;

public class TeamMemberServiceImpl implements TeamMemberService {
    private Repository<TeamMember> repository;

    public TeamMemberServiceImpl(Repository<TeamMember> repository) {
        this.repository = repository;
    }

    @Override
    public void addTeamMember(TeamMember member) {
        repository.save(member);
    }

    @Override
    public TeamMember getTeamMember(int id) {
        return repository.findById(id);
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {
        return repository.findAll();
    }

    @Override
    public void updateTeamMember(TeamMember member) {
        repository.update(member);
    }

    @Override
    public void removeTeamMember(int id) {
        repository.delete(id);
    }
}
