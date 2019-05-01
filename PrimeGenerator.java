import java.util.*;
import java.lang.Math;


public class PrimeGenerator {


    private static boolean checkInputisNumber(String input) {
        try {
           double number = Double.parseDouble(input); 
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a number");
            return false;
        }

        return true;

    }

    private static double getNumber(boolean start) {
        String value;
        Scanner sc = new Scanner(System.in);
        do {
           
           String type = start ? "starting": "ending";
           System.out.print("Enter " + type  + " range('q' to quit): ");
           value = sc.nextLine();
           if (value.equals("q")) {
                System.exit(0);
           }
        } while(!checkInputisNumber(value));

        return Double.parseDouble(value);
        
    }

    private static double[] getInputArguments() {
        
        
        double[] values = new double[2]; 

        double value1 = getNumber(true); 
        double value2 = getNumber(false);
        
  
        

        values[0] = value1;
        values[1] = value2;
        return values;
        
    }

    private static double[] handleCmdLineArguments(String[] args) {
        int length = args.length;
        double value1;
        double value2;
        double values[] = new double[2];
        if  (length < 2) {
            System.out.println("If using command line arguments, need two arguments to specify range.\nAny arguments after 2 will be ignored");
            System.exit(1);
        } else {
            try {
                value1 = Double.parseDouble(args[0]);
                value2 = Double.parseDouble(args[1]);
            }
            catch(NumberFormatException e) {
                System.out.println("Please only enter numbers! One or more of your arguments was not number!");
                throw e;


            }
            
            
           

            values[0] = value1;
            values[1] = value2;
        }

        return values;
    }

    private static void printPrimes(PrimeGenerator pg,double startingValue,double endingValue) {
        System.out.println();
        int count = 0; 
        for(int a: pg.generate(startingValue,endingValue)) {
            System.out.print(Integer.toString(a) + " ");
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }


        }

        System.out.println("\n");
    }
    public static void main(String[] args) {
        PrimeGenerator pg = new PrimeGenerator();
        double startingValue = 0;
        double endingValue = 0;
        if (args.length > 0) {
            double[] arguments = handleCmdLineArguments(args);
            startingValue = arguments[0];
            endingValue = arguments[1];
        } else {
            while(true) {
              double[] arguments = getInputArguments();
              startingValue = arguments[0];
              endingValue = arguments[1];
              printPrimes(pg,startingValue,endingValue);
            }
        }

      printPrimes(pg,startingValue,endingValue);

    }

    public List<Integer> generate(double startingValue,double endingValue) {

    	if (startingValue < 0) {
            startingValue = 0;
        }
        if (endingValue < 0) {
           endingValue = 0;
        }
        
        double temp = startingValue;
        startingValue = Math.min(startingValue,endingValue);
        endingValue = Math.max(temp,endingValue);

        int trueStartingValue = (int)(Math.ceil(startingValue));
        int trueEndingValue = (int)(Math.floor(endingValue));
        Set<Integer> marked = new HashSet<Integer>();

        marked.add(0);
        marked.add(1);

        int end= (int)(Math.ceil(Math.sqrt(endingValue + 1)));
        for(int n =2; n < end; n += 1) {
           if (marked.contains(n)) {
                continue; 
           }

           for(int j=n*n; j < trueEndingValue + 1; j += n) {
                if (j % n == 0) {
                    marked.add(j);
                }
           }
        }
        
        List<Integer> primes = new ArrayList<Integer>();
        for(int i = trueStartingValue; i < trueEndingValue + 1; i++) {
           if (isPrime(i,marked)) {
                primes.add(i);
           }
        }

        return primes;
    }

    private boolean isPrime(int value,Set<Integer> marked) {

        return !marked.contains(value);
    }

}
