package Utils;

import org.testng.annotations.DataProvider;

public class DataUtils {
    @DataProvider( indices = {2}, parallel = !true)
    public static String[][] dataExample(){
        String[][] data=new String[3][2];
        data[0][0] ="Harini";
        data[0][1] ="Harini@123";

        data[1][0] ="Suganya";
        data[1][1] ="Suganya@123";

        data[2][0]="Administrator";
        data[2][1]="byteFactory@123";


        return data;
    }
    @DataProvider(name ="userDetails")
    public static String[][] userExample() {
        String[][] data1 = new String[1][6];
        data1[0][0] = "Harini";
        data1[0][1] = "IT Admin";
        data1[0][2] = "Harini1@gmail.com";
        data1[0][3] = "1234567890";
        data1[0][4] = "Harini@123";
        data1[0][5] = "TestingEntity";
        return data1;
    }
}
