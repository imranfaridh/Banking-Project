import java.util.Date;

public class Account implements  Comparable{
    // variables
    static  int nextaccno = 10;
    int accno;
    String owner ;
    city city;
    char gender;
    double balance ;
    Date opendate;
    // constructor


    public Account(int a, String o, city c, char g, double b) {
    }

    public Account(String owner, city city, char gender) {
        accno =nextaccno;
        nextaccno +=10;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        balance = 0.0;
        opendate = null; //system.currentdate();
    }

    public Account(int accno, String owner, city city, double balance) {
        this.accno = accno;
        this.owner = owner;
        this.city = city;
        setBalance(balance);
    }
    public void setBalance(double b) {
        balance = b> 0.0 ? b:0.0 ;
    }

    @Override
    public String toString() {
        return accno+"  " + owner
                    +"   "+ city.cityname
                    +"   "+gender + "  " +balance; }


    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Account) o).owner);
    }
  public void deposit (double amount ){
        if (amount >0){
            setBalance(balance +amount);
        }
  }
  public double withdraw(double amount) {
      if (amount > 0) {
          if(amount <balance){
          setBalance(balance - amount);
      } else {
          amount = balance;
          setBalance(0.0);
      }
      return amount;
  }
  return 0.0;
  }}


