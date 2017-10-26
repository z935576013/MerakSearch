package exec;


import com.alibaba.fastjson.JSON;
import com.sdx.merak.service.inft.hotel.dto.SaveResultParm;
import com.sdx.merak.service.inft.hotel.dto.SearchScoreRes;

import merak.hotel.search.HotelSearchServiceImpl;

public class DubboStarter2 {

	public static void main(String[] args) {
		HotelSearchServiceImpl service = new HotelSearchServiceImpl();
//		String str="{\"country\":\"中国\",\"countryCode\":\"\",\"facilitiesCount\":4,\"facilitiesList\":[\"functional-gym\",\"functional-freeparkinglot\",\"functional-m_business\",\"functional-baggage\"],\"largestFunctionRoomReq\":[\"x_sunshine\"],\"largestFunctionRoomReqCount\":0.5,\"largestMeetingSize\":77.69999999999999,\"nearList\":[],\"secondFunctionRoomReq\":[\"b_upright\"],\"secondFunctionRoomReqCount\":0.5,\"secondMeetingSize\":14,\"starHigh\":5,\"starLow\":3,\"totalGuestRoomNum\":17.5}";
//		SearchParm searchParm = JSON.parseObject(str,SearchParm.class);
//		service.search1(searchParm);
		
		
		
//		String str2="{\"largestAvReq\":\"microphone,soundsystem\",\"preferencesLargestMeetingAv\":0,\"twinRoom\":100,\"max3rdMeetingFunctionRoomReq\":[\"nopillar,nodividableroom,naturaldaylight\"],\"reqMeetingRoomArea4max2ndMeetingRoomSize\":160,\"preferencesSecondMeetingSetUp\":0,\"reqMeetingRoomArea4maxMeetingRoomSize\":200,\"preferencesLargestMeetingSetUp\":0,\"distanceSetting\":10,\"max3rdMeetingSize\":[\"100\"],\"facilityPercent\":30,\"largestFbMeetingSize\":[],\"preferencesFacility\":0,\"preferencesSecondMeetingSize\":1,\"locationLot\":121.475137,\"kingRoom\":20,\"preferencesLargestMeetingFbLocation\":0,\"runOfHorse\":0,\"locationTermsPercent\":10,\"largestFbFunctionRoomReq\":[],\"preferencesLargestMeetingSize\":1,\"preferencesLocation\":1,\"locationLat\":31.232781,\"hotelIds\":[\"376\",\"309\",\"518\"],\"suite\":10,\"secondFunctionRoomReq\":\"nopillar,nodividableroom,naturaldaylight\",\"largestFunctionRoomReq\":\"nodividableroom,caraccess\",\"facilitiesList\":[\"functional-freeparkinglot\",\"functional-m_business\"],\"customerTagCount4facilityNum\":2,\"preferencesGuestNumber\":1}";
//		SaveResultParm searchParm = JSON.parseObject(str2,SaveResultParm.class);
//		SearchScoreRes result=service.saveSearchResult1(searchParm);
//		System.out.println(JSON.toJSONString(result));
	}
}
