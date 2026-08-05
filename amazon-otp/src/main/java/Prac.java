//import com.amazon.controller.OtpController;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.amazon.entity.OtpEntity;
//import com.amazon.repository.OtpRepository;
//import com.amazon.request.OtpRequest;
//import com.amazon.request.OtpResponse;
//import com.amazon.request.VerifyOtpRequest;
//
//public class Prac {
//
//}
//
//@Service
//class OtpService{
//	private final OtpController otpController;
//	final OtpRepository  otpRepository;
//	
//	public OtpService(OtpRepository otpRepository, OtpController otpController) {
//		this.otpRepository = otpRepository;
//		this.otpController = otpController;
//	}
//	
//	public OtpResponse saveOtp(String name, String mobile) {
//		
//		int otp = generateOtp();
//		
//		OtpEntity ent = new OtpEntity();
//		ent.setMobile(mobile);
//		ent.setName(name);
//		ent.setStatus("active");
//		ent.setOtp(otp);
//		
//		OtpEntity savedEnt = otpRepository.save(ent);
//		
//		if(savedEnt.getId() > 0 ) System.out.println("ent got saved");
//		
//		OtpResponse res = new OtpResponse();
//		res.setOtp(otp);
//		res.setStatus(savedEnt.getStatus());
//		res.setValid("valid for 5 mins");
//		
//		return res;
//	}
//	
//	public ResponseEntity<Map<String, String>> checkValidOtp(VerifyOtpRequest req) {
//		List<OtpEntity> ents = otpRepository.findByMobile(req.getMobile());
//		for(OtpEntity ent: ents)
//			if(ent.getOtp() == req.getOtp())
//				return ResponseEntity.ok(Map.of("message","valid-otp"));
//		return ResponseEntity.ok(Map.of("message","invalid-otp"));
//	}
//	
//	public int generateOtp() {return 0;};
//}
//class OtpResponse{
//	int otp;
//	String status;
//	String valid;
//	public int getOtp() {
//		return otp;
//	}
//	public void setOtp(int otp) {
//		this.otp = otp;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getValid() {
//		return valid;
//	}
//	public void setValid(String valid) {
//		this.valid = valid;
//	}
//	
//	
//}
//
//class verifyOtpRequest{
//	String mobile;
//	int otp;
//	public String getMobile() {
//		return mobile;
//	}
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//	public int getOtp() {
//		return otp;
//	}
//	public void setOtp(int otp) {
//		this.otp = otp;
//	}
//	
//}
//
//@RestController
//@RequestMapping("/otp")
//class OtpController{
//	
//	private final OtpService otpService;
//	public OtpController(OtpService otpService) {
//		this.otpService = otpService;
//	}
//	
//	@PostMapping("/generate")
//	public OtpResponse generateOtp(@RequestBody OtpRequest otpRequest) {
//		String name = otpRequest.getName();
//		String mobile = otpRequest.getMobile();
//		
//		return otpService.saveOtp(name, mobile);
//	}
//	
//	@PostMapping("/verify")
//	public ResponseEntity<Map<String, String>> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest){
//		return otpService.checkValidOtp(verifyOtpRequest);
//	}
//	
//}
//
//
//
