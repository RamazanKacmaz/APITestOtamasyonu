package Tests;

import baseUrl.BaseUrldummyexampel;
import org.junit.Test;
import pojos.PojoDummyExampleData;

public class C33_Get_Pojo extends BaseUrldummyexampel {
            /*
            http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status": "success",
        "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }
             */

    @Test
    public void test(){
        specDummyExampel.pathParams("pp1","employee","pp1","3");

        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3,"Ashton Cox",86000,66,"");




    }

}
