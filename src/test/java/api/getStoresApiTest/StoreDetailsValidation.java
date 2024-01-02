package api.getStoresApiTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.call.Call;
import api.response.GetStoresResponse;
import io.restassured.path.json.JsonPath;

public class StoreDetailsValidation extends Call{

	/**
	 * 
	 * <b>Title:</b> Verify all the store details <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores with valid access token<p> 
	 * <b>Test assertions:</b> Verified all the store details<p>
	 * <b>Expected result:</b><p>
	 * 1. All the stores details should be received<p>
	 * <b>Apis used:</b> <p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","merchantMobile2"})
	@Test
	public void getStoreDetailsVerification(String env, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		//response = getStoreResponse(pdata.getSdkPropertydata("multistoreAccessToken"),"0");
		
		response = getStoreResponse(pdata.getSdkPropertydata(env+"SuspendedAccessToken"),"0");
   
		String jsonString = response.getBody().asString();
		JSONObject jo=new JSONObject(jsonString);
		GetStoresResponse j1= new GetStoresResponse();
         System.out.println(jo.toString());
     	ObjectMapper om = new ObjectMapper();
     	
     	if(env.equalsIgnoreCase("dev"))
     	{
     	Assert.assertEquals(om.readTree(jo.toString()), om.readTree(j1.getStoresResponse("0", 20, 1, "2023-12-22T10:16:30.492Z", "2023-12-22T10:18:00.426Z", 
     			"dfcd2b28-c01d-4a97-856f-7ddb8cae3289", "DEFAULT", "test", "test", 
     			"IN1 947", "Banglore", true, true).toString()) );	
     	}
     	else if(env.equalsIgnoreCase("uat"))
     	{
     	Assert.assertEquals(om.readTree(jo.toString()), om.readTree(j1.getStoresResponse("0", 20, 1, "2023-12-22T10:16:30.492Z", "2023-12-22T10:18:00.426Z", 
     			"dfcd2b28-c01d-4a97-856f-7ddb8cae3289", "DEFAULT", "test", "test", 
     			"IN1 947", "Banglore", true, true).toString()) );	
     	}
     	else if(env.equalsIgnoreCase("prod"))
     	{
     	Assert.assertEquals(om.readTree(jo.toString()), om.readTree(j1.getStoresResponse("0", 20, 1, "2024-01-01T12:26:11.914Z", "2024-01-01T12:30:03.312Z", 
     			"b6aeddb4-f0b7-47bb-b144-4008d5ff3ddd", "Store 1", "test", "test", 
     			"T EST", "test", true, true).toString()) );	
     	}
     	
	}
	
	/**
	 * 
	 * <b>Title:</b> Verify pagination for getStores api response<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores with valid access token<p> 
	 * <b>Test assertions:</b> <p>
	 * 1. Verified the number of ids per page<p>
	 * 2. Verified all the store names
	 * <b>Expected result:</b><p>
	 * 1. 20 stores details should displayed per page<p>
	 * <b>Apis used:</b> <p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Test
	public void getStorePaginationCheck() throws IOException, JSONException, InterruptedException
	{
		response = getStoreResponse(pdata.getSdkPropertydata("multistoreAccessToken"),"0");
		
		JsonPath json=response.jsonPath();
		List<String>ids = json.getList("data.id");
		List<String>locations = json.getList("data.locationName");
		Assert.assertEquals(ids.size(), 20);
		int totalStores = JsonPath.from(response.getBody().asString()).get("totalCount");
		int size = JsonPath.from(response.getBody().asString()).get("size");
		int i=0;
		for(int storeNumber=totalStores;storeNumber>((totalStores-size)+1);storeNumber--)
		{
			Assert.assertEquals(locations.get(i++),"Store"+storeNumber);
		}
		
		response = getStoreResponse(pdata.getSdkPropertydata("multistoreAccessToken"),"1");
		
		JsonPath json1=response.jsonPath();
		List<String>ids1= json1.getList("data.id");
		Assert.assertEquals(ids1.size(), 2);
		int totalStores1 = JsonPath.from(response.getBody().asString()).get("totalCount");
		int size1 = JsonPath.from(response.getBody().asString()).get("size");
		int i1=0;
		for(int storeNumber=totalStores1;storeNumber>((totalStores1-size1)+1);storeNumber--)
		{
			Assert.assertEquals(locations.get(i++),"Store"+storeNumber);
		}
		
	}
	
}
