package stepDefinitions;

import org.hamcrest.MatcherAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class stepDefinitions{
	
	public static RequestSpecification req;
	public static Response response;
	//public static ResponseBody body;
	String baseURI = "https://open.er-api.com/v6/latest/USD";
	String invalidbaseURI = "https://open.er-api.com/v6/latest/";


	@Given("user makes a call to API Endpoint URL")
	public void user_makes_a_call_to_api_endpoint_url() {
		RestAssured.baseURI = baseURI;
		req = RestAssured.given();
	}
	
	@Then("the API response should have status code {int}")
	public void the_API_response_should_have_status_code (Integer int1) throws CustomException {		
		response = req.get(baseURI);
		
		int responseReturned = response.statusCode();
		if(responseReturned != int1)
		{
			throw new CustomException("Rates Returned Count Mistmatched !!   Actual Value :="+responseReturned+  " Expected Value := "+int1 );
		}
	}
	
	@Then("Check API Response Time")
	public void Check_API_Response_Time() {
		long startTime = System.currentTimeMillis();
		RestAssured.baseURI = baseURI;
		req = RestAssured.given();
		response = req.get(baseURI);
		
		int responseReturned = response.statusCode();
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        long currentTimeInSeconds = System.currentTimeMillis() / 1000;

        if (responseTime < (currentTimeInSeconds + 3)) {
            System.out.println("Response time is less than 3 seconds from the current time.");
        } else {
            System.out.println("Response time is greater than or equal to 3 seconds from the current time.");
        }
    } 
	
	
	@Then("the response should have valid price for {string} : {string}")
	public void the_response_should_have_valid_price_for(String jsonPath,String expectedValue) throws CustomException
	{
		String[] words = {"USD","BBD","BMD","BSD","BZD","CUP","ERN","PAB"};
		boolean flag= false;
		response = req.get(baseURI);
		//body = response.getBody();
		//System.out.println("Response from URL:="+body.asString());
		JsonPath jsonPathEvaluator = response.jsonPath();
		for (String item : words) {
			if (jsonPath.contains(item)) {
				flag= true;
				break;
			}
	    }
		if(flag == true)
		{
			
	    	int rates = jsonPathEvaluator.get(jsonPath);
	    	String stringfrates=String.valueOf(rates);
	    	
	    	if(!stringfrates.contains(expectedValue))
	    	{
	    		throw new CustomException("Rates from Response of value for := "+jsonPath+"  its Actual Value :="+stringfrates+  " and Expected Value := "+expectedValue );
	    	}
		}
		else
		{
			float frates = jsonPathEvaluator.get(jsonPath);
	    	String stringfrates=String.valueOf(frates);
	    	if(!stringfrates.contains(expectedValue))
	    	{
	    		throw new CustomException("Rates from Response of value for := "+jsonPath+"  its Actual Value :="+stringfrates+  " and Expected Value := "+expectedValue );
	    	}
		}	
	} 
	
	@Then("the response should have valid count of Currency pairs {int}")
	public void the_response_should_have_valid_count_of_Currency_pairs(int expectedValue) throws CustomException
	{
		JsonPath jsonPathEvaluator = response.jsonPath();
		int returnedValue = jsonPathEvaluator.get("rates.size()");
	
		if(returnedValue != expectedValue)
		{
			throw new CustomException("Rates Returned Count Mistmatched !!   Actual Value :="+returnedValue+  " Expected Value := "+expectedValue );
		}
	}
	
	@Then("Validate the response returns valid price in range for {string} is between {string} to {string}")
	public void Validate_the_response_returns_valid_price_in_range_for(String value,String range1,String range2) throws CustomException
	{
		String[] words = {"USD","BBD","BMD","BSD","BZD","CUP","ERN","PAB"};
		boolean flag= false;
		response = req.get(baseURI);
		//body = response.getBody();
		float frange1 = convertingStringToFloat(range1);
		float frange2 = convertingStringToFloat(range2);
		//System.out.println("Response from URL:="+body.asString());
		JsonPath jsonPathEvaluator = response.jsonPath();
		for (String item : words) {
			if (value.contains(item)) {
				flag= true;
				break;
			}
	        
	    }
		if(flag == true)
		{
	    	int rates = jsonPathEvaluator.get(value);
	    	String stringfrates=String.valueOf(rates);
	    	float floatVal = convertingStringToFloat(stringfrates);
	    	
	    	if(floatVal <= frange2 && floatVal >= frange1)
	    	{
	    		System.out.println("For Currency:= "+value+":="+ "response value is := "+stringfrates+" is in the price range of"+range1+ "-"+range2);
	    	}
	    	else
	    	{
	    		throw new CustomException("For Currency:= "+value+":="+ " response value is := "+stringfrates+" is NOT in the price range of "+range1+ "-"+range2);
	    	}
		}
		else
		{
			float frates = jsonPathEvaluator.get(value);
	    	String stringfrates=String.valueOf(frates);
	    	float floatVal = convertingStringToFloat(stringfrates);
	    	
	    	if(floatVal <= frange2 && floatVal >= frange1)
	    	{
	    		System.out.println("For Currency:= "+value+":="+ "response value is := "+stringfrates+" is in the price range of"+range1+ "-"+range2);
	    	}
	    	else
	    	{
	    		throw new CustomException("For Currency:= "+value+":="+ " response value is := "+stringfrates+" is NOT in the price range of "+range1+ "-"+range2);
	    	}
		}	
	} 
	
	public static float convertingStringToFloat(String str)
    {
        return Float.parseFloat(str);
    }
	
	@Then("validate the schema of the response returned {string}")
	public void validate_the_schema_of_the_response_returned(String jsonFile) throws CustomException //throws CustomException, ProcessingException, IOException
	{
		MatcherAssert.assertThat(
	            "Validate json schema",
	            response.getBody().asString(),
	            JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonFile)
				);	
	}
	
}
