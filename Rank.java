public class Rank{
public static void main(String[] args){
int m1=90;
int m2=91;
int m3=92;
int m4=93;
int sum=m1+m2+m3+m3;
float agg=sum/4f;
System.out.println("sum of  marks: "+sum);
System.out.println("average of marks: "+agg);
if(agg>75)
System.out.println("distinction ra baabu Njoy !");
else if (agg>=60 && agg<75)
System.out.println("first division ra babu !");
else if(agg>=50 && agg<60)
System.out.println("second division ra babu !");
else if(agg>=40 && agg<50)
System.out.println("third division  ra babu !");
else
System.out.println("fail ra puka");
}
}