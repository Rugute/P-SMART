package org.openmrs.module.facespsmart.jsonvalidator.mapper;

import org.openmrs.*;
import org.openmrs.api.VisitService;
import org.openmrs.api.context.Context;
import org.openmrs.module.facespsmart.jsonvalidator.utils.SHRUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rugute on 2/28/18.
 */
public class SHRProcessor {

    private String SHR;

    public SHRProcessor() {
        this.SHR = SHR;
    }

    public String getSHR() {
        return SHR;
    }

    public void setSHR(String SHR) {
        this.SHR = SHR;
    }

    public Person getOrCreatePatient() {
        Person p = new Person();
        return p;
    }

    public void getPersonIdentification () throws ParseException {

        PersonName pn = new  PersonName();
        Patient pat= new Patient() ;//= Context.getPatientService().getPatientByUuid("12345678-ADFGHJY-0987654-NHYI890");

        //PATIENT DEMOGRAPHICS
        String fName = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_NAME.fIRST_NAME;
        String mName = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_NAME.mIDDLE_NAME;
        String lName = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_NAME.lAST_NAME;
        String dob   = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.dATE_OF_BIRTH;
        Date dob_1   = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        String gender =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.sEX;
        String tELEPHONE= SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pHONE_NUMBER;
        String cIVIL_STATUS=SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mARITAL_STATUS;

        //PATIENT ADDRESS
        String postaladdress =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pOSTAL_ADDRESS;
        String vILLAGE = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pHYSICAL_ADDRESS.vILLAGE;
        String wARD = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pHYSICAL_ADDRESS.wARD;
        String sUBCOUNTY = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pHYSICAL_ADDRESS.sUB_COUNTY;
        String cOUNTY = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pHYSICAL_ADDRESS.cOUNTY;
        String nEAREST_LANDMARK = SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.pATIENT_ADDRESS.pHYSICAL_ADDRESS.nEAREST_LANDMARK;

        //MOTHER_DETAILS
        String mOTHER_FIRST_NAME =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_NAME.fIRST_NAME;
        String mOTHER_MIDDLE_NAME =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_NAME.mIDDLE_NAME;
        String mOTHER_LAST_NAME =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_NAME.lAST_NAME;

        //MOTHER_DETAILS

        for (int a = 0; a<SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_IDENTIFIER.length;a++) {
            String mOTHER_ID =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_IDENTIFIER[a].iD;
            String mOTHER_ID_ASSIGNING_AUTHORITY =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_IDENTIFIER[a].aSSIGNING_AUTHORITY;
            String mOTHER_ID_iDENTIFIER_TYPE =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_IDENTIFIER[a].iDENTIFIER_TYPE;
            String mOTHER_ID_aSSIGNING_FACILITY =SHRUtils.getSHR(SHR).pATIENT_IDENTIFICATION.mOTHER_DETAILS.mOTHER_IDENTIFIER[a].aSSIGNING_AUTHORITY;

        }

        //NEXT_OF_KIN
        String nokFirstName="";
        String nokMiddleName="";
        String nokLastLame="";
        String nokaDDRESS="";
        String noksEX ="";
        String nokdATE_OF_BIRTH="";
        Date   nokdob=null;
        String nokcONTACT_ROLE="";
        String nokrELATIONSHIP="";
        String nokpHONE_NUMBER="";




        for (int y = 0; y<SHRUtils.getSHR(SHR).nEXT_OF_KIN.length;y++) {

             nokFirstName = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].nOK_NAME.fIRST_NAME;
             nokMiddleName = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].nOK_NAME.mIDDLE_NAME;
             nokLastLame = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].nOK_NAME.lAST_NAME;
             nokaDDRESS = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].aDDRESS;
             noksEX = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].sEX;
             nokdATE_OF_BIRTH = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].dATE_OF_BIRTH;
             nokdob = new SimpleDateFormat("yyyy-MM-dd").parse(nokdATE_OF_BIRTH);
             nokcONTACT_ROLE = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].cONTACT_ROLE;
             nokrELATIONSHIP = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].rELATIONSHIP;
             nokpHONE_NUMBER = SHRUtils.getSHR(SHR).nEXT_OF_KIN[y].pHONE_NUMBER;
        }

        PersonAttribute ATTRIBUTE_POSTAL_ADDRESS = pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.POSTAL_ADDRESS_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_VILLAGE = pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.VILLAGE_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_WARD= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.WARD_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_SUBCOUNTY= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.SUBCOUNTY_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_COUNTY= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.COUNTY_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NEAREST_LANDMARK= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NEAREST_LANDMARK_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_MOTHER_FIRST_NAME= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.MOTHER_FIRST_NAME_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_MOTHER_MIDDLE_NAME= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.MOTHER_MIDDLE_NAME_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_MOTHER_LAST_NAME= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.MOTHER_LAST_NAME_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKFirstName= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKFirstName_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKMiddleName= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKMiddleName_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKLastLame= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKLastLame_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKaDDRESS= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKaDDRESS_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKSEX= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKSEX_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKDATE_OF_BIRTH= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKDATE_OF_BIRTH_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKCONTACT_ROLE= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKCONTACT_ROLE_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKRELATIONSHIP= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKRELATIONSHIP_ATTRIBUTE));
        PersonAttribute ATTRIBUTE_NOKPHONE_NUMBER= pat.getAttribute(Context.getPersonService().getPersonAttributeTypeByName(SMARTCardConstants.NOKPHONE_NUMBER_ATTRIBUTE));

        ATTRIBUTE_POSTAL_ADDRESS.setValue(postaladdress);
        ATTRIBUTE_VILLAGE.setValue(vILLAGE);
        ATTRIBUTE_WARD.setValue(wARD);
        ATTRIBUTE_SUBCOUNTY.setValue(sUBCOUNTY);
        ATTRIBUTE_COUNTY.setValue(cOUNTY);
        ATTRIBUTE_NEAREST_LANDMARK.setValue(nEAREST_LANDMARK);
        ATTRIBUTE_MOTHER_FIRST_NAME.setValue(mOTHER_FIRST_NAME);
        ATTRIBUTE_MOTHER_MIDDLE_NAME.setValue(mOTHER_MIDDLE_NAME);
        ATTRIBUTE_MOTHER_LAST_NAME.setValue(mOTHER_LAST_NAME);
        ATTRIBUTE_NOKFirstName.setValue(nokFirstName);
        ATTRIBUTE_NOKMiddleName.setValue(nokMiddleName);
        ATTRIBUTE_NOKLastLame.setValue(nokLastLame);
        ATTRIBUTE_NOKaDDRESS.setValue(nokaDDRESS);
        ATTRIBUTE_NOKSEX.setValue(noksEX);
        ATTRIBUTE_NOKDATE_OF_BIRTH.setValue(nokdATE_OF_BIRTH);
        ATTRIBUTE_NOKCONTACT_ROLE.setValue(nokcONTACT_ROLE);
        ATTRIBUTE_NOKRELATIONSHIP.setValue(nokrELATIONSHIP);
        ATTRIBUTE_NOKPHONE_NUMBER.setValue(nokpHONE_NUMBER);

        pat.setGender(gender);
        pat.addName(new PersonName(fName, mName, lName));
        pat.setBirthtime(dob_1);

        pat.addAttribute(ATTRIBUTE_POSTAL_ADDRESS);
        pat.addAttribute(ATTRIBUTE_VILLAGE);
        pat.addAttribute(ATTRIBUTE_WARD);
        pat.addAttribute(ATTRIBUTE_SUBCOUNTY);
        pat.addAttribute(ATTRIBUTE_COUNTY);
        pat.addAttribute(ATTRIBUTE_NEAREST_LANDMARK);
        pat.addAttribute(ATTRIBUTE_MOTHER_FIRST_NAME);
        pat.addAttribute(ATTRIBUTE_MOTHER_MIDDLE_NAME);
        pat.addAttribute(ATTRIBUTE_MOTHER_LAST_NAME);
        pat.addAttribute(ATTRIBUTE_NOKFirstName);
        pat.addAttribute(ATTRIBUTE_NOKMiddleName);
        pat.addAttribute(ATTRIBUTE_NOKLastLame);
        pat.addAttribute(ATTRIBUTE_NOKaDDRESS);
        pat.addAttribute(ATTRIBUTE_NOKSEX);
        pat.addAttribute(ATTRIBUTE_NOKDATE_OF_BIRTH);
        pat.addAttribute(ATTRIBUTE_NOKCONTACT_ROLE);
        pat.addAttribute(ATTRIBUTE_NOKRELATIONSHIP);
        pat.addAttribute(ATTRIBUTE_NOKPHONE_NUMBER);


        Context.getPatientService().savePatient(pat);
       // System.out.println("Success");



    }
    public void getEncounterDetails () throws ParseException {

        VisitService vs = Context.getVisitService();
        Visit visit = new Visit();

        Encounter encounter = new Encounter();
        encounter.setEncounterDatetime(new Date());
        encounter.setEncounterType(Context.getEncounterService().getEncounterType(SMARTCardConstants.EncounterNumber));
        encounter.setPatient(Context.getPatientService().getPatient(getOrCreatePatient().getPersonId())); // get from identif
        // encounter.setLocation(Context.getLocationService().getLocationAttributeTypeByName("MFLCODE"));//get Location MFLCODE Atrribute


        Obs observation = new Obs();

         //TEST obs
        for (int i = 0; i<SHRUtils.getSHR(SHR).hIV_TEST.length;i++) {
           String testDate = SHRUtils.getSHR(SHR).hIV_TEST[i].dATE;
           Date testdt   = new SimpleDateFormat("yyyy-MM-dd").parse(testDate);
           String testFacility = SHRUtils.getSHR(SHR).hIV_TEST[i].fACILITY;
           String testResult = SHRUtils.getSHR(SHR).hIV_TEST[i].rESULT;
           String testStrategy = SHRUtils.getSHR(SHR).hIV_TEST[i].sTRATEGY;
           String testType = SHRUtils.getSHR(SHR).hIV_TEST[i].tYPE;
           String testProvider = SHRUtils.getSHR(SHR).hIV_TEST[i].pROVIDER_DETAILS.nAME;

           //Test Date
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.TestDATE_ConceptID));
           observation.setValueDate(testdt);
           //Test Facility
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.Facility_ConceptID));
           observation.setValueText(testFacility);
           //Test Result
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.Result_ConceptID));
           observation.setValueText(testResult);
           //Test Strategy
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.Strategy_ConceptID));
           observation.setValueText(testStrategy);
           // Test Type
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.Type_ConceptID));
           observation.setValueText(testType);
           //Test provider
           observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.Provider_ConceptID));
           observation.setValueText(testProvider);


       }

        //Immunization obs
        for (int x = 0; x<SHRUtils.getSHR(SHR).iMMUNIZATION.length;x++) {
            String immunizationName =SHRUtils.getSHR(SHR).iMMUNIZATION[x].nAME;
            String immunizationDATE_ADMINISTERED =SHRUtils.getSHR(SHR).iMMUNIZATION[x].dATE_ADMINISTERED;
            Date immunizationDATE   = new SimpleDateFormat("yyyy-MM-dd").parse(immunizationDATE_ADMINISTERED);

            //immunizationName
            observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.ImmunizationName_ConceptID));
            observation.setValueText(immunizationName);
            //DATE_ADMINISTERED
            observation.setConcept(Context.getConceptService().getConcept(SMARTCardConstants.DATE_ADMINISTERED_ConceptID));
            observation.setValueDate(immunizationDATE);


        }

        encounter.addObs(observation);
        visit.addEncounter(encounter);

        vs.saveVisit(visit);

        Context.flushSession();
        Context.clearSession();

      //  Integer encounterId = encounter.getEncounterId();


      //  Encounter savedEncounter = (Encounter) visit.getEncounters().toArray()[0];


    }
}