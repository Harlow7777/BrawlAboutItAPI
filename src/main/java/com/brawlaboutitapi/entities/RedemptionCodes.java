package com.brawlaboutitapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Redemption Code
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionCodes {

    @Id
    public Long code;
    public int card_id;
}
