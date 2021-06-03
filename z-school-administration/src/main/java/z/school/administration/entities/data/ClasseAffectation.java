package z.school.administration.entities.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames={"user_id", "classe_key"})
 })
public class ClasseAffectation {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="classe_key")
    private String classeKey;
}
