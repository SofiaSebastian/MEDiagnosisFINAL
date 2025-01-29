/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediagnosis;

import java.util.Map;
import javax.swing.JCheckBox;
import mediagnosis.pojos.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Clase principal de la interfaz gráfica.
 * @author sofia
 */
public class FinalMain {
     public static void main(String[] args) {
        new DiagnosisApp();
    }
     public static Patient insertSession(KieSession kieSession,Patient patient, DoubleVision dvision, EyeDiscomfort eyedisc, VisionLossOneEye vlossOne, LossOfBalance lossbalan, MuscleSpasm muscspasm,
             NumbnessOrAbnormalSensation numbness, ChewingAndSwallowingProblems chew, Constipation constip, CoordinationProblems coord, DecreasedAbilityToDiscern discern, 
             DecreasedAttentionSpan attention, Depression dep, DifficultyStartingUrination urinat, Dizziness dizz, ElectricShocksNeckMovement shock, FacialPainOrParalysis facial,
             FecalIncontinence fecal, FrequentUrination frequrin, InvoluntaryEyeMovement invEye, MemoryLoss memory,MuscleStiffness stiff, PoorlyArticulatedSpeech speech, ProblemsMovingArmsAndLegs arms, 
             SevereFatigue fatigue, SexualDysfunction sexual, TinglingOrItchingArmsAndLegs tingling, UrinaryIncontinence uriIncon,VaginalLubricationProblems vaginal,WalkingDifficulties walking){
        Diagnosis diag= new Diagnosis();
        diag=patient.getDiagnosis();
        McDonaldCriteria mcdonald= new McDonaldCriteria();
        mcdonald=patient.getMcdonald();
        kieSession.insert(patient);
        kieSession.insert(diag);
        kieSession.insert(mcdonald);
        kieSession.insert(patient.getDiagnosis());
        kieSession.insert(patient.getMcdonald());
        kieSession.insert(dvision);
        kieSession.insert(eyedisc);
        kieSession.insert(vlossOne);
        kieSession.insert(lossbalan);
        kieSession.insert(muscspasm);
        kieSession.insert(numbness);
        kieSession.insert(chew);
        kieSession.insert(constip);
        kieSession.insert(coord);
        kieSession.insert(discern);
        kieSession.insert(attention);
        kieSession.insert(dep);
        kieSession.insert(urinat);
        kieSession.insert(dizz);
        kieSession.insert(shock);
        kieSession.insert(facial);
        kieSession.insert(fecal);
        kieSession.insert(frequrin);
        kieSession.insert(invEye);
        kieSession.insert(memory);
        kieSession.insert(stiff);
        kieSession.insert(speech);
        kieSession.insert(arms);
        kieSession.insert(fatigue);
        kieSession.insert(sexual);
        kieSession.insert(tingling);
        kieSession.insert(uriIncon);
        kieSession.insert(vaginal);
        kieSession.insert(walking);
        
        kieSession.fireAllRules();
        return patient;
     }
     
     

}
