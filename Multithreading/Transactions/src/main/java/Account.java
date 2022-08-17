public class Account {

    private long money;
    private String accNumber;
    private boolean blockAccount;

    public Account(String accNumber,long money){
        this.accNumber = accNumber;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        if(!blockAccount) {
            this.money = money;
        }
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        if(!blockAccount){
            this.accNumber = accNumber;
        }
    }

    public boolean getBlockAccount(){
        return blockAccount;
    }

    public void setBlockAccount(boolean blockAccount){
        this.blockAccount = blockAccount;
    }
}
