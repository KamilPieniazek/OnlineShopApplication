package pl.osa.osaapplication.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authority")
public class Role {

    @Id
    private String name;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
