public class sumuntilminusonearray{
    public static void main(String[] args) {
        int numbers[]={10,-10,20,-20,30,-30,40,-40,-1,1,50,-50};
        int poscount=0,negcount=0;
        int possum=0,negsum=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==-1){
                break;
            }
            if(numbers[i]>0){
                possum+=numbers[i];
                poscount++;
            }
            else{
                negsum+=numbers[i];
                negcount++;
            }
        }
        int avgpos=possum/poscount;
        int avgneg=negsum/negcount;
        System.out.println("Positive sum is: "+possum);
        System.out.println("Negative sum is: "+negsum);
        System.out.println("Average of positive numbers is: "+avgpos);
        System.out.println("Average of negative numbers is: "+avgneg);
    }
}