/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediagnosis;

/**
 *
 * @author sofia
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import mediagnosis.pojos.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.KieServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import mediagnosis.*;
import org.kie.api.runtime.rule.FactHandle;

public class DiagnosisApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JTextField nameField;
    private JTextField ageField;
    private JTextField idField;
    private JTextArea resultArea;

    private Map<String, JCheckBox> symptomCheckboxes;
    private Patient patient;
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

    
    

    public DiagnosisApp() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Multiple Sclerosis Diagnosis System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        
        patient=new Patient();
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("mediagnosisKSession");

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //Patient info
        JPanel patientInfoPanel = createPatientInfoPanel();
        mainPanel.add(patientInfoPanel, "PatientInfo");

        //Symptom selection
        JPanel symptomSelectionPanel = createSymptomSelectionPanel(kieSession);
        mainPanel.add(symptomSelectionPanel, "SymptomSelection");
        

        //Discard diagnosis
        JPanel questionPanel = createQuestionPanel(kieSession);
        mainPanel.add(questionPanel, "Discard alternative diagnosis");


        
        

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createPatientInfoPanel() {
    JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
    panel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

    JLabel nameLabel = new JLabel("Name:");
    nameField = new JTextField(4); 
    JLabel ageLabel = new JLabel("Age:");
    ageField = new JTextField(2); 
    JLabel idLabel = new JLabel("ID (8 digits):");
    idField = new JTextField(2); 
    

    JButton continueButton = new JButton("Continue");
    continueButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String idText = idField.getText().trim();

            //Check fields not empty
            if (name.isEmpty() || ageText.isEmpty() || idText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Check age is integer
            if (!ageText.matches("\\d+")) {
                JOptionPane.showMessageDialog(frame, "Age must be an integer", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check Id 8 digit int
            if(!idText.matches("\\d{8}")){
                JOptionPane.showMessageDialog(frame, "ID must be 8 digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            patient.setName(name);
            patient.setAge(Integer.parseInt(ageText));
            patient.setId(Integer.parseInt(idText));
            cardLayout.show(mainPanel, "SymptomSelection");
        }
    });

    panel.add(nameLabel);
    panel.add(nameField);
    panel.add(ageLabel);
    panel.add(ageField);
    panel.add(idLabel);
    panel.add(idField);
    panel.add(new JLabel()); 
    panel.add(continueButton);

    return panel;
}

    private JPanel createSymptomSelectionPanel(KieSession kieSession) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Select Symptoms"));

        JPanel symptomPanel = new JPanel(new GridLayout(0, 1));
        symptomCheckboxes = new HashMap<>();
        String[] symptoms = {
            "Double Vision", "Eye Discomfort", "Involuntary Eye Movement", "Vision Loss (One Eye At A Time)",
            "Loss Of Balance", "Muscle Spasm", "Severe Fatigue", "Numbness or Abnormal Sensation In Any Area",
            "Facial Pain or Paralysis", "Tingling/Itching or Burning in Arms and Legs", 
            "Problems Moving Arms and Legs or Tremors", "Walking Difficulties", "Coordination Problems",
            "Muscle Stiffness/Weakness", "Electric Shocks with Neck Movement", "Constipation",
            "Fecal Incontinence", "Difficulty Starting Urination", "Frequent Urination", "Urinary Incontinence",
            "Depression", "Decreased Attention Span", "Memory Loss", "Decreased Ability to Discern", 
            "Dizziness", "Vaginal Lubrication Problems", "Sexual Dysfunction", 
            "Poorly Articulated Speech", "Problems Chewing and Swallowing"
        };

        for (String symptom : symptoms) {
            JCheckBox checkBox = new JCheckBox(symptom);
            symptomCheckboxes.put(symptom, checkBox);
            symptomPanel.add(checkBox);
        }

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSymptoms(patient,kieSession);
                cardLayout.show(mainPanel, "Discard alternative diagnosis");
                }
                
            
        });

        panel.add(new JScrollPane(symptomPanel), BorderLayout.CENTER);
        panel.add(continueButton, BorderLayout.SOUTH);
       

        return panel;
    }
        
   private JPanel createQuestionPanel(KieSession kieSession) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(BorderFactory.createTitledBorder("Alternative Diagnoses"));

    JLabel statusLabel = new JLabel("", JLabel.CENTER);
    panel.add(statusLabel, BorderLayout.CENTER);

    JButton continueButton = new JButton("PRESS HERE TO GO TO QUESTIONS");
    continueButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
                patient.getDiagnosis().setQuestions(true);

                
                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have presence of anti-AQP4 antibodies?", 
                    "Anti-AQP4 Antibodies", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setAntiAQP4(confirm == JOptionPane.YES_OPTION);

                int confirm1 = JOptionPane.showConfirmDialog(frame, 
                    "Is the patient positive in Elisa and Western blot tests?", 
                    "Positive", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setElisatest(confirm1 == JOptionPane.YES_OPTION);

                int confirm2 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have Vitamin B12 deficiency?", 
                    "Vit B12 deficiency", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setVitB12(confirm2 == JOptionPane.YES_OPTION);

                int confirm3 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have elevated levels of angiotensin-converting enzyme (ACE)?", 
                    "Elevated ACE levels", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setACE(confirm3 == JOptionPane.YES_OPTION);

                int confirm4 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have presence of antinuclear antibodies (ANA)?", 
                    "Presence of ANA", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setANA(confirm4 == JOptionPane.YES_OPTION);

                int confirm5 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have presence of anti-SSA/Ro antibodies?", 
                    "Presence of anti-SSA/Ro", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setAntiSSARo(confirm5 == JOptionPane.YES_OPTION);

                int confirm6 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have presence of anti-SSB/La antibodies?", 
                    "Presence of anti-SSB/La", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setAntiSSBLa(confirm6 == JOptionPane.YES_OPTION);
                
                int confirm7 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have an ischemic lesion?", 
                    "Ischemic lesion", 
                    JOptionPane.YES_NO_OPTION);
                patient.getDiagnosis().setIscheamicLesion(confirm7 == JOptionPane.YES_OPTION);
                patient.getMcdonald().setExists(true);
               
                int confirm8 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have a periventricular lesion?", 
                    "Periventricular lesion", 
                    JOptionPane.YES_NO_OPTION);
                patient.getMcdonald().setPeriventLesion(confirm8 == JOptionPane.YES_OPTION);
                
                int confirm9 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have a juxtacortical lesion?", 
                    "Juxtacortical lesion", 
                    JOptionPane.YES_NO_OPTION);
                patient.getMcdonald().setJuxtacortLesion(confirm9 == JOptionPane.YES_OPTION);
                
                int confirm10 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have a infratentorial lesion?", 
                    "Infratentorial lesion", 
                    JOptionPane.YES_NO_OPTION);
                patient.getMcdonald().setInfratentLesion(confirm10 == JOptionPane.YES_OPTION);
                
                int confirm11 = JOptionPane.showConfirmDialog(frame, 
                    "Does the patient have a spinal cord lesion?", 
                    "Spinal cord lesion", 
                    JOptionPane.YES_NO_OPTION);
                patient.getMcdonald().setSpinalLesion(confirm11 == JOptionPane.YES_OPTION);
                
                int confirm12 = JOptionPane.showConfirmDialog(frame, 
                    "Have follow-up MRI scans shown new T2 lesions or gadolinium-enhancing lesions compared to previous scans?”", 
                    "", 
                    JOptionPane.YES_NO_OPTION);
                patient.getMcdonald().setTimedisemination(confirm12 == JOptionPane.YES_OPTION);
                
                
                try {
                  patient=FinalMain.insertSession(kieSession, patient, dvision, eyedisc, vlossOne, lossbalan, muscspasm, numbness, chew, constip, coord, discern, attention, dep, urinat, dizz, shock, facial, fecal, frequrin, invEye, memory, stiff, speech, arms, fatigue, sexual, tingling, uriIncon, vaginal, walking);  
                  intermediateCreate(kieSession);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
            cardLayout.show(mainPanel, "DiagnosisResult");
           
        }
    });

    panel.add(continueButton, BorderLayout.SOUTH);

    return panel;
}
    
    

    private JPanel createDiagnosisResultPanel(Patient patient, KieSession kieSession) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Diagnosis Result"));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true); 
        resultArea.setWrapStyleWord(true);
        JLabel messageLabel = new JLabel("", JLabel.CENTER); 
        panel.add(messageLabel, BorderLayout.CENTER);
        String mes="";
        String mes2="";
        if( patient.getDiagnosis().getDisease()==Diagnosis.Disease.ME){
             mes=" Yes";
             mes2=" No";
        }else {
             mes=" No";
        }
        
        if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.CNS){
            mes2=" Yes,  Primary CNS Vasculitis is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.LYME){
        mes2=" Yes, Lyme disease is diagnosed ";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.NMO){
            mes2=" Yes, Neuromyelitis Optica is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.SARCOIDOSIS){
            mes2=" Yes, Sarcoidosis is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.SJOGREN){
            mes2=" Yes, Sjogren syndrome is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.SLE){
            mes2=" Yes, Systemic Lupus Erythemateous is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.VITB12){
            mes2=" Yes, vitamin B12 deficiency is diagnosed";
        }else if(patient.getDiagnosis().getDisease()==Diagnosis.Disease.NONE){
            mes2="No";
        }
        
        
        
        String message = "ID:"+patient.getId()+"\n"+ "Score:"+patient.getDiagnosis().getScore()+ "\n" + "Is multiple sclerosis diagnosed?" +mes+"\n" +"Is any other similar disease diagnosed?:" + mes2 ;
        resultArea.setText(message);
        System.out.println(patient.getDiagnosis().getDisease());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kieSession.dispose();
                System.exit(0);
            }
        });
        
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        buttonPanel.add(exitButton);    
        panel.add(buttonPanel, BorderLayout.SOUTH); 
        
        return panel;
    }
    private void intermediateCreate(KieSession kieSession){
        // Results
                  JPanel diagnosisResultPanel = createDiagnosisResultPanel(patient, kieSession);
                  mainPanel.add(diagnosisResultPanel, "DiagnosisResult");
    }
    private void processSymptoms(Patient patient, KieSession kieSession) {
        try {
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
                case "Vision Loss (One Eye At A Time)":
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
                case "Electric Shocks with Neck Movement":
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
                case "Poorly Articulated Speech":
                    speech.setPresence(isSelected);
                    break;
                case "Problems Chewing and Swallowing":
                    chew.setPresence(isSelected);
                    break;
                default:
                    break;
            }
        }
        
    
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
 
}