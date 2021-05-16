package net.hackathon.china.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    List<Grapheme> graphemes;

}
