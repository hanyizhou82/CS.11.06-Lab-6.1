import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {

        int[] depth = readFile(fileName);
        int count =0;
        for (int i = 1; i<depth.length; i++) {
            if (depth[i]>depth[i - 1]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {

        int[] depth = new int[countLinesInFile(fileName)];
        depth = readFile(fileName);
        int counter = 0;
        for(int i = 1; i<depth.length-2; i++){
            if(depth[i+2] >depth[i-1]){ // (simplified)
                counter++;
            }
        }
        return counter;

    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {

        String[] array = readFileStr(fileName);
        int x = 0;
        int y = 0;
        for(int i = 0; i < array.length; i++){
            String currentInstruction = array[i];
            String[] splitInstructions = currentInstruction.split(" ");

            if(splitInstructions[0].equals("forward")){
                x += Integer.parseInt(splitInstructions[1]);
            }
            else if(splitInstructions[0].equals("down")){
                y += Integer.parseInt(splitInstructions[1]);
            }
            else{
                y -= Integer.parseInt(splitInstructions[1]);
            }
        }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
            String[] myArray = readFileStr(filename);
            int horizontal = 0;
            int deep = 0;
            int goal = 0;
            for(int i=0;i<myArray.length;i++){
                String[] otherArray = myArray[i].split("");
                if(otherArray[0].equals("forward ")){
                    int d = Integer.parseInt(otherArray[1])*goal;
                    horizontal+=Integer.parseInt(otherArray[1]);
                    deep+=d;
                }
                if(otherArray[0].equals("down ")){
                    goal+=Integer.parseInt(otherArray[1]);
                }
                if(otherArray[0].equals("up ")){
                    goal-=Integer.parseInt(otherArray[1]);
                }
            }
            return deep*horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFileStr(String inputFilename) throws FileNotFoundException {
            File file = new File(inputFilename);
            Scanner scanner = new Scanner(file);
            int numberOfLinesInFile = countLinesInFile(inputFilename);
            String [] data = new String[numberOfLinesInFile];
            int index = 0;
            while (scanner.hasNextLine()) {
                data[index++] = scanner.nextLine();
            }
            scanner.close();
            return data;
        }
    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}