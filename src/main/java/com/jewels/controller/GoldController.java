package com.jewels.controller;

import com.jewels.entities.Gold;
import com.jewels.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jewels")
public class GoldController
{
    private GoldService goldService;

    @Autowired
    public GoldController(GoldService goldService)
    {
        this.goldService = goldService;
    }


    @PostMapping
    public ResponseEntity<Gold> addGoldProducts(@RequestBody Gold gold)
    {
        Gold gold1 = this.goldService.onbaordNewGold(gold);

        //return ResponseEntity.of(Optional.of(gold1));
        return  new ResponseEntity<>(gold1,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllGoldProducts()
    {
        List<Gold> goldList = this.goldService.viewAllGoldProducts();

        return new ResponseEntity<>(goldList,HttpStatus.OK);
    }


    @GetMapping("search/path/{productId}")
    public ResponseEntity<Gold> findGoldByIdUsingPathVariable(@PathVariable Integer productId)
    {
        Gold goldById = this.goldService.findGoldById(productId);

        return new ResponseEntity<>(goldById,HttpStatus.OK);
    }


    @GetMapping("/search/request")
    public ResponseEntity<Gold> findByGoldIdUsingRequestParam(@RequestParam(required = false) Integer productId)
    {
        Gold goldById =this.goldService.findGoldById(productId);

        return new ResponseEntity<>(goldById,HttpStatus.OK);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteGoldProduct(@PathVariable  Integer productId)
    {
        this.goldService.deleteCourse(productId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{productId}")
    public ResponseEntity<Gold> updateGoldProduct(@RequestBody Gold updatedGold, @PathVariable Integer productId)
    {
        Gold gold = this.goldService.updateGold(updatedGold, productId);

        return new ResponseEntity<>(gold,HttpStatus.OK);
    }
}
