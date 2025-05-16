/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.possystem.model;

/**
 * An observer that updates classes with the total revenue from a sale,
 * when it is ended.
 */
public interface RevenueObserver {
    /**
     * Used when a sale is ended.
     * 
     * @param revenue The revenue from the sale.
     */
    void updateObserversWithRevenue(double revenue);
}
