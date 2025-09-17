public class convertions {
    public static void main(String[] args) {
        int decimal = 25;  
        String binary = Integer.toBinaryString(decimal);
        String octal = Integer.toOctalString(decimal);
        System.out.println("Decimal Number: " + decimal);
        System.out.println("Binary Equivalent: " + binary);
        System.out.println("Octal Equivalent: " + octal);
    }
}
