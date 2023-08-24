package controller;




	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.Clinica_Medica.Clinica.entity.Consult;
	import com.Clinica_Medica.Clinica.entity.resources.InvalidConsultExecption;

	import service.ConsultService;
	import service.ServicePatient;
	@RestController
	@RequestMapping("/consultas")
	public class ConsultController {
		
		
	@Autowired
	private ConsultService consultService;

	//@Autowired
	//private ServicePatient servicePatient;

	@PostMapping("/schedule")
	public ResponseEntity<?> scheduleAppointment(@RequestBody Consult consult){
		try {
			Consult scheduleAppointment = consultService.scheduleAppointment(consult);
			
			return ResponseEntity.ok(scheduleAppointment);
		} catch (InvalidConsultExecption e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}

	@GetMapping("/list")
	public  List<Consult> consultList(){
		return consultService.consultList();
		
	}


	}

