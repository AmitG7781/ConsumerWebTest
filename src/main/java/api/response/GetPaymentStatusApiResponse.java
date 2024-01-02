package api.response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPaymentStatusApiResponse {
	
	public JSONObject getStoresResponse(String page, int size, int totalCount,String createdAt, String updatedAt,
			String id, String locationName, String addressLine1, String addressLine2, String addressPostalCode,
			String cityOrTown, boolean primary, boolean enabled) throws JSONException
	{
		
		JSONObject jo = new JSONObject();
		jo.put("createdAt",createdAt);
		jo.put("updatedAt",updatedAt);
		jo.put("id",id);
		jo.put("locationName",locationName);
		jo.put("addressLine1",addressLine1);
		jo.put("addressLine2",addressLine2);
		jo.put("addressPostalCode",addressPostalCode);
		jo.put("cityOrTown",cityOrTown);
		jo.put("primary",primary);
		jo.put("enabled",enabled);
		jo.put("images", new JSONArray());
				
		JSONArray ja=new JSONArray();
		ja.put(jo);
		
		JSONObject jo2 = new JSONObject();
		jo2.put("data", ja);
		jo2.put("size", size);
		jo2.put("page", page);
		jo2.put("totalCount", totalCount);

			return jo2;
	}
	
}