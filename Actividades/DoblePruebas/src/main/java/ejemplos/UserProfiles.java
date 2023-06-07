package ejemplos;

public class UserProfiles {
    public String fetchNicknameFor(UserId id) {
        return "emp" + id.getId();
    }
}
