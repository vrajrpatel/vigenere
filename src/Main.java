import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = input.next();
        System.out.println("Enter a key");
        String key = input2.next();



                int strLen = str.length();
                char strArray[] = new char[strLen];
                char keyArray[] = new char[strLen];
                char newKey[] = new char[strLen];
                char encryptedMsg[] = new char[strLen];
                char decryptedMsg[] = new char[strLen];

        for(int i = 0; i < str.length(); i++){
            strArray[i] = str.charAt(i);
        }

        //creates an array of our key characters
        for(int i = 0; i < key.length(); i++){
            keyArray[i] = key.charAt(i);
        }
//generate new key in cyclic manner equal to the length of original message
                for(int i = 0, j = 0; i < strLen; ++i, ++j){
                    if(j == keyArray.length)
                        j = 0;
                    newKey[i] = keyArray[j];
                }
//encryption
                for(int i = 0; i < strLen; ++i)
                    encryptedMsg[i] = (char)(((strArray[i] + newKey[i]) % 26) + 'A');
//decryption
                for(int i = 0; i < strLen; ++i)
                    decryptedMsg[i] = (char)((((encryptedMsg[i] - newKey[i]) + 26) % 26) + 'A');
                System.out.println("Original Message: " + String.valueOf(str)); //String.valueOf() converts character array to String
                System.out.println("Key: " + String.valueOf(key));
                System.out.println("Generated Key: " + String.valueOf(newKey));
                System.out.println("\nEncrypted Message: " + String.valueOf(encryptedMsg));
                System.out.println("\nDecrypted Message: " + String.valueOf(decryptedMsg));



    }
}