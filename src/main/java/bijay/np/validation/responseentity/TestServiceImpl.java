package bijay.np.validation.responseentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public List<TestModel> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Optional<TestModel> findOne(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void createTest(TestModel test) {
         testRepository.save(test);
    }

    @Override
    public void updateTest(TestModel test, Long id) {
        testRepository.findById(id).map(test1->{
            test1.setAge(test.getAge());
            test1.setEmail(test.getEmail());
            test1.setName(test.getName());
            test1.setPassword(test.getPassword());
            return testRepository.save(test1);
        });

    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
