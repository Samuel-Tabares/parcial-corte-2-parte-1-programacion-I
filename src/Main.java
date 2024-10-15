import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository<TeamMember> repository = new TeamMemberRepository();
        TeamMemberService service = new TeamMemberServiceImpl(repository);

        // Add some team members
        service.addTeamMember(new TeamMember(1, "Alice", "Developer"));
        service.addTeamMember(new TeamMember(2, "Bob", "Designer"));
        service.addTeamMember(new TeamMember(3, "Charlie", "Manager"));

        // Retrieve all members
        List<TeamMember> allMembers = service.getAllTeamMembers();
        System.out.println("All Team Members:");
        allMembers.forEach(System.out::println);

        // Update a team member
        TeamMember updatedMember = new TeamMember(1, "Alice", "Senior Developer");
        service.updateTeamMember(updatedMember);

        // Get and display the updated team member
        TeamMember retrievedMember = service.getTeamMember(1);
        System.out.println("\nUpdated Team Member:");
        System.out.println(retrievedMember);

        // Remove a team member
        service.removeTeamMember(2);

        // Display remaining members
        System.out.println("\nTeam Members After Removal:");
        service.getAllTeamMembers().forEach(System.out::println);
    }
}
