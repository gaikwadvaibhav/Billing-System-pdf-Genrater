/**
 * Created by xtantransh on 29/7/17.
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class LoginScreen extends JFrame implements ActionListener {


    JButton btnlogin, btnreset, btnexit;
    JTextField jtfuser, jtfadd;
    JTextField jtfpass;
    JLabel jlabuser, jlabadd, jlabpass;

    Connection con= null;
    Statement stmt =null;
    ResultSet rs=null;
    String name,address;
    Scanner sc=new Scanner(System.in);
    void datacon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","vaibhav");
        stmt=con.createStatement();
    }

    //Inert/select sql queries

//    void insertdata() throws SQLException {
//        System.out.println("Enter usernamme = ");
//        String un=sc.next();
//        System.out.println("Enter password = ");
//        String up=sc.next();
//
//        int c= stmt.executeUpdate("insert into mytable values("+un+",'"+up+"')");
//        System.out.println(c);
//
//    }
//
//    void getdata() throws SQLException {
//
//        rs=stmt.executeQuery("select * from user");
//        while(rs.next()){
//            System.out.println("username "+rs.getString(1)+ " password "+rs.getString(2));
//
//        }
//
//    }
//

     void getdata(){
        name=jtfuser.getText();
         address=jtfadd.getText();

         System.out.println(name);
         System.out.println(address);
     }

     public LoginScreen(String name){
         super(name);
         btnlogin = new JButton("Login");
//        btnreset = new JButton("Reset");
//        btnexit = new JButton("Exit");

        jtfuser = new JTextField();
//        jtfpass= new JTextField();
         jtfadd=new JTextField();

        jlabuser= new JLabel("Name : ");
//        jlabpass = new JLabel("Password");
         jlabadd= new JLabel("Address  : ");

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE  );


         btnlogin.addActionListener(this);
//         btnreset.addActionListener(this);
//         btnexit.addActionListener(this);

         jlabuser.setBounds(10,10,120,20);
         jlabadd.setBounds(10,30,120,20);
//         jlabpass.setBounds(10,30,120,20);
         jtfuser.setBounds(140,10,200,20);
         jtfadd.setBounds(140,30,200,20);
//         jtfpass.setBounds(140,30,200,20);

         btnlogin.setBounds(140,55,100,20);
//         btnreset.setBounds(240,55,100,20);
//         btnexit.setBounds(340,55,100,20);

         this.add(jlabuser);
         this.add(jlabadd);
//         this.add(jlabpass);
         this.add(jtfuser);
         this.add(jtfadd);
//         this.add(jtfpass);
         this.add(btnlogin);
//         this.add(btnreset);
//         this.add(btnexit);

         this.setSize(500,100);
         this.setVisible(true);
     }


     void Createpdf(){

         Document document=new Document();
         try {
             PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
             document.open();
             document.add(new Paragraph("Welcome to CodeKul"));

             document.add(new Paragraph(name));
             document.add(new Paragraph(address));

             PdfPTable table=new PdfPTable(3);
             table.setWidthPercentage(105);
             table.setSpacingBefore(11f);
             table.setSpacingAfter(11f);

             float[] colWidth={2f,2f,2f};
             table.setWidths(colWidth);
             PdfPCell c1=new PdfPCell(new Paragraph(name));
             PdfPCell c2=new PdfPCell(new Paragraph(address));
             PdfPCell c3=new PdfPCell(new Paragraph("Column3"));
             table.addCell(c1);
             table.addCell(c2);
             table.addCell(c3);
             document.add(table);


             document.close();
             writer.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (DocumentException e) {
             e.printStackTrace();
         }
     }




    public static void main(String[] args) throws SQLException {
        LoginScreen ls=new LoginScreen("Welcome to Login Screen");
//        ls.getdata();
//        ls.insertdata();




    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        getdata();
         Createpdf();
        System.out.println("Data Inserted Succesfully");
    }
}
