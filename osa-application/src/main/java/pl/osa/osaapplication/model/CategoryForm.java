package pl.osa.osaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryForm {

    @NotEmpty(message = "Please ")
    private String name;

    private String parentName;
}
