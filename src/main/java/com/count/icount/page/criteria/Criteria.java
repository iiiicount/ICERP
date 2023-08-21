package com.count.icount.page.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Criteria {
    private int pageNum;
    private int amount;

//    public Criteria () {
//        this(1, 10);
//    }

//    public Criteria (int pageNum, int amount) {
//        this.pageNum = pageNum;
//        this.amount = amount;
//    }

    public static Criteria of (int pageNum, int amount) {
        return new Criteria(pageNum, amount);
    }


}
