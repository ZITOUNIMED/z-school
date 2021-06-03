package z.school.administration.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import z.school.administration.utils.SectionsEnum;

import static z.school.administration.utils.SectionsEnum.SEPTIEME_SECONDAIRE;
import static z.school.administration.utils.SectionsEnum.HUITIEME_SECONDAIRE;
import static z.school.administration.utils.SectionsEnum.NEUVIEME_SECONDAIRE;

import static z.school.administration.utils.ClassesEnum.S01A;
import static z.school.administration.utils.ClassesEnum.S01B;

import static z.school.administration.utils.ClassesEnum.S02A;
import static z.school.administration.utils.ClassesEnum.S02B;

import static z.school.administration.utils.ClassesEnum.S03A;
import static z.school.administration.utils.ClassesEnum.S03B;

@RestController
@RequestMapping("/z-school-administration/api/static-data")
public class StaticDataController {
    @GetMapping("/sections")
    public ResponseEntity<List<Map<String, String>>> getSectionsStaticData(){
        List<Map<String, String>> list = Streamable.of(SEPTIEME_SECONDAIRE, HUITIEME_SECONDAIRE, NEUVIEME_SECONDAIRE)
        .map(sectionEnum -> {
            Map<String, String> map = new HashMap<>();
            map.put("key", sectionEnum.name());
            map.put("ref", sectionEnum.getRef());
            map.put("level", String.valueOf(sectionEnum.getLevel()));
            return map;
        })
        .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/classes")
    public ResponseEntity<List<Map<String, String>>> getClassesStaticData(){
        List<Map<String, String>> list = Streamable.of(S01A, S01B, S02A, S02B, S03A, S03B)
        .map(classeEnum -> {
            Map<String, String> map = new HashMap<>();
            map.put("key", classeEnum.name());
            map.put("section", Enum.valueOf(SectionsEnum.class, classeEnum.getSectionKey()).getRef());
            map.put("capacity", String.valueOf(classeEnum.getCapacity()));
            return map;
        })
        .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
