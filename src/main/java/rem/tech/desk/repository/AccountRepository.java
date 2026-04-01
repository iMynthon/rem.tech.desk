package rem.tech.desk.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import rem.tech.desk.model.Account;

import java.util.UUID;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account, UUID> {

    @Transactional(Transactional.TxType.SUPPORTS)
    public Account findById(UUID id) {
        return find("id", id).firstResult();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Account findByUsername(String username) {
        return find("username", username).firstResult();
    }

    @Transactional
    public Account save(Account account) {
        getEntityManager().persist(account);
        getEntityManager().flush();
        getEntityManager().refresh(account);
        return account;
    }
}
