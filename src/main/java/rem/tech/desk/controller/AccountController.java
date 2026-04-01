package rem.tech.desk.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rem.tech.desk.dto.AccountResponse;
import rem.tech.desk.dto.RegistrationRequest;
import rem.tech.desk.service.AccountService;

@ApplicationScoped
@Path("api/v1/tech_desk/account")
public class AccountController {

    @Inject
    private AccountService accountService;


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountResponse saveAccount(RegistrationRequest registrationRequest) {
        return accountService.crateAccount(registrationRequest);
    }
}
