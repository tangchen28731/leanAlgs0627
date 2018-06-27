package learn.testAlgs;
/**
 * 二分查找
 * */
public class BinaryRepresentation {
    public static String binaryRepresentation(String n) {
        // write your code here
        String numIs = n.substring(0,n.indexOf("."));
        String numDs = "0"+n.substring(n.indexOf("."),n.length());
        int numI = Integer.parseInt(numIs);
        Double numD = Double.valueOf(numDs);
        String tz = "";
        int numIc = 0;
        System.out.println("start");
        while(numI != 1){
            numIc = numI%2;
            numI = numI/2;
            tz = numIc + tz;
            System.out.println("tz= "+tz);
        }
        tz = "1"+tz;
        System.out.println("tz= "+tz);
        int i = 0;
        int numDi = 0;
        String tx = "0.";
        while(i<=32 && numD != 1.0){
            numD = numD*2;
            numDi = (int)Math.floor(numD);
            numD = numD - numDi;
            System.out.println("numDi= "+numDi);
            tx = tx + numDi;
            System.out.println("tx= "+tx);
            i++;
        }
        if(i > 32){
            return "ERROR";
        }
        return tz + tx.substring(tx.indexOf("."),tx.length());
    }
    public static void main(String[] args) {
        System.out.println(binaryRepresentation("4.47"));
    }
}
