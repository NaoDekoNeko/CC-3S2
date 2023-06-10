package ejemplos;

public class UserGreeting{

    private final UserProfiles profiles;

    public UserGreeting(UserProfiles profiles) {
        this.profiles = profiles;
    }

    public String formatGreeting(UserId id) {
        //sin implementar aún
        //throw new UnsupportedOperationException();

        //una primera implemetación
        return String.format("Hola y bienvenido, %s",
                profiles.fetchNicknameFor(id));
    }

    /*
    //codigo antes de seguir los pasos
    private final UserProfiles profiles ;

    public UserGreeting(UserProfiles profiles) {
        this.profiles = profiles;
    }

    public String formatGreeting(UserId id) {
        return String.format("Hola y bienvenido, %s",
                profiles.fetchNicknameFor(id));
    }
     */
}