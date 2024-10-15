import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeamMemberRepository implements Repository<TeamMember> {
    private final String fileName = "team_members.ser";

    @Override
    public void save(TeamMember member) {
        List<TeamMember> members = findAll();
        members.add(member);
        serializeList(members);
    }

    @Override
    public TeamMember findById(int id) {
        return findAll().stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<TeamMember> findAll() {
        List<TeamMember> members = deserializeList();
        return members != null ? members : new ArrayList<>();
    }

    @Override
    public void update(TeamMember updatedMember) {
        List<TeamMember> members = findAll();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == updatedMember.getId()) {
                members.set(i, updatedMember);
                break;
            }
        }
        serializeList(members);
    }

    @Override
    public void delete(int id) {
        List<TeamMember> members = findAll();
        members.removeIf(m -> m.getId() == id);
        serializeList(members);
    }

    private void serializeList(List<TeamMember> members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<TeamMember> deserializeList() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<TeamMember>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
