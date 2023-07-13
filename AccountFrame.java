import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class AccountFrame extends JFrame {
    JPanel panel1 ;
    JLabel accnolbl , ownerlbl, balancelbl, citylbl,genderlbl,amountlbl;
   JTextField accnofld , ownerfld , balancefld , amountfld ;
           JComboBox<city> cities ;

        JButton newbtn , savebtn , showbtn , quitbtn , depositbtn , withdrawbtn ;
        JRadioButton male , female ;
        ButtonGroup genderbtngrp;
        JList<Account> accountslst;
        JPanel p1, p2,p3,p4,p5;

        Set<Account> accountset = new TreeSet<>();
        Account acc , x;
        boolean newrec = true;

        DefaultComboBoxModel<city> citycombox ;
        DefaultListModel<Account > accountlist;
        JTable table ;
        DefaultTableModel tableModel;
        ArrayList<Tranaction>  translist = new ArrayList<>();

    public AccountFrame()  {
   super ("Account Operation");
   setLayout(null);
   setSize(605,405);

          //adding components to frame
        //labels
        panel1= new JPanel();
        Border panel1tittle = BorderFactory.createTitledBorder("Customer Details ");
        panel1.setBorder(panel1tittle);
        accnolbl = new JLabel("Account No :");
        ownerlbl = new JLabel("Owner :");
        balancelbl = new JLabel("Balance :");
        citylbl = new JLabel("City :");
        genderlbl= new JLabel("Gender :");
        amountlbl = new JLabel("Amount :");
        genderlbl= new JLabel("Gender :");
        // textfilds
        accnofld = new JTextField();
        accnofld.setEnabled(false);
        ownerfld = new JTextField();
        balancefld= new JTextField();
        balancefld.setEnabled(false);
        amountfld = new JTextField();
        amountfld.setPreferredSize(new Dimension (150,25));
       //combo box
        citycombox = new DefaultComboBoxModel<>();
        citycombox.addElement(null);
        citycombox.addElement(new city("Uthukottai","Thiruvallur"));
        citycombox.addElement(new city("palavakam","thiruvallur"));
        citycombox.addElement(new city("soolameni","Thiruvallur"));
        citycombox.addElement(new city("periyapalayam","Thiruvallur"));
        //adding data to jcombobox
        cities= new JComboBox<city>(citycombox);
          // radio button
        male = new JRadioButton("Male",true);
        female = new JRadioButton("Female");
         genderbtngrp= new ButtonGroup();
         genderbtngrp.add(male);
         genderbtngrp.add(female);
  // button
        newbtn = new JButton("New");
        savebtn = new JButton("Save");
        showbtn = new JButton("Show ");
        quitbtn = new JButton("Quit");
        depositbtn = new JButton("Deposit");
        withdrawbtn = new JButton("Withdraw");
           //  table
        accountlist = new DefaultListModel<>();
        accountslst = new JList<>(accountlist);
                       //******* panels******//
        p1 = new JPanel(); p1.setBounds(5,5,300,150);
        p1.setLayout(new GridLayout(5,2));
        p2 = new JPanel(); p2.setBounds(5,155,300,40);
        p2.setLayout(new FlowLayout());
        p3 = new JPanel(); p3.setBounds(5,195,600,40);
        p3.setLayout(new FlowLayout());
        p4 = new JPanel(); p4.setBounds(305,5,300,190);
        p4.setLayout(new BorderLayout());
        p5 = new JPanel(); p5.setBounds(5,240,580,120);
        p5.setLayout(new BorderLayout());
        // making Opacity to the all Textfield
        accnofld.setOpaque(false); ownerfld.setOpaque(false); balancefld.setOpaque(false); amountfld.setOpaque(false);
        balancefld.setEnabled(false);

          // adding component to panel
     p1.add(accnolbl);
     p1.add(accnofld);
     p1.add(ownerlbl);
     p1.add(ownerfld);
     p1.add(balancelbl);
     p1.add(balancefld);
     p1.add(citylbl);
     p1.add(cities);
     p1.add(male);
     p1.add(female);


     p2.add(newbtn);
     p2.add(savebtn);
     p2.add(showbtn);
     p2.add(quitbtn);

     p3.add(amountlbl);
     p3.add(amountfld);
     p3.add(depositbtn);
     p3.add(withdrawbtn);

     p4.add(accountslst);

        //  table
        tableModel = new DefaultTableModel();
         table = new JTable(tableModel);
         tableModel.addColumn("TrsNo");
         tableModel.addColumn("TrsDate");
         tableModel.addColumn("TrsType");
         tableModel.addColumn("TrsAmount");

         JScrollPane scrollPane = new JScrollPane(table);
         p5.add(scrollPane);

        //adding panel to frame
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);


         /****************** FUNCTIONALITY ***************/
         newbtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 accnofld.setText("");
                 ownerfld.setText("");
                 cities.setSelectedIndex((0));
                 male.setSelected(true);
                 balancefld.setText("");
                 amountfld.setText("");
                 newrec= true;
             }
         });
          savebtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  if(newrec){
                      if (ownerfld.getText().length() !=0){
                          acc = new Account(
                                  ownerfld.getText(),
                                  (city) cities.getSelectedItem(),
                          male.isSelected()? 'M':'F');
                       accnofld.setText(String.valueOf(acc.accno));
                       accountset.add(acc);
                       accountlist.addElement(acc);
                       newrec = false;

                      }else{
                          JOptionPane.showMessageDialog(null,"please fill all fields");
                      }
                  }
                  else{
                      //updating
                      accountset.remove(acc);
                      int a = Integer.parseInt(accnofld.getText());
                      String o = ownerfld.getText();
                      city c = (city) cities.getSelectedItem();
                      char g = male.isSelected()?'M':'F';
                      double b = Double.parseDouble(balancefld.getText());
                      acc = new Account(a,o,c,g,b);
                      accountset.add(acc);
                      accountlist.setElementAt(acc, accountslst.getSelectedIndex());
                      newrec = false;
                  }
              }
          });
          quitbtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
               accnofld.setText(" ");
               ownerfld.setText(" ");
               balancefld.setText(" ");
               amountfld.setText(" ");
              }
          });

          showbtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  String s ="";
                  Iterator<Account> it = accountset.iterator();
                  while(it.hasNext()){
                      s+= it.next().toString()+"\n";
                      JOptionPane.showMessageDialog(null,s);
                  }
              }
          });
    depositbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!newrec && amountfld.getText().length() !=0){
                Tranaction t = new Tranaction(acc, LocalDate.now(),'D',
                        Double.parseDouble(amountfld.getText()));
                DisplayTranstionsintable(t);
                acc.deposit(Double.parseDouble(amountfld.getText()));
                balancefld.setText(String.valueOf(acc.balance));
            }
        }
    });

   withdrawbtn.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           if (!newrec && amountfld.getText().length() !=0){
               Tranaction t = new Tranaction(
                       acc,LocalDate.now(),
                       'W', Double.parseDouble(amountfld.getText())
               );
               DisplayTranstionsintable(t);

               acc.withdraw(Double.parseDouble(amountfld.getText()));
               balancefld.setText(String.valueOf(acc.balance));
           }
       }
   });
 accountslst.addListSelectionListener(new ListSelectionListener() {
     @Override
     public void valueChanged(ListSelectionEvent e) {
         acc = x = accountslst.getSelectedValue();
         accnofld.setText(String.valueOf(acc.accno));
         ownerfld.setText(acc.owner);
         cities.setSelectedItem(acc.city);
         if (acc.gender == 'M') male.setSelected(true);
         else female.setSelected(true);
         balancefld.setText(String.valueOf(acc.balance));
         amountfld.setEnabled(true);
         depositbtn.setEnabled(true);
         newrec = false ;

         // cleartable
         for ( int i=tableModel.getRowCount() - 1 ; i>0; i--){
             tableModel.removeRow(i);
         }
         searchtransctionlist(acc.accno);
     }
 });

        }

    private void searchtransctionlist(int accno) {
        List<Tranaction> filteredlist = new ArrayList<>();

        for (Tranaction t : translist){
            if (t.getAcc().accno==accno){
                filteredlist.add(t);
            }
        }

        // display//
        for (int i =0 ; i < filteredlist.size();i++){
            tableModel.addRow(new Object[]{
                    filteredlist.get(i).getTrsno(),
                    filteredlist.get(i).getDate(),
                    filteredlist.get(i).getOperation(),
                    filteredlist.get(i).getAmount(),
            });
        }

    }


    private void DisplayTranstionsintable(Tranaction t) {
        tableModel.addRow(new Object[]{
            t.getTrsno(),
        t.getDate(),
                t.getOperation(),
                t.getAmount()
        });

        translist.add(t);
    }

    public static void main(String[] args){
        AccountFrame mainframe = new AccountFrame();
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Project Execute Successfully !...");
        System.out.println("System working fine ! these nice  ! ...");
        }
}
