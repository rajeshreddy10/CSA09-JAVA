public class SpecialChar{
public static void main(String[] args){
String s="r@je$# reddy!";
int count=0;
for (int i=0;i<s.length();i++){
       char ch=s.charAt(i);
       if(!(ch>='a'&&ch<='z') && 
       !(ch>='A'&&ch<='Z')&&
       !(ch>='0'&&ch<='9')&&
       (ch!=' ')){
       count++;
       }
    }
System.out.println("no of special characters are :: "+count);
}
}