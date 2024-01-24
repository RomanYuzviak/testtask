package model;

public class ClientsStats {
    private String zkpoCode1;
    private String name1;
    private String zkpoCode2;
    private String name2;
    private Long sum;
    private Integer amount;
    
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

    public String getZkpoCode1() {
        return zkpoCode1;
    }

    public void setZkpoCode1(String zkpoCode1) {
        this.zkpoCode1 = zkpoCode1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getZkpoCode2() {
        return zkpoCode2;
    }

    public void setZkpoCode2(String zkpoCode2) {
        this.zkpoCode2 = zkpoCode2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return "ClientsStats{" + "zkpoCode1=" + zkpoCode1 + ", name1=" + name1 
                + ", zkpoCode2=" + zkpoCode2 + ", name2=" + name2 + ", sum=" 
                + sum + ", amountOfOperations=" + amount + '}';
    }
}
