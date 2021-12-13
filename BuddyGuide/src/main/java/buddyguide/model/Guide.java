package buddyguide.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guides")
public class Guide extends BaseEntity<Long> {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    /*@Enumerated(EnumType.STRING)
    @Column(name="main_category")
    private TourCategory mainCategory;

    @Enumerated(EnumType.STRING)
    @Column(name="secondary_category")
    private TourCategory secondaryCategory;*/

    @ElementCollection(targetClass = TourCategory.class)
    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    private List<TourCategory> categories;

    @Column(name = "available")
    boolean available = true;

}
