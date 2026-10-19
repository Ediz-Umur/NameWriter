import java.util.Scanner;
public class NameWriter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
//uppercase -> lowercase
//lowercase -> uppercase
//upper amount
//lower amount
//if nameUpper == surnameUpper and nameLength = surnameLength or middleUpper == surnameUpper and middleLength == surnameLength; print "Şanslısın!"
//if both conditions print "Çok Şanslısın"
//toplam sesli ve sessiz harfleri say, sesli mi sessiz mi daha çok bul
        String name;
        String surname;
        String middleName;
        System.out.println("What is your name?");
        name = scanner.nextLine();

        System.out.println("What is your middle name? (Write no if you don't have one)");
        middleName = scanner.nextLine();

        System.out.println("What is your surname?");
        surname = scanner.nextLine();

        int nameLength = name.length();
        int surnameLength = surname.length();
        int middleLength = middleName.length();

        int nameUpper = 0;
        int surnameUpper = 0;
        int middleUpper = 0;

        int consonant = 0;
        int vowel = 0;

//Writing the first name down
        int letterCounter = 0;
        int repetitionCounter = 0;
        char testedChar;
        while(letterCounter < nameLength){
            testedChar = name.charAt(letterCounter);
            if(isUpper(testedChar)){
                nameUpper++;
            }
            if(isVowel(testedChar)){
                vowel++;
            } else {
                consonant++;
            }
            testedChar = Swap(testedChar);
            while(repetitionCounter <= letterCounter){
                System.out.print(testedChar);
                repetitionCounter++;
            }
            System.out.println();
            repetitionCounter = 0;
            letterCounter++;
        }
//Writing the middle name down if it exists
        if(!middleName.equals("no")){
            letterCounter = 0;
            repetitionCounter = 0;
            while(letterCounter < middleLength){
                testedChar = middleName.charAt(letterCounter);
                if(isUpper(testedChar)){
                    middleUpper++;
                }
                if(isVowel(testedChar)){
                    vowel++;
                } else {
                    consonant++;
                }
                testedChar = Swap(testedChar);
                while(repetitionCounter <= middleLength - letterCounter - 1){
                    System.out.print(testedChar);
                    repetitionCounter++;
                }
                System.out.println();
                repetitionCounter = 0;
                letterCounter++;
            }
        }

//Writing the surname down
        letterCounter = 0;
        repetitionCounter = 0;
        while(letterCounter < surnameLength){
            testedChar = surname.charAt(surnameLength - letterCounter - 1);
            if(isUpper(testedChar)){
                surnameUpper++;
            }
            if(isVowel(testedChar)){
                vowel++;
            } else {
                consonant++;
            }
            testedChar = Swap(testedChar);
            while(repetitionCounter <= letterCounter){
                System.out.print(testedChar);
                repetitionCounter++;
            }
            System.out.println();
            repetitionCounter = 0;
            letterCounter++;
        }
//Messages for uppercase amounts
        if((nameLength == surnameLength && nameUpper == surnameUpper)&&(middleLength == surnameLength && middleUpper == surnameUpper)){
            System.out.println("You are extremely lucky! Your name, middle name and last name all had the same length and uppercase amount!!!");
        } else if(nameLength == surnameLength && nameUpper == surnameUpper){
            System.out.println("You are lucky! Your name and surname had the same length and uppercase amount!");
        } else if(middleLength == surnameLength && middleUpper == surnameUpper){
            System.out.println("You are lucky! Your middle name and surname had the same length and uppercase amount!");
        }

//Messages for vowel and consonants
        if(vowel > consonant){
            System.out.println("You're total name, surname and middle name has more vowels than consonants");
        } else if(consonant > vowel){
            System.out.println("You're total name, surname and middle name has more consonants than vowels");
        } else {
            System.out.println("You're really lucky! Your total name, surname and middle name has the same amount of vowels and consonants!");
        }
    }
    //Returns whether the selected character is uppercase or not
    public static boolean isUpper(char c){
        int ascii = c;
        return ascii > 63 && ascii < 91;
    }

    //Turns the character into lowercase if its uppercase, and vice versa
    public static char Swap(char c){
        if(isUpper(c)){
            return (char)((int)c + 32);
        } else {
            return (char)((int)c - 32);
        }
    }

    //Returns whether the charcter is a vowel or not
    public static boolean isVowel(char c){
        int ascii = c;
        return ascii == 65 || ascii == 69 || ascii == 73 || ascii == 79 || ascii == 85
                || ascii == 65+32 || ascii == 69+32 || ascii == 73+32 || ascii == 79+32 || ascii == 85+32;
    };
}