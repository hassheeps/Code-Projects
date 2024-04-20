import java.io.*; 
import java.util.Scanner; 

public class conversion {
    public static void main (String[] args)
    {
        convertNumber();
    }
    
    /**
     * Converts a number from an integer to a roman numeral
     * 
     */
    public static void convertNumber(){

        int numberToConvert = getNumberInput();
        String result = getRomanNumeral(numberToConvert);

        System.out.println(result);

        repeatProgram();
    } // end convertNumber()

    /**
     *  Prompts the user for a number input.
     * 
     * @return user number input
     */
    public static int getNumberInput(){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the number you wish to convert:");

        int numberInput = 0;

        try {
            numberInput = Integer.parseInt(userInput.nextLine());    
        } catch (Exception e) {
            System.out.println("Invalid entry. Please enter a number to convert.");
            convertNumber();
        }

        if(numberInput <= 0){
            System.out.println("Please enter a whole number greater than 0.");
            convertNumber();
        }
        
        return numberInput;
        
    } // end getNumberInput()
        
    /*
     *  Calculates the roman numeral version of the user's number input.
     * 
     * @param the user's number input
     */
    public static String getRomanNumeral(int numberInput){
        
        String romanNumeral = new String();

        if(numberInput >= 1000){
            for(int i = numberInput/1000; i > 0; i--){
                romanNumeral += "M";
                numberInput = numberInput - 1000;
            }
        }
        if(numberInput >= 500){
            romanNumeral += "D";
            numberInput = numberInput - 500;

        }
        if(numberInput >= 100){
            for(int i = numberInput/100; i > 0; i--){
                romanNumeral += "C";
                numberInput = numberInput - 100;
            }
        }
        if(numberInput >= 50){
            for(int i = numberInput/50; i > 0; i--){
                romanNumeral += "L";
                numberInput = numberInput - 50;
            }
        }
        if(numberInput >= 10){
            for(int i = numberInput/10; i > 0; i--){
                romanNumeral += "X";
                numberInput = numberInput - 10;
            } 
        }
        if(numberInput == 9){
            romanNumeral += "IX";
            numberInput = numberInput - 9;
        }
        if(numberInput >= 5){
            romanNumeral += "V";
            numberInput = numberInput - 5;
        }
        if(numberInput == 4){
            romanNumeral += "IV";
            numberInput = numberInput - 4;
        }
        if(numberInput < 4){
            for(int i = numberInput; i > 0; i--){
                romanNumeral += "I";
            }
        }

        return romanNumeral;

    } // end getRomanNumeral()

    /*
     *  Determines whether the user wishes to run the program again.
     */
    public static void repeatProgram(){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Convert another number? Y/N");

        char repeat = userInput.nextLine().toUpperCase().charAt(0);

        if(repeat == 'Y'){
            convertNumber();
        }
        if(repeat == 'N'){
            System.out.println("Thank you for using Brianne's converter tool!");
            System.exit(0);
        }
        else{
            System.out.println("Invalid entry. Please enter Y or N");
            repeatProgram();
        }
    }

} // end Conversion Class



