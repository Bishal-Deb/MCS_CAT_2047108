import java.util.*;
class Person{
	String name;
    int age;
    String address;

    Person(){

    }

    Person(String name,int age, String address){
        this.name = name;
        this.age=age;
        this.address=address;
    }

    Person(Person per) { 
        this.name = per.name;
        this.age = per.age;
        this.address = per.address;
    } 

    void read(){
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Name : ");  
        this.name= sc.nextLine();

        System.out.print("Enter Age : ");  
        this.age= sc.nextInt();

        System.out.print("Enter address :");  
        this.address= sc.nextLine();
    }
    void show(){

        System.out.println("Name - "+this.name);
        System.out.println("Age - "+this.age + " years old");
    }
}
class Employee extends Person{
    
    Random rnum = new Random();
    String empID= "2020/"+rnum.nextInt(10000);
    String CompanyName;
    String Department;
    String Designation;


    void read(){
        super.read();

        Scanner sc= new Scanner(System.in);

        System.out.print("Employee ID : " + empID + "\n");  

        System.out.print("Company Name : ");  
        this.CompanyName= sc.nextLine();

        System.out.print("Department :");  
        this.Department= sc.nextLine();

        System.out.print("Designation :");  
        this.Designation= sc.nextLine();
    }

    void show(){
        super.show();
        System.out.println("EmployeeID - "+this.empID);
        System.out.println("Company Name - "+this.CompanyName);
        System.out.println("Department - "+this.Department);
        System.out.println("Designation - "+this.Designation);
    }
}
class EmployeeSalary extends Employee{
    double Basic;
    double HRA;
    double DA;
    double PF;
    double IT;
    
    double NetSalary;

    public void read(){
    	super.read();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");
        Basic= Double.parseDouble(scn.nextLine());
        System.out.print("Enter HRA: ");
        HRA= Double.parseDouble(scn.nextLine());
        System.out.print("Enter DA: ");
        DA= Double.parseDouble(scn.nextLine());
        System.out.print("Enter PF: ");
        PF= Double.parseDouble(scn.nextLine());
        System.out.print("Enter IT: ");
        IT= Double.parseDouble(scn.nextLine());

    }

    public Double NetSalary(){
        Double grossSalary, deduction;
        grossSalary = Basic + HRA + DA;
        deduction = PF + IT;
        NetSalary = grossSalary - deduction;
        super.show();
        System.out.println("Net Salary is- "+NetSalary);
        return NetSalary;
    }
}

public class CIA1{

    public static void main(String args[])  
    { 
        System.out.print("Enter Number of Employee you want to enter details for: ");
        Scanner sn = new Scanner(System.in);
        int n_emp = Integer.parseInt(sn.nextLine());
        EmployeeSalary[] obj1 = new EmployeeSalary[n_emp];
        for (int i=0;i<n_emp;i++){
            obj1[i] = new EmployeeSalary();
            System.out.printf("---------Enter Employee %d Details---------\n",i+1);
            obj1[i].read();
            }
           
        for(EmployeeSalary n:obj1){
            n.NetSalary();
        }

        System.out.println("-----------Thank You!!-----------");
        
    }
}
