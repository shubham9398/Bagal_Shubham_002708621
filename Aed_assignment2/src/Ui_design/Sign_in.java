/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui_design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java_classes.Community;
import java_classes.Community_dir;
import java_classes.Doctor;
import java_classes.Doctors_dir;
import java_classes.Encounter;
import java_classes.Encounter_his;
import java_classes.Hospital;
import java_classes.Hospital_dir;
import java_classes.Patient;
import java_classes.Patient_dir;
import java_classes.Person;
import java_classes.Person_dir;
import java_classes.Vital_signs;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author shubhambagal
 */
public class Sign_in extends javax.swing.JFrame {

    Person_dir personList;
    Encounter_his encounter_his;
    Patient_dir patient_list;
    Doctors_dir doctors_list;
    String user_type_profile;
    String name_profile;
    String password_profile;
    Community_dir commu_list;
    Hospital_dir hos_list;
    /**
     * Creates new form sign_in
   \
     * @param person_dir
     * @param userName
     * @param password
     */
    public Sign_in(Person_dir person_dir, String userName, String password, String UserType, Patient_dir patientList,Community_dir commList, Hospital_dir h_dir, Doctors_dir docList,Encounter_his enc_his) {
        initComponents();
        this.personList = person_dir;
        this.encounter_his = enc_his;
        this.patient_list = patientList;
        this.doctors_list = docList;
        this.commu_list = commList;
        this.hos_list = h_dir;
        patient_signIn.setVisible(false);
        
        hospital_signIn.setVisible(false);
        doctor_signIn.setVisible(false);           
        community_signIn.setVisible(false);
        
//        this.personList = person_dir;
        String user_name = userName;
        String user_password = password;
        String User_type = UserType;
        
        
         
            
                
                 switch (User_type.toString()) {
                case "Patient" -> {
                    
                    hospital_signIn.setVisible(false);
                    doctor_signIn.setVisible(false);
                    community_signIn.setVisible(false);
                    paneHosDoc.setVisible(false);
                    PaneEncounterHis.setVisible(false);
                    PanePersonal.setVisible(false);
                    NewEncounterPanel.setVisible(false);
                                          
                    for(Patient profile : patient_list.getPatient_list()){ 
                        user_type_profile =  profile.getUser_type();                    
                            name_profile = profile.getName();                   
                            password_profile = profile.getPassword(); 
                             if(user_name.equals(name_profile ) && user_password.equals(password_profile)){
                                 patient_signIn.setVisible(true);
                                 
                    
                    btnHosDoc.addActionListener((ActionEvent ae) -> {
                        
                    paneHosDoc.setVisible(true);
                    PaneEncounterHis.setVisible(false);
                    PanePersonal.setVisible(false);
                    populate_table_Hosdoc();
                    
                    
                        
                    });
                    
                     btnEncounterHis.addActionListener((ActionEvent aeh) -> {
                                    PaneEncounterHis.setVisible(true);
                                    PanePersonal.setVisible(false);                      
                                    paneHosDoc.setVisible(false); 
                                    DefaultTableModel model = (DefaultTableModel) profile_tbl.getModel();
        
                                    model.setRowCount(0);
                                    for(Encounter en :encounter_his.getEncounterHistory() ){
                
                                        Object[] row = new Object[3];
          
                
                                        row[0] = en;         
                
                                        row[1] = en.getAptTime();   
                
                                        row[2] = en.getDiagnosis(); 
                 
                                        model.addRow(row);
                
           
                                    }
            
            
                                    
                                });
            
                    
                    btnPerDetails.addActionListener((ActionEvent ae) -> {
                         PanePersonal.setVisible(true);
                         paneHosDoc.setVisible(false);              
                         PaneEncounterHis.setVisible(false);
                                                 
                            user_type_profile =  profile.getUser_type();                    
                            name_profile = profile.getName();                   
                            password_profile = profile.getPassword();                          
                            
                                
                                
                                
                                txt_name_v.setText(name_profile);
                                txt_age_v.setText(profile.getAge());
                                txt_house_v.setText(profile.getHousse());
                                txt_id_v.setText(profile.getSsn());
                                txt_address_v.setText(profile.getCity());
                                txt_commu_v.setText(profile.getCommunity());
                               
                                jButton2.addActionListener((ActionEvent aej) -> {
                                    
                                profile.setName(txt_name_v.getText().toString());
                                profile.setAge(txt_age_v.getText().toString());
                                profile.setHousse(txt_house_v.getText().toString());
                                profile.setCity(txt_address_v.getText().toString());
                                profile.setSsn(txt_id_v.getText().toString());
                                profile.setCommunity(txt_commu_v.getText().toString());
                                JOptionPane.showMessageDialog(this,"Patient Detalis Updated");
                                    
                               
                                });
                                
                                                   
                                
                                
                                
                            
                            
   
                        
                    });
                    
                    
                    
                    
                    
                                 
                                 
                             }
                        
                    }    
                   
                    
            

                    
                    
                    
                    
                    
                }
                case "Doctor" -> {
                    hospital_signIn.setVisible(false);
                    doctor_signIn.setVisible(false);
                    community_signIn.setVisible(false);
                    paneHosDoc.setVisible(false);
                    PaneEncounterHis.setVisible(false);
                    PanePersonal.setVisible(false);
                    NewEncounterPanel.setVisible(false);
                    patient_signIn.setVisible(false);
                    
                    
                     
                     for(Doctor profile : docList.getDoctor_list()){ 
                        user_type_profile =  profile.getUser_type();                    
                            name_profile = profile.getName();                   
                            password_profile = profile.getPassword(); 
                             if(user_name.equals(name_profile ) && user_password.equals(password_profile)){
                                doctor_signIn.setVisible(true);
                                 btnViewEncounter.addActionListener((var ae) -> {
                        
                   
                                     ExisEncontersPnael.setVisible(true);
                                      NewEncounterPanel.setVisible(false);
                   
                                     populate_table_Exispatient_doc();
                   
                                     ViewPatientDoc.addActionListener((ActionEvent v) -> {
                       
                                         int selected_row_idx =  profile_tbl1.getSelectedRow();
                         
                                         if(selected_row_idx<0){
        
                          
                                             JOptionPane.showMessageDialog(this,"Please select a row to View");
                           
                                             return;
      
                         
                                         }
                        
                                         DefaultTableModel model = (DefaultTableModel) profile_tbl1.getModel();
                         
                        
                                         Encounter enc = (Encounter) model.getValueAt(selected_row_idx, 0);
                         
                                         String encDate = enc.getAptTime().toString();
                        
                                         String name = enc.getPatientName();
                          
                           int bp = enc.getVitalSign().getBloodPressure();
                           JOptionPane.showMessageDialog(this,bp +" "+ encDate);
                           txtBP.setText(String.valueOf(bp));
                           txtTemp.setText(String.valueOf(enc.getVitalSign().getBodyTemp()));
                           TxtPulse.setText(String.valueOf(enc.getVitalSign().getPulseRate()));
                           diag.setText(enc.getDiagnosis());
                         
                          btn_update.addActionListener((ActionEvent e) -> {
                                                   
                              if(Integer.parseInt(txtBP.getText().toString()) < 0  && Integer.parseInt(txtTemp.getText().toString()) < 0
                                     && Integer.parseInt(TxtPulse.getText().toString()) < 0  && !diag.getText().toString().equals("") ){
                                  
                                   Encounter enc1 = (Encounter) model.getValueAt(selected_row_idx, 0);
                       
                                   enc1.getVitalSign().setBloodPressure(Integer.parseInt(txtBP.getText())); 
                       
                                   enc1.getVitalSign().setBodyTemp(Integer.parseInt(txtTemp.getText())); 
                        
                                   enc1.getVitalSign().setPulseRate(Integer.parseInt(TxtPulse.getText())); 
                                   
                                   enc1.setDiagnosis(diag.getText().toString());                               
                                   encounter_his.updateEncounter(enc1,selected_row_idx );
                                   JOptionPane.showMessageDialog(this,"Encounter Updated");
                                   
                              }                    
                    });
     
                          
                           
                        
                    });
                    
                    
                   
                    
                    
                });
                    btnNewEncounter.addActionListener((var ae) -> {
                        
                    NewEncounterPanel.setVisible(true);
                     ExisEncontersPnael.setVisible(false);
                    populate_table_Newpatient_doc();
                    jButton7.addActionListener((ActionEvent e) -> {
                          int selected_row_idx =  tableNewVital.getSelectedRow();
      
                          if(selected_row_idx<0){
        
                              JOptionPane.showMessageDialog(this,"Please select a row to View");
                              return;
      
                          }
                          
                          if(!diagVital.getText().toString().equals("") && Integer.parseInt(txtVital.getText().toString()) > 0
                                     &&Integer.parseInt(TxtPulseVital.getText().toString()) > 0  && Integer.parseInt(txtBPVital.getText().toString()) > 0){
                              
                          DefaultTableModel model = (DefaultTableModel) tableNewVital.getModel();
      
                          Patient patient_profile = (Patient) model.getValueAt(selected_row_idx,0);          
                          String patientName = patient_profile.getName();
                          Date resultdate = new Date(System.currentTimeMillis());                             
                          Vital_signs vs = new Vital_signs(Integer.parseInt(txtVital.getText()), Integer.parseInt(TxtPulseVital.getText()), Integer.parseInt(txtBPVital.getText()));                                                    
                          Encounter enc = new Encounter(vs, resultdate, diagVital.getText(),patientName);
                          encounter_his.addEncounter(enc);
                          JOptionPane.showMessageDialog(this,"Encounter Added");
                          return;
                          
                          }
       
                         
                        
                        
                        
                    });
                    
                });
                             }
                     }
                     
                     
                     
                     
                   
                    
                }
                case "Hospital" -> {
                    patient_signIn.setVisible(false);
   
                    hospital_signIn.setVisible(true);
                    doctor_signIn.setVisible(false);
                    community_signIn.setVisible(false);
                    AddHosPane.setVisible(false);
                    crudPanel.setVisible(false);
                    crudDoct.setVisible(false);
                    NewEncounterPanel.setVisible(false);
                    
                    jButton3.addActionListener((ActionEvent ae) -> {
                        AddHosPane.setVisible(true);
                        crudPanel.setVisible(false);
                        crudDoct.setVisible(false);
                        txtBtnHosAdd.addActionListener((ActionEvent e) -> {
                            
                    
                            Hospital hospital_hos = hos_list.addnewEmployee();                   
                            hospital_hos.setCity(txtCityName.getText().toString());                         
                            hospital_hos.setCommunity(txtHosComm.getText().toString());                        
                            hospital_hos.setHospital_name(txtHosName.getText());                 
                            JOptionPane.showMessageDialog(this,"Hospital Added");
                            
                        });
                        
                    
                    
                    
                });
                    
                    jButton4.addActionListener((ActionEvent ae) -> {
                        crudPanel.setVisible(true);
                        crudDoct.setVisible(false);
                        AddHosPane.setVisible(false);
                        populate_table();
                        
                        
                    });
                    
                    
                    jButton6.addActionListener((ActionEvent ae) -> {
                        crudDoct.setVisible(true);
                        crudPanel.setVisible(false);
                        AddHosPane.setVisible(false);
                        populate_table_crud_doc();
                        
                        
                    });
                    
                    
                }
                case "Community" -> {
                    patient_signIn.setVisible(false);
                    
                    hospital_signIn.setVisible(false);
                    doctor_signIn.setVisible(false);
                    community_signIn.setVisible(true);
                    NewEncounterPanel.setVisible(false);
                    jButton1.addActionListener((ActionEvent ae) -> {
                        
                        Community commu_dir = commu_list.addnewEmployee();
                        commu_dir.setCity(jTextField3.getText());
                        commu_dir.setCommunity(jTextField2.getText());
                        commu_dir.setHouse(jTextField1.getText());
                        JOptionPane.showMessageDialog(this,"Community Added");
                        
                        
                        
                    });
                                    
                    
                }
                
                default -> {
                }
//            }
            

            
           
            
            
            
         
        }
        
       
     }
    
    
     private void populate_table() {
       
        DefaultTableModel model = (DefaultTableModel) tblPatientHos.getModel();
        model.setRowCount(0);
        for(Patient profile : patient_list.getPatient_list()){
            
            Object[] row = new Object[3];
            row[0] = profile;
            row[1] = profile.getSsn();
            row[2] = profile.getHousse();           
            model.addRow(row);
        }
    }
     
     private void populate_table_crud_doc() {
       
        DefaultTableModel model = (DefaultTableModel) tblPatientHos1.getModel();
        model.setRowCount(0);
        for(Doctor profile : doctors_list.getDoctor_list()){
            
            Object[] row = new Object[3];
            row[0] = profile;
            row[1] = profile.getSsn();
            row[2] = profile.getHospital();                                
            model.addRow(row);
        }
    }
     
      private void populate_table_Hosdoc() {
       
        DefaultTableModel model = (DefaultTableModel) HosDoc_tbl.getModel();
        model.setRowCount(0);
        for(Doctor profile : doctors_list.getDoctor_list()){
            
            Object[] row = new Object[3];
            row[0] = profile;
            row[1] = profile.getHospital();
            row[2] = profile.getCity();                                
            model.addRow(row);
        }
    }
     
     private void populate_table_Exispatient_doc() {
       
        DefaultTableModel model = (DefaultTableModel) profile_tbl1.getModel();
        model.setRowCount(0);
        
            
            for(Encounter en :encounter_his.getEncounterHistory() ){
                 Object[] row = new Object[3];
          
                 row[0] = en;         
                 row[1] = en.getVitalSign().getPulseRate();   
                 row[2] = en.getAptTime(); 
                 model.addRow(row);
                
            }
            
           
        
    }
     
     
     private void populate_table_Newpatient_doc() {
       
        DefaultTableModel model = (DefaultTableModel) tableNewVital.getModel();
        model.setRowCount(0);
        for(Patient profile : patient_list.getPatient_list()){
            
            Object[] row = new Object[3];
            row[0] = profile;
            row[1] = profile.getSsn();
            row[2] = profile.getHousse();                               
            model.addRow(row);
        }
    }
    
    
    
    
    
    
    
   
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coustamized_signIn = new javax.swing.JLayeredPane();
        patient_signIn = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        PatientBtnPanel = new javax.swing.JPanel();
        btnHosDoc = new javax.swing.JButton();
        btnEncounterHis = new javax.swing.JButton();
        btnPerDetails = new javax.swing.JButton();
        PatientWorkPanel = new javax.swing.JPanel();
        PatientTasks = new javax.swing.JLayeredPane();
        paneHosDoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HosDoc_tbl = new javax.swing.JTable();
        txtSearchHosdoc = new javax.swing.JTextField();
        btnSearchHosdoc = new javax.swing.JButton();
        PaneEncounterHis = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        profile_tbl = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        PanePersonal = new javax.swing.JPanel();
        lbl_start_date = new javax.swing.JLabel();
        txt_name_v = new javax.swing.JTextField();
        txt_id_v = new javax.swing.JTextField();
        txt_age_v = new javax.swing.JTextField();
        txt_address_v = new javax.swing.JTextField();
        txt_commu_v = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        lbl_age = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_house_v = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        doctor_signIn = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        DoctBtnPanel = new javax.swing.JPanel();
        btnViewEncounter = new javax.swing.JButton();
        btnNewEncounter = new javax.swing.JButton();
        doctorWorkPanel = new javax.swing.JPanel();
        doctorTasks = new javax.swing.JLayeredPane();
        ExisEncontersPnael = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        profile_tbl1 = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        txt_search1 = new javax.swing.JTextField();
        btn_search1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtPulse = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        diag = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        ViewPatientDoc = new javax.swing.JButton();
        NewEncounterPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableNewVital = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtBPVital = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtPulseVital = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        diagVital = new javax.swing.JTextField();
        txtVital = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        hospital_signIn = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        btnHosPane = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        hosWorkPane = new javax.swing.JLayeredPane();
        AddHosPane = new javax.swing.JPanel();
        txtBtnHosAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtCityName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtHosComm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHosName = new javax.swing.JTextField();
        crudPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPatientHos = new javax.swing.JTable();
        crudDoct = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPatientHos1 = new javax.swing.JTable();
        community_signIn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        coustamized_signIn.setBackground(new java.awt.Color(204, 204, 255));

        patient_signIn.setBackground(new java.awt.Color(204, 204, 255));

        btnHosDoc.setText("Hospital & Doctors");

        btnEncounterHis.setText("Encounter History");
        btnEncounterHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncounterHisActionPerformed(evt);
            }
        });

        btnPerDetails.setText("Personal Details");
        btnPerDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientBtnPanelLayout = new javax.swing.GroupLayout(PatientBtnPanel);
        PatientBtnPanel.setLayout(PatientBtnPanelLayout);
        PatientBtnPanelLayout.setHorizontalGroup(
            PatientBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientBtnPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHosDoc))
                    .addComponent(btnEncounterHis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPerDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PatientBtnPanelLayout.setVerticalGroup(
            PatientBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientBtnPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnHosDoc)
                .addGap(45, 45, 45)
                .addComponent(btnEncounterHis)
                .addGap(46, 46, 46)
                .addComponent(btnPerDetails)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(PatientBtnPanel);

        HosDoc_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor", "Hospital", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(HosDoc_tbl);

        btnSearchHosdoc.setText("Search");
        btnSearchHosdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHosdocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneHosDocLayout = new javax.swing.GroupLayout(paneHosDoc);
        paneHosDoc.setLayout(paneHosDocLayout);
        paneHosDocLayout.setHorizontalGroup(
            paneHosDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneHosDocLayout.createSequentialGroup()
                .addGap(174, 186, Short.MAX_VALUE)
                .addComponent(txtSearchHosdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchHosdoc)
                .addGap(314, 314, 314))
            .addGroup(paneHosDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        paneHosDocLayout.setVerticalGroup(
            paneHosDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHosDocLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(paneHosDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchHosdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHosdoc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        profile_tbl.setBackground(new java.awt.Color(204, 204, 255));
        profile_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Time", "Diagnosis"
            }
        ));
        jScrollPane2.setViewportView(profile_tbl);

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneEncounterHisLayout = new javax.swing.GroupLayout(PaneEncounterHis);
        PaneEncounterHis.setLayout(PaneEncounterHisLayout);
        PaneEncounterHisLayout.setHorizontalGroup(
            PaneEncounterHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneEncounterHisLayout.createSequentialGroup()
                .addGroup(PaneEncounterHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneEncounterHisLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search))
                    .addGroup(PaneEncounterHisLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        PaneEncounterHisLayout.setVerticalGroup(
            PaneEncounterHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneEncounterHisLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PaneEncounterHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_start_date.setText("City");

        txt_name_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_name_vActionPerformed(evt);
            }
        });

        txt_age_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_age_vActionPerformed(evt);
            }
        });
        txt_age_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_age_vKeyTyped(evt);
            }
        });

        lbl_name.setText("Name");

        lbl_ID.setText("SSN");

        lbl_age.setText("Age");

        lbl_gender.setText("Community");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Personal Details");

        jLabel3.setText("House");

        javax.swing.GroupLayout PanePersonalLayout = new javax.swing.GroupLayout(PanePersonal);
        PanePersonal.setLayout(PanePersonalLayout);
        PanePersonalLayout.setHorizontalGroup(
            PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanePersonalLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(279, 279, 279)
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_id_v, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name_v, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_age, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanePersonalLayout.createSequentialGroup()
                                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_gender)
                                    .addComponent(lbl_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_address_v, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txt_commu_v, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txt_age_v, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txt_house_v))))
                .addGap(170, 170, 170))
            .addGroup(PanePersonalLayout.createSequentialGroup()
                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanePersonalLayout.setVerticalGroup(
            PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanePersonalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_name)
                            .addComponent(txt_name_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanePersonalLayout.createSequentialGroup()
                                .addComponent(lbl_ID)
                                .addGap(18, 18, 18)
                                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_age)
                                    .addComponent(txt_age_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_gender)
                                    .addComponent(txt_commu_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(PanePersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_start_date)
                                    .addComponent(txt_address_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_id_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_house_v, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanePersonalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(42, 42, 42)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        PatientTasks.setLayer(paneHosDoc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PatientTasks.setLayer(PaneEncounterHis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PatientTasks.setLayer(PanePersonal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PatientTasksLayout = new javax.swing.GroupLayout(PatientTasks);
        PatientTasks.setLayout(PatientTasksLayout);
        PatientTasksLayout.setHorizontalGroup(
            PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneHosDoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PaneEncounterHis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanePersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PatientTasksLayout.setVerticalGroup(
            PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneHosDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PaneEncounterHis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanePersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PatientWorkPanelLayout = new javax.swing.GroupLayout(PatientWorkPanel);
        PatientWorkPanel.setLayout(PatientWorkPanelLayout);
        PatientWorkPanelLayout.setHorizontalGroup(
            PatientWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PatientTasks))
        );
        PatientWorkPanelLayout.setVerticalGroup(
            PatientWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PatientTasks, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jSplitPane1.setRightComponent(PatientWorkPanel);

        javax.swing.GroupLayout patient_signInLayout = new javax.swing.GroupLayout(patient_signIn);
        patient_signIn.setLayout(patient_signInLayout);
        patient_signInLayout.setHorizontalGroup(
            patient_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_signInLayout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
        );
        patient_signInLayout.setVerticalGroup(
            patient_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        doctor_signIn.setBackground(new java.awt.Color(204, 204, 255));

        btnViewEncounter.setText("Encounters");
        btnViewEncounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEncounterActionPerformed(evt);
            }
        });

        btnNewEncounter.setText("Add Encounters");

        javax.swing.GroupLayout DoctBtnPanelLayout = new javax.swing.GroupLayout(DoctBtnPanel);
        DoctBtnPanel.setLayout(DoctBtnPanelLayout);
        DoctBtnPanelLayout.setHorizontalGroup(
            DoctBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewEncounter, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewEncounter, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DoctBtnPanelLayout.setVerticalGroup(
            DoctBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctBtnPanelLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnViewEncounter)
                .addGap(84, 84, 84)
                .addComponent(btnNewEncounter)
                .addContainerGap(396, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(DoctBtnPanel);

        profile_tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "SSN", "Encounter Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(profile_tbl1);

        btn_update.setText("Update Vitals");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_search1.setText("Search");
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Blood Pressure");

        jLabel9.setText("Pulse Rate");

        jLabel10.setText("Diagnosis");

        jLabel11.setText("Temperature");

        ViewPatientDoc.setText("View");
        ViewPatientDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPatientDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExisEncontersPnaelLayout = new javax.swing.GroupLayout(ExisEncontersPnael);
        ExisEncontersPnael.setLayout(ExisEncontersPnaelLayout);
        ExisEncontersPnaelLayout.setHorizontalGroup(
            ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExisEncontersPnaelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExisEncontersPnaelLayout.createSequentialGroup()
                        .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(diag)
                            .addGroup(ExisEncontersPnaelLayout.createSequentialGroup()
                                .addComponent(txtBP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update))))
                .addGap(132, 132, 132))
            .addGroup(ExisEncontersPnaelLayout.createSequentialGroup()
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ViewPatientDoc)
                    .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ExisEncontersPnaelLayout.createSequentialGroup()
                            .addGap(175, 175, 175)
                            .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_search1))
                        .addGroup(ExisEncontersPnaelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        ExisEncontersPnaelLayout.setVerticalGroup(
            ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExisEncontersPnaelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ViewPatientDoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(TxtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExisEncontersPnaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(diag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update))
                .addGap(110, 110, 110))
        );

        tableNewVital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SSN", "Patinet", "House"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableNewVital);

        jLabel12.setText("Blood Pressure");

        jLabel13.setText("Pulse Rate");

        jLabel14.setText("Diagnosis");

        jLabel15.setText("Temperature");

        jButton7.setText("Add Vitals");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewEncounterPanelLayout = new javax.swing.GroupLayout(NewEncounterPanel);
        NewEncounterPanel.setLayout(NewEncounterPanelLayout);
        NewEncounterPanelLayout.setHorizontalGroup(
            NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewEncounterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPulseVital, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NewEncounterPanelLayout.createSequentialGroup()
                        .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(diagVital, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewEncounterPanelLayout.createSequentialGroup()
                                .addComponent(txtBPVital, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVital, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))))
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewEncounterPanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        NewEncounterPanelLayout.setVerticalGroup(
            NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewEncounterPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtBPVital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtVital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(TxtPulseVital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(diagVital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        doctorTasks.setLayer(ExisEncontersPnael, javax.swing.JLayeredPane.DEFAULT_LAYER);
        doctorTasks.setLayer(NewEncounterPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout doctorTasksLayout = new javax.swing.GroupLayout(doctorTasks);
        doctorTasks.setLayout(doctorTasksLayout);
        doctorTasksLayout.setHorizontalGroup(
            doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
            .addGroup(doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ExisEncontersPnael, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(NewEncounterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        doctorTasksLayout.setVerticalGroup(
            doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ExisEncontersPnael, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(doctorTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(NewEncounterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout doctorWorkPanelLayout = new javax.swing.GroupLayout(doctorWorkPanel);
        doctorWorkPanel.setLayout(doctorWorkPanelLayout);
        doctorWorkPanelLayout.setHorizontalGroup(
            doctorWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctorTasks))
        );
        doctorWorkPanelLayout.setVerticalGroup(
            doctorWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doctorTasks)
        );

        jSplitPane2.setRightComponent(doctorWorkPanel);

        javax.swing.GroupLayout doctor_signInLayout = new javax.swing.GroupLayout(doctor_signIn);
        doctor_signIn.setLayout(doctor_signInLayout);
        doctor_signInLayout.setHorizontalGroup(
            doctor_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        doctor_signInLayout.setVerticalGroup(
            doctor_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        hospital_signIn.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setText("Add Hospital");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View Patient");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("View Doctor");

        javax.swing.GroupLayout btnHosPaneLayout = new javax.swing.GroupLayout(btnHosPane);
        btnHosPane.setLayout(btnHosPaneLayout);
        btnHosPaneLayout.setHorizontalGroup(
            btnHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHosPaneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(btnHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        btnHosPaneLayout.setVerticalGroup(
            btnHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHosPaneLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton3)
                .addGap(68, 68, 68)
                .addComponent(jButton4)
                .addGap(58, 58, 58)
                .addComponent(jButton6)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jSplitPane3.setLeftComponent(btnHosPane);

        txtBtnHosAdd.setText("Add Details");
        txtBtnHosAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBtnHosAddActionPerformed(evt);
            }
        });

        jLabel16.setText("City Name");

        txtCityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityNameActionPerformed(evt);
            }
        });

        jLabel17.setText("Community");

        jLabel18.setText("Hospital Community");

        txtHosName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHosNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddHosPaneLayout = new javax.swing.GroupLayout(AddHosPane);
        AddHosPane.setLayout(AddHosPaneLayout);
        AddHosPaneLayout.setHorizontalGroup(
            AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddHosPaneLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBtnHosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosComm, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        AddHosPaneLayout.setVerticalGroup(
            AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddHosPaneLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHosComm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddHosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addComponent(txtBtnHosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        tblPatientHos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Encounter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblPatientHos);

        javax.swing.GroupLayout crudPanelLayout = new javax.swing.GroupLayout(crudPanel);
        crudPanel.setLayout(crudPanelLayout);
        crudPanelLayout.setHorizontalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        crudPanelLayout.setVerticalGroup(
            crudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        tblPatientHos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Encounter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblPatientHos1);

        javax.swing.GroupLayout crudDoctLayout = new javax.swing.GroupLayout(crudDoct);
        crudDoct.setLayout(crudDoctLayout);
        crudDoctLayout.setHorizontalGroup(
            crudDoctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudDoctLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        crudDoctLayout.setVerticalGroup(
            crudDoctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crudDoctLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        hosWorkPane.setLayer(AddHosPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hosWorkPane.setLayer(crudPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        hosWorkPane.setLayer(crudDoct, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout hosWorkPaneLayout = new javax.swing.GroupLayout(hosWorkPane);
        hosWorkPane.setLayout(hosWorkPaneLayout);
        hosWorkPaneLayout.setHorizontalGroup(
            hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddHosPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(crudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(crudDoct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hosWorkPaneLayout.setVerticalGroup(
            hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddHosPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(crudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(hosWorkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hosWorkPaneLayout.createSequentialGroup()
                    .addComponent(crudDoct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jSplitPane3.setRightComponent(hosWorkPane);

        javax.swing.GroupLayout hospital_signInLayout = new javax.swing.GroupLayout(hospital_signIn);
        hospital_signIn.setLayout(hospital_signInLayout);
        hospital_signInLayout.setHorizontalGroup(
            hospital_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );
        hospital_signInLayout.setVerticalGroup(
            hospital_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );

        community_signIn.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setText("Community Admin ");

        jLabel6.setText("House");

        jLabel7.setText("Community");

        jLabel8.setText("City Name");

        jButton1.setText("Add Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout community_signInLayout = new javax.swing.GroupLayout(community_signIn);
        community_signIn.setLayout(community_signInLayout);
        community_signInLayout.setHorizontalGroup(
            community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(community_signInLayout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, community_signInLayout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(community_signInLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(community_signInLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(community_signInLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(253, 253, 253))
        );
        community_signInLayout.setVerticalGroup(
            community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(community_signInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(community_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        coustamized_signIn.setLayer(patient_signIn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        coustamized_signIn.setLayer(doctor_signIn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        coustamized_signIn.setLayer(hospital_signIn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        coustamized_signIn.setLayer(community_signIn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout coustamized_signInLayout = new javax.swing.GroupLayout(coustamized_signIn);
        coustamized_signIn.setLayout(coustamized_signInLayout);
        coustamized_signInLayout.setHorizontalGroup(
            coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 978, Short.MAX_VALUE)
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(patient_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(doctor_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(hospital_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(community_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coustamized_signInLayout.setVerticalGroup(
            coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(patient_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(doctor_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(hospital_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(coustamized_signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(community_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coustamized_signIn, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coustamized_signIn)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchHosdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHosdocActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) HosDoc_tbl.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        HosDoc_tbl.setRowSorter(tr );
        tr.setRowFilter(RowFilter.regexFilter(txtSearchHosdoc.getText().trim()));

    }//GEN-LAST:event_btnSearchHosdocActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) profile_tbl.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        profile_tbl.setRowSorter(tr );
        tr.setRowFilter(RowFilter.regexFilter(txt_search.getText().trim()));

    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_name_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_name_vActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_vActionPerformed

    private void txt_age_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_age_vActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_age_vActionPerformed

    private void txt_age_vKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_age_vKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter)) || enter== KeyEvent.VK_BACK_SPACE || enter== KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_age_vKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        

           
        

    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityNameActionPerformed

    private void btnPerDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPerDetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtHosNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHosNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHosNameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) profile_tbl.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        profile_tbl.setRowSorter(tr );
        tr.setRowFilter(RowFilter.regexFilter(txt_search.getText().trim()));
    }//GEN-LAST:event_btn_search1ActionPerformed

    private void btnViewEncounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEncounterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewEncounterActionPerformed

    private void txtBtnHosAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBtnHosAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBtnHosAddActionPerformed

    private void ViewPatientDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPatientDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewPatientDocActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEncounterHisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncounterHisActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnEncounterHisActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddHosPane;
    private javax.swing.JPanel DoctBtnPanel;
    private javax.swing.JPanel ExisEncontersPnael;
    private javax.swing.JTable HosDoc_tbl;
    private javax.swing.JPanel NewEncounterPanel;
    private javax.swing.JPanel PaneEncounterHis;
    private javax.swing.JPanel PanePersonal;
    private javax.swing.JPanel PatientBtnPanel;
    private javax.swing.JLayeredPane PatientTasks;
    private javax.swing.JPanel PatientWorkPanel;
    private javax.swing.JTextField TxtPulse;
    private javax.swing.JTextField TxtPulseVital;
    private javax.swing.JButton ViewPatientDoc;
    private javax.swing.JButton btnEncounterHis;
    private javax.swing.JButton btnHosDoc;
    private javax.swing.JPanel btnHosPane;
    private javax.swing.JButton btnNewEncounter;
    private javax.swing.JButton btnPerDetails;
    private javax.swing.JButton btnSearchHosdoc;
    private javax.swing.JButton btnViewEncounter;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_update;
    private javax.swing.JPanel community_signIn;
    private javax.swing.JLayeredPane coustamized_signIn;
    private javax.swing.JPanel crudDoct;
    private javax.swing.JPanel crudPanel;
    private javax.swing.JTextField diag;
    private javax.swing.JTextField diagVital;
    private javax.swing.JLayeredPane doctorTasks;
    private javax.swing.JPanel doctorWorkPanel;
    private javax.swing.JPanel doctor_signIn;
    private javax.swing.JLayeredPane hosWorkPane;
    private javax.swing.JPanel hospital_signIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_age;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_start_date;
    private javax.swing.JPanel paneHosDoc;
    private javax.swing.JPanel patient_signIn;
    private javax.swing.JTable profile_tbl;
    private javax.swing.JTable profile_tbl1;
    private javax.swing.JTable tableNewVital;
    private javax.swing.JTable tblPatientHos;
    private javax.swing.JTable tblPatientHos1;
    private javax.swing.JTextField txtBP;
    private javax.swing.JTextField txtBPVital;
    private javax.swing.JButton txtBtnHosAdd;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtHosComm;
    private javax.swing.JTextField txtHosName;
    private javax.swing.JTextField txtSearchHosdoc;
    private javax.swing.JTextField txtTemp;
    private javax.swing.JTextField txtVital;
    private javax.swing.JTextField txt_address_v;
    private javax.swing.JTextField txt_age_v;
    private javax.swing.JTextField txt_commu_v;
    private javax.swing.JTextField txt_house_v;
    private javax.swing.JTextField txt_id_v;
    private javax.swing.JTextField txt_name_v;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_search1;
    // End of variables declaration//GEN-END:variables
}
