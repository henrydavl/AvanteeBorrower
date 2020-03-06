package byc.avt.avanteeborrower.repository;

public class AuthRepository {
    private static AuthRepository repository;
    private String baseUrl = "";

    public static AuthRepository getInstance() {
        if (repository == null) {
            repository = new AuthRepository();
        }
        return repository;
    }
}
