/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediagnosis.pojos;

/**
 *
 * @author sofia
 */
public class Diagnosis {
    private int score=0; 
    private boolean questions= false;
     public enum Disease{
        ME, NMO, LYME, VITB12, SARCOIDOSIS, SLE, SJOGREN, CNS, NONE
    }
    private Disease disease = Disease.NONE;
    
    private boolean antiAQP4; 
    private int nMOCount=0;
    
    private boolean elisatest; 
    private int lymeCount=0; 
    
    private boolean vitB12; 
    private int vitB12Count=0; 
    
    private boolean ACE;
    private int sarcoidCount=0; 
    
    private boolean ANA; 
    private int sLECount=0; 
    
    private boolean antiSSARo; 
    private boolean antiSSBLa; 
    private int sjogrenCount=0; 
    
    private boolean ischeamicLesion; 
    private int cNSCount=0;

    public boolean isQuestions() {
        return questions;
    }

    public void setQuestions(boolean questions) {
        this.questions = questions;
    }

    public int getnMOCount() {
        return nMOCount;
    }

    public void setnMOCount(int nMOCount) {
        this.nMOCount = nMOCount;
    }

    public int getVitB12Count() {
        return vitB12Count;
    }

    public void setVitB12Count(int vitB12Count) {
        this.vitB12Count = vitB12Count;
    }

    public int getsLECount() {
        return sLECount;
    }

    public void setsLECount(int sLECount) {
        this.sLECount = sLECount;
    }

    public int getcNSCount() {
        return cNSCount;
    }

    public void setcNSCount(int cNSCount) {
        this.cNSCount = cNSCount;
    }
   

    public int getNMOCount() {
        return nMOCount;
    }

    public void setNMOCount(int nMOCount) {
        this.nMOCount = nMOCount;
    }

    public boolean isElisatest() {
        return elisatest;
    }

    public void setElisatest(boolean elisatest) {
        this.elisatest = elisatest;
    }

    public int getLymeCount() {
        return lymeCount;
    }

    public void setLymeCount(int lymeCount) {
        this.lymeCount = lymeCount;
    }

    public boolean isVitB12() {
        return vitB12;
    }

    public void setVitB12(boolean vitB12) {
        this.vitB12 = vitB12;
    }

    public int getvitB12Count() {
        return vitB12Count;
    }

    public void setvitB12Count(int vitB12Count) {
        this.vitB12Count = vitB12Count;
    }

    public boolean isACE() {
        return ACE;
    }

    public void setACE(boolean ACE) {
        this.ACE = ACE;
    }

    public int getSarcoidCount() {
        return sarcoidCount;
    }

    public void setSarcoidCount(int sarcoidCount) {
        this.sarcoidCount = sarcoidCount;
    }

    public boolean isANA() {
        return ANA;
    }

    public void setANA(boolean ANA) {
        this.ANA = ANA;
    }

    public int getSLECount() {
        return sLECount;
    }

    public void setSLECount(int sLECount) {
        this.sLECount = sLECount;
    }

    public boolean isAntiSSARo() {
        return antiSSARo;
    }

    public void setAntiSSARo(boolean antiSSARo) {
        this.antiSSARo = antiSSARo;
    }

    public boolean isAntiSSBLa() {
        return antiSSBLa;
    }

    public void setAntiSSBLa(boolean antiSSBLa) {
        this.antiSSBLa = antiSSBLa;
    }

    public int getSjogrenCount() {
        return sjogrenCount;
    }

    public void setSjogrenCount(int sjogrenCount) {
        this.sjogrenCount = sjogrenCount;
    }

    public boolean isIscheamicLesion() {
        return ischeamicLesion;
    }

    public void setIscheamicLesion(boolean ischeamicLesion) {
        this.ischeamicLesion = ischeamicLesion;
    }

    public int getCNSCount() {
        return cNSCount;
    }

    public void setCNSCount(int cNSCount) {
        this.cNSCount = cNSCount;
    }
    
    public Diagnosis() {
    }

    public boolean isAntiAQP4() {
        return antiAQP4;
    }

    public void setAntiAQP4(boolean antiAQP4) {
        this.antiAQP4 = antiAQP4;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
     public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
