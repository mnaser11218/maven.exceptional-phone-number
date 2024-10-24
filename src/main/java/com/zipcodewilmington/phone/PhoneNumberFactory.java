package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory{
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        return null;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() throws InvalidPhoneNumberFormatException {
        String areaCode="";
        String centralOfficeCode="";
        String phoneLineCode="";

        for(int i=0; i<10;i++){
            if(i<3){
                areaCode += RandomNumberFactory.createInteger(1,9);
            }else if(i>2 && i<6){
                centralOfficeCode += RandomNumberFactory.createInteger(1,9);
            }else{
                phoneLineCode +=  RandomNumberFactory.createInteger(1,9);
            }
        }
        System.out.println(areaCode + " " +  centralOfficeCode + " : " + phoneLineCode);
            return createPhoneNumberSafely(Integer.parseInt(areaCode), Integer.parseInt(centralOfficeCode), Integer.parseInt(phoneLineCode));


    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
      try{
          String num= "(" + String.valueOf(areaCode) + ")-" + String.valueOf(centralOfficeCode)+"-" + String.valueOf(phoneLineCode);
          return new PhoneNumber(num);
      }catch(InvalidPhoneNumberFormatException ipfe){
          return null;
      }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        return new PhoneNumber(phoneNumberString);
    }
}
