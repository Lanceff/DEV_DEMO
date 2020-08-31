package com.hui.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.entity.TbContent;
import com.hui.response.ResponseEntity;
import com.hui.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-08-31 14:05
 * @Description:
 */
@RestController
public class TbController {

    @Autowired
    private TbContentService contentService;

    @GetMapping("/")
    public ResponseEntity<List<TbContent>> getAllContent() {
        List<TbContent> list = contentService.list();
        ResponseEntity<List<TbContent>> responseEntity = new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), list);
        return responseEntity;
    }


    @GetMapping("/view/{id}")
    public ResponseEntity<TbContent> getById(@PathVariable Integer id) {
        TbContent content = contentService.getById(id);
        ResponseEntity<TbContent> responseEntity = new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), content);
        return responseEntity;
    }

    @PostMapping("/insert")
    public ResponseEntity<Boolean> insert(@RequestBody TbContent tbContent) {
        boolean op = contentService.save(tbContent);
        if (op) {
            return new ResponseEntity<Boolean>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), op);
        } else {
            return new ResponseEntity<Boolean>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), op);
        }
    }
}
