package Testing;

import org.testng.annotations.Test;

public class TestNGAttribute {

        @Test
        public void Test1() {
            System.out.println("SignIn");
        }
        @Test(dependsOnMethods = "Test1")
        public void Test2 () {
            System.out.println("login");
        }

        @Test(dependsOnMethods = "Test2")
        public void Test3 () {
            System.out.println("Search");
        }
        @Test(dependsOnMethods = "Test2")
        public void Test4 () {
            System.out.println("Add");
        }
        @Test(dependsOnMethods = "Test1")
        public void Test5 () {
            System.out.println("SignUp");
        }
        @Test(dependsOnMethods = "Test1")
        public void Test6 () {
        System.out.println("Close");
        }

}
