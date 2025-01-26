package model;

import javax.persistence.CascadeType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Patient {

public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String Name;

    @Column(name = "age", nullable = false, length = 50)
    private int age;
   

   @Column(name = "gender", unique = true, nullable = false, length = 100)
    private String gender;

   @Column(name = "diagnosis", nullable = false, length = 15)
    private String diagnosis;

   
    // Define relationship with Appointments
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    
    private Appointment appointment;


	public Patient(String name, int age,String gender, String diagnosis) {
		super();
		Name = name;
     	this.age=age;
		this.gender = gender;
		this.diagnosis = diagnosis;
		
	}


public Patient(int updateId, String updateName, int updateAge, String updateGender, String updateDiagnosis) {
		// TODO Auto-generated constructor stub
	}


@Override
	public String toString() {
		return "Patient [id=" + id + ", Name=" + Name + ", age=" + age + ", gender=" + gender + ", diagnosis="
				+ diagnosis + "]";
	}


public String getName() {
	// TODO Auto-generated method stub
	return null;
}



}
