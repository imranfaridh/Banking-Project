import java.io.Serializable;
import java.time.LocalDate;

public class Tranaction implements  Comparable<Tranaction> , Serializable {
   // variable
    private  static  int next =1;
    int trsno;
    Account acc;
    LocalDate date;
    char Operation;
    Double amount ;

    public Tranaction(Account acc, LocalDate date ) {
        this.acc = acc;
        this.date = date;
        char operation=0;
       Operation = operation;
        this.amount = amount;
        trsno = next++;
    }

    public Tranaction(Account acc, LocalDate now, char d, double parseDouble) {
    }


    @Override
    public int compareTo(Tranaction o) {
        return this.trsno- o.trsno;
    }

    @Override
    public String toString() {
        return "Tranaction{" +
                "trsno=" + trsno +
                ", acc=" + acc +
                ", date=" + date +
                ", Operation=" + Operation +
                ", amount=" + amount +
                '}';
    }

    public int getTrsno() {
        return trsno;
    }

    public Account getAcc() {
        return acc;
    }

    public LocalDate getDate() {
        return date;
    }

    public char getOperation() {
        return Operation;
    }

    public Double getAmount() {
        return amount;
    }
}
