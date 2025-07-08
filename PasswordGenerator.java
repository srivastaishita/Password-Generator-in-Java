import java.util.Random;

public class PasswordGenerator {
    public static final String UPPERCASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE="abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS="0123456789";
    public static final String SPECIAL="!@#$%^&*()-_=+[]{};:,.<>/?";

    private final Random random;
    public PasswordGenerator(){
        random=new Random();

    }

    public String passwordgen(int length, boolean uppercase, boolean lowercase, boolean numbers, boolean special){
        StringBuilder password=new StringBuilder();

        String validchar="";
        if(uppercase) validchar+=UPPERCASE;
        if(lowercase) validchar+=LOWERCASE;
        if(numbers) validchar+=NUMBERS;
        if(special) validchar+=SPECIAL;

        for(int i=0;i<length;i++){
           int ranindex=random.nextInt(validchar.length());
           char rancharacter=validchar.charAt(ranindex);
           password.append(rancharacter);
        }
        return password.toString();
    }
}
