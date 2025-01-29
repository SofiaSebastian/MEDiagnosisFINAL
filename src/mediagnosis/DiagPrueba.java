/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediagnosis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mediagnosis.pojos.ChewingAndSwallowingProblems;
import mediagnosis.pojos.Constipation;
import mediagnosis.pojos.CoordinationProblems;
import mediagnosis.pojos.DecreasedAbilityToDiscern;
import mediagnosis.pojos.DecreasedAttentionSpan;
import mediagnosis.pojos.Depression;
import mediagnosis.pojos.Diagnosis;
import mediagnosis.pojos.DifficultyStartingUrination;
import mediagnosis.pojos.Dizziness;
import mediagnosis.pojos.DoubleVision;
import mediagnosis.pojos.ElectricShocksNeckMovement;
import mediagnosis.pojos.EyeDiscomfort;
import mediagnosis.pojos.FacialPainOrParalysis;
import mediagnosis.pojos.FecalIncontinence;
import mediagnosis.pojos.FrequentUrination;
import mediagnosis.pojos.InvoluntaryEyeMovement;
import mediagnosis.pojos.LossOfBalance;
import mediagnosis.pojos.McDonaldCriteria;
import mediagnosis.pojos.MemoryLoss;
import mediagnosis.pojos.MuscleSpasm;
import mediagnosis.pojos.MuscleStiffness;
import mediagnosis.pojos.NumbnessOrAbnormalSensation;
import mediagnosis.pojos.Patient;
import mediagnosis.pojos.PoorlyArticulatedSpeech;
import mediagnosis.pojos.ProblemsMovingArmsAndLegs;
import mediagnosis.pojos.SevereFatigue;
import mediagnosis.pojos.SexualDysfunction;
import mediagnosis.pojos.TinglingOrItchingArmsAndLegs;
import mediagnosis.pojos.UrinaryIncontinence;
import mediagnosis.pojos.VaginalLubricationProblems;
import mediagnosis.pojos.VisionLossOneEye;
import mediagnosis.pojos.WalkingDifficulties;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author sofia
 */
public class DiagPrueba {
   

    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea resultArea;
    private Map<String, JCheckBox> symptomCheckboxes;
    private Patient patient;
    private Diagnosis diagnosis;

    public DiagPrueba() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Multiple Sclerosis Diagnosis System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);

        
        JPanel symptomPanel = new JPanel(new GridLayout(0, 1));
        symptomPanel.setBorder(BorderFactory.createTitledBorder("Select Symptoms"));

        symptomCheckboxes = new HashMap<>();
        String[] symptoms = {
            "Double Vision", "Eye Discomfort","Involuntary Eye Movement", "Vision Loss (One Eye At A Time)", "Loss Of Balance","Muscle Spasm",
            "Severe Fatigue","Numbness or Abnormal Sensation In Any Area","Facial Pain or Paralysis","Tingling/Itching or Burning in Arms and Legs","Problems Moving Arms and Legs or Tremors","Walking Difficulties", "Coordination Problems","Muscle Stiffness/Weakness", "Electric Shocks with Neck Movement","Constipation",
            "Fecal Incontinence","Difficulty Starting Urination","Frequent Urination","Urinary Incontinence","Depression", "Decreased Attention Span","Memory Loss","Decreased Ability to Discern", "Dizziness","Vaginal Lubrication Problems",  "Sexual Dysfunction", "Poorly Articulates Speech", "Problems Chewing and Swallowing"
        };

        for (String symptom : symptoms) {
            JCheckBox checkBox = new JCheckBox(symptom);
            symptomCheckboxes.put(symptom, checkBox);
            symptomPanel.add(checkBox);
        }

        
        JButton diagnoseButton = new JButton("Diagnose");
        diagnoseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processDiagnosis();
            }
        });

        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Diagnosis Result"));

        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(symptomPanel), BorderLayout.CENTER);
        frame.add(diagnoseButton, BorderLayout.SOUTH);
        frame.add(resultArea, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

   private void processDiagnosis() {
    try {
        
        int id = requestPatientID();

        
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        patient = new Patient(name, age, id);
        diagnosis = new Diagnosis();
        patient.setDiagnosis(diagnosis);

        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("mediagnosisKSession");

        
        

            
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
            McDonaldCriteria mcdonald= new McDonaldCriteria();
            
            
            kieSession.insert(patient);
            kieSession.insert(diagnosis);
        
        for (Map.Entry<String, JCheckBox> entry : symptomCheckboxes.entrySet()) {
            String symptomName = entry.getKey();
            JCheckBox checkBox = entry.getValue();

            boolean isSelected = checkBox.isSelected(); 
            switch (symptomName) {
                case "Double Vision":
                    dvision.setPresence(isSelected);
                    break;
                case "Eye Discomfort":
                    eyedisc.setPresence(isSelected);
                    break;
                case "Vision Loss One Eye":
                    vlossOne.setPresence(isSelected);
                    break;
                case "Loss Of Balance":
                    lossbalan.setPresence(isSelected);
                    break;
                case "Involuntary Eye Movement": 
                    invEye.setPresence(isSelected);
                    break; 
                case "Severe Fatigue":
                    fatigue.setPresence(isSelected);
                    break;
                case "Numbness or Abnormal Sensation In Any Area": 
                    numbness.setPresence(isSelected);
                    break;
                case "Facial Pain or Paralysis": 
                    facial.setPresence(isSelected);
                    break;
                case "Tingling/Itching or Burning in Arms and Legs":
                    tingling.setPresence(isSelected);
                    break; 
                case "Problems Moving Arms and Legs or Tremors":
                    arms.setPresence(isSelected);
                    break; 
                case "Walking Difficulties":
                    walking.setPresence(isSelected);
                    break;
                case "Muscle Stiffness/Weakness":
                    stiff.setPresence(isSelected);
                    break;
                case "Coordination Problems":
                    coord.setPresence(isSelected);
                    break;
                case "Electric Shocks Neck Movement":
                    shock.setPresence(isSelected);
                    break;
                case "Constipation":
                    constip.setPresence(isSelected);
                    break;
                case "Fecal Incontinence":
                    fecal.setPresence(isSelected);
                    break; 
                case "Difficulty Starting Urination":
                    urinat.setPresence(isSelected);
                    break;
                case "Frequent Urination":
                    frequrin.setPresence(isSelected);
                    break;
                case "Urinary Incontinence":
                    uriIncon.setPresence(isSelected);
                    break;
                case "Depression":
                    dep.setPresence(isSelected);
                    break;
                case "Muscle Spasm":
                    muscspasm.setPresence(isSelected);
                    break;
                case "Decreased Attention Span":
                    attention.setPresence(isSelected);
                    break;
                case "Memory Loss":
                    memory.setPresence(isSelected);
                    break;
                case "Decreased Ability to Discern":
                    discern.setPresence(isSelected);
                    break;
                case "Dizziness":
                    dizz.setPresence(isSelected);
                    break;
                case "Vaginal Lubrication Problems":
                    vaginal.setPresence(isSelected);
                    break;
                case "Sexual Dysfunction":
                    sexual.setPresence(isSelected);
                    break;
                case "Poorly Articulates Speech":
                    speech.setPresence(isSelected);
                    break;
                case "Problems Chewing and Swallowing":
                    chew.setPresence(isSelected);
                    break;
                default:
                    break;
            }
        }
        kieSession.insert(patient);
        kieSession.insert(diagnosis);
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
        
        //DISCARD DIAGNOSIS
        if (diagnosis.getScore() > 30) {
            diagnosis.setQuestions(true);
            int confirm = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have presence of anti-AQP4 antibodies?", 
                "Anti-AQP4 Antibodies", 
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                diagnosis.setAntiAQP4(true);
            } else {
                diagnosis.setAntiAQP4(false);
            }
            int confirm1 = JOptionPane.showConfirmDialog(frame, 
                "Is the patient positive in Elisa test?", 
                "Positive Elisa test", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setElisatest(true);
            } else {
                diagnosis.setElisatest(false);
            }
            int confirm2 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have Vitamin B12 deficiency?", 
                "Vit B12 deficiency", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setVitB12(true);
            } else {
                diagnosis.setVitB12(false);
            }
            int confirm3 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have elevated levels of angiotensin-converting enzyme (ACE)?", 
                "Elevated ACE levels", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setACE(true);
            } else {
                diagnosis.setACE(false);
            }
            int confirm4 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have presence of antinuclear antibodies (ANA)?", 
                "Presence of ANA", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setACE(true);
            } else {
                diagnosis.setACE(false);
            }
            int confirm5 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have presence of anti-SSA/Ro antibodies?", 
                "Presence of anti-SSA/Ro", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setAntiSSARo(true);
            } else {
                diagnosis.setAntiSSARo(false);
            }
            int confirm6 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have presence of anti-SSB/La antibodies?", 
                "Presence of anti-SSB/La", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setAntiSSBLa(true);
            } else {
                diagnosis.setAntiSSBLa(false);
            }
            int confirm7 = JOptionPane.showConfirmDialog(frame, 
                "Does the patient have an ischemic lesion?", 
                "Ischemic lesion", 
                JOptionPane.YES_NO_OPTION);
            if (confirm1 == JOptionPane.YES_OPTION) {
                diagnosis.setIscheamicLesion(true);
            } else {
                diagnosis.setIscheamicLesion(false);
            }
            patient.setDiagnosis(diagnosis);
 
            kieSession.update(kieSession.getFactHandle(diagnosis), diagnosis);
            kieSession.update(kieSession.getFactHandle(patient), patient);
            kieSession.fireAllRules();
        }
        
        if(diagnosis.getDisease()== Diagnosis.Disease.NONE){
            mcdonald.setExists(true);
            
            
        }

        kieSession.dispose();
        
        resultArea.setText("Patient Name: " + patient.getName() + "\n" +
                           "Patient ID: " + patient.getId() + "\n" +
                           "Diagnosis Score: " + diagnosis.getScore() + "\n" +
                           "Disease: " + diagnosis.getDisease());

    } catch (Exception e) {
        resultArea.setText("Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    private int requestPatientID() {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, "Enter Patient ID (8 digits):");
            if (input != null && input.matches("\\d{8}")) {
                return Integer.parseInt(input);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter an 8-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   

    
}
