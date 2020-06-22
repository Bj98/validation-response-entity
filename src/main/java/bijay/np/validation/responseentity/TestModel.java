package bijay.np.validation.responseentity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "NAME can't be empty!")
    @Size(min=2,max=40,message = "Name can't be greater than 40!")
    private String name;

    @NotNull(message = "Age can't be empty!")
    @Min(value = 18, message = "Age must be atleast 18!")//Minimum age required is 18
    private int age;

    @NotNull(message = "EMAIL can't be empty!")
    @Email
    private String email;

    @NotNull(message = "PASSWORD can't be empty!")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
