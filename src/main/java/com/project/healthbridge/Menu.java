package com.project.healthbridge;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;

import model.Patient;
import model.Doctor;
import model.Appointment;
import serviceimpl.PatientServiceimpl;
import serviceimpl.DoctorServiceimpl;
import serviceimpl.AppointmentServiceimpl;

public class Menu {
    private  PatientServiceimpl patientsService = new PatientServiceimpl();
    private  DoctorServiceimpl doctorsService = new DoctorServiceimpl();
    private  AppointmentServiceimpl appointmentsService = new AppointmentServiceimpl();

    public  void showMainMenu() throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--HEALTH BRIDGE SYSTEM--");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    managePatients(scanner);
                    break;
                case 2:
                    manageDoctors(scanner);
                    break;
                case 3:
                    manageAppointments(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void managePatients(Scanner scanner) throws  IOException {
        int choice;
        do {
            System.out.println("\n--- Manage Patients ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient by ID");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    viewPatientById(scanner);
                    break;
                case 3:
                    patientsService.getAllPatients().forEach(System.out::println);
                    break;
                case 4:
                    updatePatient(scanner);
                    break;
                case 5:
                    deletePatient(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
    
	private int getIntInput(Scanner scanner) {
		// TODO Auto-generated method stub
		while(true) {
			try {
				return Integer.parseInt(scanner.nextLine());
						
			}catch
			
		(NumberFormatException e) {
				System.out.println("invalid input.pls enter a valid integer.");
			}
			}
	}
	
//	here use the crud operation operation for manage the patient

	private  void addPatient(Scanner scanner) throws NumberFormatException,IOException {
    	 
    	 System.out.println("Enter patient details: Name, Age, Gender, Diagnosis");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         System.out.print("Enter the Name: ");
         String patname = br.readLine();

         System.out.print("Enter the Age: ");
         int age = Integer.parseInt(br.readLine());

         System.out.print("Enter the Gender: ");
         String gender = br.readLine();

         System.out.print("Enter the Diagnosis: ");
         String diagnosis = br.readLine();

         Patient newPatient = new Patient(patname, age, gender, diagnosis);
//         patientsService.addPatient(newPatient);
         System.out.println("Patient added successfully: " + newPatient);
     }

     private void viewPatientById(Scanner scanner) throws IOException {
         System.out.print("Enter Patient ID: ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int id = Integer.parseInt(br.readLine());
         Patient patient = patientsService.getPatientById(id);
         System.out.println(patient != null ? patient : "Patient not found!");
     }

     private void viewAllPatients() {
         System.out.println("All Patients:");
         List<Patient> patients = patientsService.getAllPatients();
         if (patients.isEmpty()) {
             System.out.println("No patients found.");
         } else {
             for (Patient patient : patients) {
                 System.out.println(patient);
             }
         }
     }

     private void updatePatient(Scanner scanner) throws IOException {
         System.out.print("Enter Patient ID to update: ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int updateId = Integer.parseInt(br.readLine());

         System.out.println("Enter updated details: Name, Age, Gender, Diagnosis");
         System.out.print("Enter the Name: ");
         String updateName = br.readLine();

         System.out.print("Enter the Age: ");
         int updateAge = Integer.parseInt(br.readLine());

         System.out.print("Enter the Gender: ");
         String updateGender = br.readLine();

         System.out.print("Enter the Diagnosis: ");
         String updateDiagnosis = br.readLine();

         Patient updatedPatient = new Patient(updateId, updateName, updateAge, updateGender, updateDiagnosis);
         patientsService.updatePatient(updatedPatient);
         System.out.println("Patient updated successfully!");
     }

     private void deletePatient(Scanner scanner) throws IOException {
         System.out.print("Enter Patient ID to delete: ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int deleteId = Integer.parseInt(br.readLine());
         patientsService.deletePatient(deleteId);
         System.out.println("Patient deleted successfully!");
     }
     	 
// 	here use the crud operation operation for manage the doctor

    private  void manageDoctors(Scanner scanner) throws IOException {
        int choice;
        do {
            System.out.println("\n--- Manage Doctors ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctor by ID");
            System.out.println("3. View All Doctors");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    viewDoctorById(scanner);
                    break;
                case 3:
                    doctorsService.getAllDoctors().forEach(System.out::println);
                    break;
                case 4:
                    updateDoctor(scanner);
                    break;
                case 5:
                    deleteDoctor(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private  void addDoctor(Scanner scanner) throws IOException {
        System.out.println("Enter doctor details: Name, Specialization, Experience");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("Enter the Name: ");
        String docName = br.readLine();
        System.out.println("Enter the Specialization: ");
        String specialization = br.readLine();
        System.out.println("Enter the Experience: ");
        int experience = Integer.parseInt(br.readLine());

        Doctor newDoctor = new Doctor(  docName, specialization, experience);
        
        doctorsService.addDoctor(newDoctor);
       System.out.println("Doctor " + newDoctor);
        System.out.println("Doctor added successfully!");
    }


    
    
     private  void viewDoctorById(Scanner scanner) {
        System.out.println("Enter Doctor ID: ");
        int Id = getIntInput(scanner);
        Doctor doctor = doctorsService.getDoctorById(Id);
        System.out.println(doctor != null ? doctor : "Doctor not found!");
    }
    
    private  void  viewAllDoctor() {
    	System.out.println("All Doctors:");
    	 List<Doctor> doctors=doctorsService.getAllDoctors();
    	 for (Doctor Doctor:doctors) {
    		 System.out.println("Patients not found.");
    	 }
    }
    
    private  void updateDoctor(Scanner scanner) throws NumberFormatException, IOException {
        System.out.println("Enter Doctor ID to update: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
       int updateId = Integer.parseInt(br.readLine());
       		 
        System.out.println("Enter updated details: Name, Specialization, Experience");
        System.out.print("Enter the Name: ");
        String updateName = br.readLine();
        System.out.println("Enter the Specialization: ");
        String updateSpecialization = br.readLine();
        System.out.println("Enter the Experience: ");
        int updateExperience = getIntInput(scanner);

       Doctor updatedDoctor = new Doctor(updateId,updateName, updateSpecialization, updateExperience);
      
       doctorsService.updateDoctor(updatedDoctor);
        System.out.println("Doctor updated successfully!");
    }

   private  void deleteDoctor(Scanner scanner) {
       System.out.println("Enter Doctor ID to delete: ");
        int deleteId = getIntInput(scanner);
        doctorsService.deleteDoctor(deleteId);
        System.out.println("Doctor deleted successfully!");
    }


//	here use the crud operation operation for manage the appointments

    private  void manageAppointments(Scanner scanner) throws NumberFormatException, IOException {
        int choice;
        do {
            System.out.println("\n--- Manage Appointments ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View All Appointments");
            System.out.println("4. Update Appointment");
            System.out.println("5. Delete Appointment");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addAppointment(scanner);
                    break;
                case 2:
                    viewAppointmentById(scanner);
                    break;
                case 3:
                    appointmentsService.getAllAppointments().forEach(System.out::println);
                    break;
                case 4:
                    updateAppointment(scanner);
                    break;
                case 5:
                    deleteAppointment(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
      } while (choice != 6);        
   }
     
    
    private  void addAppointment(Scanner scanner) throws NumberFormatException, IOException {
      
        System.out.println("Enter appointment details: Patient ID, Doctor ID, Notes");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Enter the patientId");
        int patientId = Integer.parseInt(br.readLine());
        System.out.println("Enter the doctorId");
        int doctorId = Integer.parseInt(br.readLine());
//        System.out.println("Enter Appointment Date: ");
//        String dateStr = br.readLine();
        System.out.println("Enter Notes: ");
        String notes = br.readLine();

        try {
            Appointment newAppointment = new Appointment(
                patientsService.getPatientById(patientId),
                doctorsService.getDoctorById(doctorId)
  
                
            );
            appointmentsService.addAppointment(newAppointment);
            System.out.println("Appointment added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding appointment: " + e.getMessage());
        }
    }
private  void viewAppointmentById(Scanner scanner) {
        System.out.println("Enter Appointment ID: ");
        int id = getIntInput(scanner);
        Appointment appointment = appointmentsService.getAppointmentById(id);
        System.out.println(appointment != null ? appointment : "Appointment not found!");
    }

    private  void updateAppointment(Scanner scanner) throws NumberFormatException, IOException {
        System.out.println("Enter Appointment ID to update: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
        int updateId =Integer.parseInt(br.readLine());
        System.out.println("Enter updated details: Patient ID, Doctor ID, Appointment Date (yyyy-MM-dd)");
        
        int updPatientId = getIntInput(scanner);
        int updDoctorId = getIntInput(scanner);
        scanner.nextLine(); 
        System.out.println("Enter updated Appointment Date: ");
        String updDateStr = br.readLine();

        try {
            Appointment updatedAppointment = new Appointment(
                patientsService.getPatientById(updPatientId),
                doctorsService.getDoctorById(updDoctorId)
            );
            updatedAppointment.setId(updateId);
            appointmentsService.updateAppointment(updatedAppointment);
            System.out.println("Appointment updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating appointment: " + e.getMessage());
        }
    }

    private  void deleteAppointment(Scanner scanner) {
        System.out.println("Enter Appointment ID to delete: ");
        int deleteId = getIntInput(scanner);
        appointmentsService.deleteAppointment(deleteId);
        System.out.println("Appointment deleted successfully!");
    }


    }



