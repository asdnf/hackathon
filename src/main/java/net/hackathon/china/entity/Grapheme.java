package net.hackathon.china.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Grapheme {

    @Id
    @GeneratedValue
    Integer id;
    String name;

    @Column(columnDefinition = "text")
    String base64Image;

    Integer groupId;

}
