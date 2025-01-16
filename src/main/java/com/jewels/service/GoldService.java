package com.jewels.service;

import com.jewels.entities.Gold;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GoldService
{

    List<Gold> goldList = new ArrayList<>();

    //----- creating a gold-object in DB :
    public Gold onbaordNewGold(Gold gold)
    {
        gold.setProductId(new Random().nextInt(9873));
        goldList.add(gold);
        return gold;
    }

    //------- view all gold-products:
    public List<Gold> viewAllGoldProducts()
    {
        return goldList;
    }


    //----- find gold-product by Product_ID
    public Gold findGoldById(Integer productId)
    {
        Gold gold = goldList.stream().filter(i -> i.getProductId() == productId)
                .findFirst().orElse(null);
        return gold;
    }

    //---- Delete gold by productId
    public void deleteCourse(Integer productId)
    {
        Gold gold = findGoldById(productId);
        goldList.remove(gold);
    }


    //---- update gold by product-id :
    public Gold updateGold(Gold gold,int productId)
    {
        Gold existingGold = findGoldById(productId);

        Gold newGold = goldList.set(goldList.lastIndexOf(existingGold), gold);

        return newGold;
    }
}
