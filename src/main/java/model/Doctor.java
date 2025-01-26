package model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Table(name = "doctors")
public class Doctor {

	public Doctor(int updateId, String updateName, String updateSpecialization, int updateExperience) {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@Column(name = "name", nullable = false, length = 50)
    private String Name;

    
    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;
    
    @Column(name = "experience", nullable = false, length = 100)
    private int experience;
    
   
    // Define relationship with Appointments
    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Appointment appointment;

public Doctor( String name, String specialization, int experience) {
		super();
		this.id = id;
		Name = name;
		this.specialization = specialization;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", Name=" + Name + ", specialization=" + specialization + ", experience="
				+ experience + "]";
	}

public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
   
}

