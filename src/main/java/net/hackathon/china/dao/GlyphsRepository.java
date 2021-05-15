package net.hackathon.china.dao;

import net.hackathon.china.entity.Glyph;
import org.springframework.data.repository.CrudRepository;

public interface GlyphsRepository extends CrudRepository<Glyph, Integer> {

    Glyph getByUnicode(String unicode);
    Glyph getById(Integer id);

}
