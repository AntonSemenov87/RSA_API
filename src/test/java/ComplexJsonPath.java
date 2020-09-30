
import files.Payload;
import io.restassured.path.json.JsonPath;

import java.util.Iterator;

public class ComplexJsonPath {
    public static void main(String[] args) {

        JsonPath js = new JsonPath(Payload.coursePrice());

       // 1. Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println("Courses number: " + count);

        //2.Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total purchase amount: " + purchaseAmount);

       // 3. Print Title of the first course
        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println(firstCourseTitle);

       // 4. Print All course titles and their respective Prices
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            int price = js.get("courses[" + i + "].price");
            System.out.println(courseTitles + " " + price);
        }


      //  5. Print no of copies sold by RPA Course (and also total of all copies)
        int numOfCopies = 0;
        for (int i = 0; i < count; i++) {
            numOfCopies += js.getInt("courses["+i+"].copies");
        }
        System.out.println("Number of copies sold total: " + numOfCopies);
        int numOfRPACopies = js.getInt("courses[2].copies");
        System.out.println(numOfRPACopies);

       // 6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int price = js.get("courses[" + i + "].price");
            int quantity = js.getInt("courses[" + i + "].copies");
            sum += price * quantity;
        }
        System.out.println("Total amount of these books is: " + sum);


    }
}
