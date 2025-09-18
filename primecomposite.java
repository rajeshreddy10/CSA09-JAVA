public class primecomposite{
    public static void main(String[] args){
        int[] arr={2,4,5,9,11,15,17,1,0};
        int pc=0;
        int cc=0;
        for(int num:arr){
        if(num<=1){
            continue;
        }
            int c=0;
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    c++;
                }
            }
            if(c==2){
                pc++;
            }else{
                cc++;
            }
        }
        System.out.println("prime numbers: "+pc);
        System.out.println("composite numbers: "+cc);
    }
}