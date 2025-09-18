public class TaxCal{
    public static void main(String[] args){
        int income=1500;
        double tax;
        if(income<=150000)
        System.out.println("no tax --happy--");
        else if(income>=150001 && income<=300000)
            System.out.println("tax is "+income/10);
        else if(income>=300001 && income<=500000)
            System.out.println("tax is "+income/20);
        else 
            System.out.println("tax is "+income/30);
    }
}