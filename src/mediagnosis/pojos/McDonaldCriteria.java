/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediagnosis.pojos;

/**
 *
 * @author sofia
 */
public class McDonaldCriteria {
    private boolean exists= false; 
    private int lesionCount=0; 
    private boolean spacedisemination; 
    private boolean periventLesion; 
    private boolean juxtacortLesion; 
    private boolean infratentLesion; 
    private boolean spinalLesion; 
    
    private boolean timedisemination; 
    
    private boolean discardDiagnosis; 

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public boolean isSpacedisemination() {
        return spacedisemination;
    }

    public boolean isDiscardDiagnosis() {
        return discardDiagnosis;
    }

    public void setSpacedisemination(boolean spacedisemination) {
        this.spacedisemination = spacedisemination;
    }

    public void setDiscardDiagnosis(boolean discardDiagnosis) {
        this.discardDiagnosis = discardDiagnosis;
    }
    

    public McDonaldCriteria() {
    }

    public int getLesionCount() {
        return lesionCount;
    }

    public void setLesionCount(int lesionCount) {
        this.lesionCount = lesionCount;
    }

    public boolean isPeriventLesion() {
        return periventLesion;
    }

    public void setPeriventLesion(boolean periventLesion) {
        this.periventLesion = periventLesion;
    }

    public boolean isJuxtacortLesion() {
        return juxtacortLesion;
    }

    public void setJuxtacortLesion(boolean juxtacortLesion) {
        this.juxtacortLesion = juxtacortLesion;
    }

    public boolean isInfratentLesion() {
        return infratentLesion;
    }

    public void setInfratentLesion(boolean infratentLesion) {
        this.infratentLesion = infratentLesion;
    }

    public boolean isSpinalLesion() {
        return spinalLesion;
    }

    public void setSpinalLesion(boolean spinalLesion) {
        this.spinalLesion = spinalLesion;
    }

    public boolean isTimedisemination() {
        return timedisemination;
    }

    public void setTimedisemination(boolean timedisemination) {
        this.timedisemination = timedisemination;
    }
    
    
}
