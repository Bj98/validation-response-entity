package bijay.np.validation.responseentity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {
    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TestModel>> getAll() {
        List<TestModel> testList = testService.getAll();
        if (testList.isEmpty())
            throw new RecordNotFoundException("No data found!");
        return new ResponseEntity<>(testService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TestModel> findOne(@PathVariable("id") Long id) {
        Optional<TestModel> test = testService.findOne(id);
        if (test.isPresent()) {
            return new ResponseEntity<>(test.get(), HttpStatus.FOUND);
        } else {
            throw new RecordNotFoundException("Invalid id:" + id);
        }

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<TestModel> createTest(@Valid @RequestBody TestModel test) {
        testService.createTest(test);
        return new ResponseEntity<TestModel>(test, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updateTest(@Valid @RequestBody TestModel test, @PathVariable("id") Long id) {
        Optional<TestModel> test1 = testService.findOne(id);
        if (test1.isPresent()) {
            testService.updateTest(test, id);
            return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
        } else {
            throw new RecordNotFoundException("Invalid id:" + id);
        }

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTest(@Valid @PathVariable("id") Long id) {
        Optional<TestModel> test1 = testService.findOne(id);
        if (test1.isPresent()) {
            testService.deleteTest(id);
            return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
        } else {
            throw new RecordNotFoundException("Invalid id:" + id);
        }


    }


}
