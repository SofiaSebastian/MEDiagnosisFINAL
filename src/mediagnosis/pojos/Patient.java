package mediagnosis.pojos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sofia
 */
public class Patient {
    
    private String name; 
    private int age; 
    private int id; 
    private Diagnosis diagnosis;
    private McDonaldCriteria mcdonald; 

    public McDonaldCriteria getMcdonald() {
        return mcdonald;
    }

    public void setMcdonald(McDonaldCriteria mcdonald) {
        this.mcdonald = mcdonald;
    }
    

    public Patient(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id= id ;
        this.diagnosis= new Diagnosis();
    }
    public Patient(){
        this.diagnosis=new Diagnosis();
        this.mcdonald= new McDonaldCriteria();
    }
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
