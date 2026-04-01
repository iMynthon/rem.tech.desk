package rem.tech.desk.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account", schema = "tech_desk_schema")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Account extends PanacheEntityBase {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String email;

    private String username;

    private String password;

    @Column(name = "connection_id", insertable = false)
    private Long connectionId;

    @Column(name = "is_online")
    private Boolean isOnline;

    private String picture;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

}
