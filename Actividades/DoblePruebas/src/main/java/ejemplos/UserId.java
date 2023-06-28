package ejemplos;

public class UserId {
    private String id;

    public UserId(String id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object ob){
        UserId userId = (UserId) ob;
        return id == userId.id;
    }
}