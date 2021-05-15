package net.hackathon.china.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Glyph {

    @Id
    @GeneratedValue
    Integer id;
    String name;
    String unicode;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Grapheme> graphemes;

}
