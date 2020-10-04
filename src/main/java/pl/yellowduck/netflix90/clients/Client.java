package pl.yellowduck.netflix90.clients;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Client() {
    }

    @JsonCreator
    public Client(@JsonProperty("firsrtname") String firstname,
                  @JsonProperty("lastname") String lastname,
                  @JsonProperty("gender") Gender gender) {
        super(firstname, lastname, gender);
    }

    @Override
    public void introduce() {

    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public static final class ClientBuilder {
        protected Gender gender;
        private String firstname;
        private String lastname;

        private ClientBuilder() {
        }

        public ClientBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ClientBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public ClientBuilder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Client build() {
            return new Client(firstname, lastname, gender);
        }
    }
}
