package pl.osa.osaapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class Category {

    @Id
    private String name;

    //jesli parentName == null to kategoria jest nadrzedna, jesli nie to kategoria jest dzieckiem
    private String parentName;
}
