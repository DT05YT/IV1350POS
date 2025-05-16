package se.kth.iv1350.possystem.view;

import se.kth.iv1350.possystem.model.RevenueObserver;

/**
 *
 * @author Digit
 */
public class TotalRevenueView implements RevenueObserver {
    
    public TotalRevenueView() {
        
    }
    
    @Override
    public void updateObserversWithRevenue(double revenue) {
        System.out.println("Total revenue gained from sale: $" + revenue);
    }
}
