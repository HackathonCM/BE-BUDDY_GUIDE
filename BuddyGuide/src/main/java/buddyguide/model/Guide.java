package buddyguide.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guides")
public class Guide extends BaseEntity<Long> implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Transient
    private String type;

    @ElementCollection(targetClass = TourCategory.class)
    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    private List<TourCategory> categories;

    @Column(name = "available")
    boolean available = true;

    @Column(name = "price")
    private String price;

}
