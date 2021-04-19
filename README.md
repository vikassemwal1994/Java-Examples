# Java-Examples
Some java codes to help in critical concepts


1. Filename : Sort_Array_AsPer_Occurrence
2. Mobile info : get mobile ip and mac address
3. VerhoeffAlgorith : validate adhaar number -- 
    public static boolean validateAadharNumber(String aadharNumber) {
        Pattern aadharPattern = Pattern.compile("\\d{12}");
        boolean isValidAadhar = aadharPattern.matcher(aadharNumber).matches();
        if (isValidAadhar) {
            isValidAadhar = VerhoeffAlgorithm.validateVerhoeff(aadharNumber);
        }
        return isValidAadhar;
    }

Explaination - there are array of integer and we can sort array preferce of ocuurence
like - input{6,5,6,2,4,1,8,7,5,6,9,5,4,2,1,6}
       output{6, 6, 6, 6, 5, 5, 5, 4, 4, 1, 1, 2, 2, 7, 8, 9}
       
----------------------------------------------------------------------------------
  
