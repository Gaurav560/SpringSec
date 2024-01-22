package com.telusko.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    
    private int itemId;
    private String itemName;
    private int itemVendorId;
    private int itemModelYear;
    private Number itemListPrice;


}
