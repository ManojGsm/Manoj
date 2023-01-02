import java.util.*;
//---------------Thread Factorial-------------------
class Factorial extends Thread{
int n;
Factorial(String name,int n){
super(name);                      //calling thread class constructor
this.n=n;
System.out.println("Thread name of 1st thread : "+this.getName()+" and priority :"+this.getPriority());
}
public void run() {
int s=1;
for(int i=1;i<=n;i++) {
s*=i;
System.out.println("Thread 1->Factorial of "+i+" is : "+s);
if(i==n)
System.err.println("Thread 1 Exiting....");
try {
Thread.sleep(1500);
}catch(Exception e) {
System.out.println(e);
}}}}
//----------------Thread Even Numbers------------------
class Even extends Thread{

int n;
Even(String name,int n){
super(name);               //calling thread class constructor
this.n=n;
System.out.println("Thread name of 2nd thread : "+this.getName()+" and priority :"+this.getPriority());
}
public void run() {
for(int i=1;i<=n;i++) {
if(i%2==0)
System.out.println("Thread 2->Even Number Between 1-"+n+" : "+i);
if(i==n)
System.err.println("Thread 2 Exiting....");
try {
Thread.sleep(1500);
}
catch(Exception e) {
System.out.println(e);
}}}}
//-----------Thread fibonacci---------------------------------
class Fibo implements Runnable{
int n;
String name;
    Thread t;                 // giving reference variable as Thread
Fibo(String name,int n){
this.name=name;
this.n=n;
t=new Thread(this,name);     //creating new thread object
System.out.println("Thread name of 3rd thread : "+t.getName()+" and priority :"+t.getPriority());
}
public void run() {
int a=0,b=1,c=a+b;

System.out.println("Thread 3->Fibonacci series until 1 "+c);
for(int i=2;i<=n;i++) {
a=i;
b=c;
c=a+b;
System.out.println("Thread 3->Fibonacci series until "+i+" :"+c);
if(i==n)
System.err.println("Thread 3 Exiting....");
try {
Thread.sleep(1500);
}
catch(Exception e) {
System.out.println(e);}}}}

//---------Main class-------------------
public class TThread {

public static void main(String[] args) {
int n1,n2,n3;
String name1,name2,name3;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Name for 1st Thread : ");
name1=sc.next();
System.out.println("Enter the number to print its factorial : ");
n1=sc.nextInt();
System.out.println("Enter the Name for 2nd Thread : ");
name2=sc.next();
System.out.println("Enter a number to print the even numbers between 1 to the entered number");
n2=sc.nextInt();
System.out.println("Enter the name for 3rd Thread : ");
name3=sc.next();
System.out.println("Enter the number for printing fibonacci series : ");
n3=sc.nextInt();
Factorial t1=new Factorial(name1,n1);     //creating thread objects with thread name
Even t2=new Even(name2,n2);
Fibo t3=new Fibo(name3,n3);
System.out.println("Thread 1 status : "+t1.isAlive()); //isalive to check the threadstatus
System.out.println("Thread 2 status : "+t2.isAlive());
System.out.println("Thread 3 status : "+t3.t.isAlive());
System.out.println("-----3 Threads are Started--------");
t1.start();                  //starting the threads
t2.start();
t3.t.start();
System.out.println("Thread 1 status : "+t1.isAlive());
System.out.println("Thread 2 status : "+t2.isAlive());
System.out.println("Thread 3 status : "+t3.t.isAlive());
try {
System.err.println("----Main Thread stopped untill all threads are completly runed---");
t1.join();          //using join function to stop the execution of main thread
t2.join();
t3.t.join();
}
catch(Exception e) {
System.out.println(e);
}
System.out.println("Thread 1 status : "+t1.isAlive());
System.out.println("Thread 2 status : "+t2.isAlive());
System.out.println("Thread 3 status : "+t3.t.isAlive());
System.out.println("All threads are successfully Runned");
System.out.println("Main thread resumed");
}
}
