package mediagnosis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sofia
 */
import mediagnosis.pojos.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.KieServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            KieServices ks = KieServices.Factory.get();
            KieContainer kc = ks.getKieClasspathContainer();
            KieSession kieSession = kc.newKieSession("mediagnosisKSession");
            
            Patient patient1= new Patient("Sofia",20,70834217);
            
            Diagnosis diag= new Diagnosis();
            diag.setAntiAQP4(true);
            diag.setACE(false);
            diag.setANA(false);
            diag.setAntiSSARo(false);
            diag.setAntiSSBLa(true);
            diag.setElisatest(false);
            diag.setIscheamicLesion(false);
            diag.setVitB12(false);
            //diag.setQuestions(true);
            patient1.setDiagnosis(diag);
            
            DoubleVision dvision= new DoubleVision();
            EyeDiscomfort eyedisc = new EyeDiscomfort();
            VisionLossOneEye vlossOne = new VisionLossOneEye();
            LossOfBalance lossbalan = new LossOfBalance();
            MuscleSpasm muscspasm= new MuscleSpasm();
            NumbnessOrAbnormalSensation numbness= new NumbnessOrAbnormalSensation();
            ChewingAndSwallowingProblems chew= new ChewingAndSwallowingProblems();
            Constipation constip = new Constipation();
            CoordinationProblems coord = new CoordinationProblems();
            DecreasedAbilityToDiscern discern = new DecreasedAbilityToDiscern();
            DecreasedAttentionSpan attention = new DecreasedAttentionSpan();
            Depression dep = new Depression();
            DifficultyStartingUrination urinat = new DifficultyStartingUrination();
            Dizziness dizz = new Dizziness();
            ElectricShocksNeckMovement shock= new ElectricShocksNeckMovement();
            FacialPainOrParalysis facial = new FacialPainOrParalysis();
            FecalIncontinence fecal = new FecalIncontinence();
            FrequentUrination frequrin= new FrequentUrination();
            InvoluntaryEyeMovement invEye= new InvoluntaryEyeMovement();
            MemoryLoss memory = new MemoryLoss();
            MuscleStiffness stiff = new MuscleStiffness();
            PoorlyArticulatedSpeech speech = new PoorlyArticulatedSpeech();
            ProblemsMovingArmsAndLegs arms=new ProblemsMovingArmsAndLegs();
            SevereFatigue fatigue= new SevereFatigue();
            SexualDysfunction sexual = new SexualDysfunction();
            TinglingOrItchingArmsAndLegs tingling= new TinglingOrItchingArmsAndLegs();
            UrinaryIncontinence uriIncon= new UrinaryIncontinence();
            VaginalLubricationProblems vaginal = new VaginalLubricationProblems(); 
            WalkingDifficulties walking = new WalkingDifficulties();
            

            invEye.setPresence(true);
            vlossOne.setPresence(true);
            lossbalan.setPresence(true);
            numbness.setPresence(true);
            //facial.setPresence(true);
           // tingling.setPresence(true);
            arms.setPresence(true);
            walking.setPresence(true);
            coord.setPresence(true);
            //stiff.setPresence(true);
            shock.setPresence(true);
            fatigue.setPresence(true);
            frequrin.setPresence(true);
            uriIncon.setPresence(true);
            memory.setPresence(true);
            dizz.setPresence(true);
            sexual.setPresence(true);
            speech.setPresence(true);
//            dizz.setPresence(true);
//            //speech.setPresence(true);
//            chew.setPresence(true);
//            
            
            McDonaldCriteria mcdonald= new McDonaldCriteria();
            mcdonald.setInfratentLesion(false);
            mcdonald.setJuxtacortLesion(false);
            mcdonald.setPeriventLesion(false);
            mcdonald.setSpinalLesion(false);
            mcdonald.setTimedisemination(true);
//            mcdonald.setExists(true);
            patient1.setMcdonald(mcdonald);
            
            
            kieSession.insert(patient1);
            kieSession.insert(diag);
            kieSession.insert(mcdonald);
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
            
            kieSession.dispose();
            System.out.println(patient1.getId());
            System.out.println(patient1.getDiagnosis().getDisease());

            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
