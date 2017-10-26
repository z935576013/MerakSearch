package com.sdx.merak.service.intf.fractionAlgorithm.dto.req;

import java.io.Serializable;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.BookingTermsReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.FacilityReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.LocationReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.RateReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.ServiceReq;

/**
 * 报价排序参数
 * 算法最外层入参
 * @author yeegor
 *
 */
public class AlgorithmReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** location（位置） **/
	private LocationReq locationReq;
	/** Rate(价格) **/
	private RateReq rateReq;
	/** Booking Terms(预定条款） **/
	private BookingTermsReq bookingTermsReq;
	/** service（服务） **/
	private ServiceReq serviceReq;
	/** Facility (设施） **/
	private FacilityReq facilityReq;
	
	public LocationReq getLocationReq() {
		return locationReq;
	}
	public void setLocationReq(LocationReq locationReq) {
		this.locationReq = locationReq;
	}
	public RateReq getRateReq() {
		return rateReq;
	}
	public void setRateReq(RateReq rateReq) {
		this.rateReq = rateReq;
	}
	public BookingTermsReq getBookingTermsReq() {
		return bookingTermsReq;
	}
	public void setBookingTermsReq(BookingTermsReq bookingTermsReq) {
		this.bookingTermsReq = bookingTermsReq;
	}
	public ServiceReq getServiceReq() {
		return serviceReq;
	}
	public void setServiceReq(ServiceReq serviceReq) {
		this.serviceReq = serviceReq;
	}
	public FacilityReq getFacilityReq() {
		return facilityReq;
	}
	public void setFacilityReq(FacilityReq facilityReq) {
		this.facilityReq = facilityReq;
	}
	
}
