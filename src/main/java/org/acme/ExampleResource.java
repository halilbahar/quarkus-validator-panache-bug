package org.acme;

import org.acme.entity.Person;
import org.acme.entity.PersonPanache;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class ExampleResource {

    @Inject
    Validator validator;

    @Inject
    PersonRepository personRepository;

    /**
     * This endpoint will throw a StackOverflowError
     */
    @POST
    @Path("/panache/persist")
    public Response panachePersist(PersonPanache person) {
        Set<ConstraintViolation<PersonPanache>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            return Response.status(422).build();
        }

        person.persist();
        return Response.noContent().build();
    }

    /**
     * This endpoint will execute without a problem
     */
    @POST
    @Path("/panache/no-persist")
    public Response panacheNoPersist(PersonPanache person) {
        Set<ConstraintViolation<PersonPanache>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            return Response.status(422).build();
        }

        return Response.noContent().build();
    }

    /**
     * This endpoint will throw a StackOverflowError
     */
    @POST
    @Path("/repository/persist")
    public Response repositoryPersist(Person person) {
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            return Response.status(422).build();
        }

        personRepository.persist(person);
        return Response.noContent().build();
    }

    /**
     * This endpoint will execute without a problem
     */
    @POST
    @Path("/repository/no-persist")
    public Response repositoryNoPersist(Person person) {
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            return Response.status(422).build();
        }

        return Response.noContent().build();
    }
}
