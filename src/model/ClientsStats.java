/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Roman
 */
public class ClientsStats {
    public String zkpoCode1;
    public String name1;
    public String zkpoCode2;
    public String name2;
    public Long sum;
    public Integer amount;
    
    public ClientsStats(String code1,String name1,
            String code2, String name2,
            Long sum, Integer total){
        this.zkpoCode1 = code1;
        this.name1 = name1;
        this.zkpoCode2 = code2;
        this.name2 = name2;
        this.sum = sum;
        this.amount = total;
    }

    @Override
    public String toString() {
        return "ClientsStats{" + "zkpoCode1=" + zkpoCode1 + ", name1=" + name1 + ", zkpoCode2=" + zkpoCode2 + ", name2=" + name2 + ", sum=" + sum + ", amountOfOperations=" + amount + '}';
    }
    
}
