package net.hackathon.china.controller;

import net.hackathon.china.dao.GlyphsRepository;
import net.hackathon.china.entity.Glyph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/glyphs")
public class GlyphsController {

    @Autowired
    GlyphsRepository glyphsRepository;

    @RequestMapping(value = "/glyphs", method = RequestMethod.GET)
    @ResponseBody
    public List<Glyph> getGlyphs() {
        ArrayList<Glyph> list = new ArrayList<>();
        glyphsRepository.findAll().forEach(list::add);
        return list;
    }

    @RequestMapping(value = "/glyph", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public String putGlyph(@RequestBody Glyph glyph) {
        glyphsRepository.save(glyph);
        return "OK";
    }

    @RequestMapping(value = "/glyph", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public String deleteGlyph(@RequestBody Glyph glyph) {
        glyphsRepository.deleteById(glyph.getId());
        return "OK";
    }

}
