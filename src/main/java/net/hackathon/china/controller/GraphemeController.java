package net.hackathon.china.controller;

import net.hackathon.china.dao.GlyphsRepository;
import net.hackathon.china.dao.GraphemeRepository;
import net.hackathon.china.entity.Glyph;
import net.hackathon.china.entity.Grapheme;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Collection;

@Controller
@RequestMapping("/grapheme")
public class GraphemeController {

    @Autowired
    GlyphsRepository glyphsRepository;

    @Autowired
    GraphemeRepository graphemeRepository;

    @RequestMapping("/graphemes")
    @ResponseBody
    public Collection<Grapheme> getGraphemes(@RequestParam("glyphId") Integer glyphId) {
        Glyph glyph = glyphsRepository.getById(glyphId);
        return glyph.getGraphemes();
    }

    @RequestMapping(value = "/graphemes", method = RequestMethod.POST)
    public RedirectView putGrapheme(@RequestParam("glyphId") Integer glyphId,
                                    @RequestParam("groupId") Integer groupId,
                                    @RequestParam("img-file") MultipartFile file) throws IOException {
        Glyph glyph = glyphsRepository.getById(glyphId);
        byte[] buff = file.getBytes();
        String imageStr = Base64.encodeBase64String(buff);
        Grapheme grapheme = new Grapheme();
        grapheme.setBase64Image(imageStr);
        grapheme.setGroupId(groupId);
        glyph.getGraphemes().add(grapheme);
        graphemeRepository.save(grapheme);
        return new RedirectView("/upload.html");
    }

}
