package bijay.np.validation.responseentity;


import java.util.List;
import java.util.Optional;

public interface TestService {
    List<TestModel> getAll();

    Optional<TestModel> findOne(Long id);

    void createTest(TestModel test);

    void updateTest(TestModel test, Long id);

    void deleteTest(Long id);
}
