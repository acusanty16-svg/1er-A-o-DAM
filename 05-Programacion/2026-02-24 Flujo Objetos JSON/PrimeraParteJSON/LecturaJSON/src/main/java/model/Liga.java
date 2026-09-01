package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Liga implements Serializable {
    private static Long serialVersionUID = 123L;
    private String idLeague;
    private String strLeague;
    private String strSport;
}
