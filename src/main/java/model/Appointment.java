package model;


import java.sql.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor; // Assuming you have a Doctor class


    @Column(name = "notes", length = 255)
    private String notes;
    
    
      @Override
    public String toString() {
        return "Appointment [id=" + id + ", patient=" + patient.getName() + ", doctor=" + doctor.getName() + 
                ", notes=" + notes + "]";
    }
    

	public Appointment( Patient patient, Doctor doctor) {
		super();
		
		this.patient = patient;
		this.doctor = doctor;
	
		this.notes = notes;
	}
}