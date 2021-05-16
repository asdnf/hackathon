package net.hackathon.china.dao;

import net.hackathon.china.entity.Glyph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GlyphsRepository extends CrudRepository<Glyph, Integer> {

    Glyph getByUnicode(String unicode);
    Glyph getById(Integer id);

}
