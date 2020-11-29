//package pl.osa.osaapplication.domain;
//
//
//import com.sun.istack.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "authority")
//public class Role {
//
//    @Id
//    @Column(name = "name", columnDefinition = "varchar(255) default 'USER'")
//    private String name;
//
//    @NotNull
//    @Column(name = "description")
//    private String description;
//
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
//
//
//}
