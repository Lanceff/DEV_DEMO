package com.hui.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hui.entity.TbContent;
import com.hui.response.ResponseEntity;
import com.hui.service.TbContentService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal);*/
        System.out.println();
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> insert(@PathVariable Integer id) {
        UpdateWrapper<TbContent> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("title", "title-" + UUID.randomUUID().toString().substring(0, 4)).eq("id", id);
        boolean update = contentService.update(updateWrapper);
        if (update) {
            return new ResponseEntity<Boolean>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), update);
        } else {
            return new ResponseEntity<Boolean>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), update);
        }
    }
}
