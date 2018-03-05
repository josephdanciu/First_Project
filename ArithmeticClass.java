//Arithmetic Class Header Information//////////////////////////
/**
 * ArithemticClass class for Java array operations
 * such as adding, and subtracting
 * 
 * @author J.Danciu
 */
public class ArithmeticClass extends java.lang.Object
{
   public ArithmeticClass()
   {
   }
   
  /**
    * Method DigitClass addRegisters takes in two DigitClasses and adds their
    * digitArrays together and puts that into a new DigitClass
    * <p>
    * @param register_1 is a DigitClass that holds an array
    * <p>
    * @param register_2 is a second DigitClass that holds another array
    * <p>
    * @return a DigitClass holding the array that equals the added number
    */
    public DigitClass addRegisters
        (  
        DigitClass register_1, 
        DigitClass register_2
        )
    {
        DigitClass temporaryRegisterOne = new DigitClass( register_1 );
        DigitClass temporaryRegisterTwo = new DigitClass( register_2 );
        int registerOneBase = temporaryRegisterOne.base;
        int registerTwoBase = temporaryRegisterTwo.base;
        int baseForAdding = temporaryRegisterOne.base; 
        int index;
        int carry = 0;
        int tempNumber;
        int sumAtStart = 0;
        int numOfDigitsForFinalArray = getMax( temporaryRegisterOne.numDigits, 
                                         temporaryRegisterTwo.numDigits ) + 1;
        DigitClass theSumOfAddingTwoRegisters = new DigitClass(baseForAdding, 
                                                    numOfDigitsForFinalArray, 
                                                                sumAtStart );
        int[] addedArray = theSumOfAddingTwoRegisters.digitArray;
        if ( registerOneBase != registerTwoBase )
        {
            return null;
        }
        for ( index = 0; index < numOfDigitsForFinalArray; index++ )
        {
            tempNumber = temporaryRegisterOne.digitArray[ index ] + 
                         temporaryRegisterTwo.digitArray[ index ] + carry;          
            if ( tempNumber >= baseForAdding )
            {
                addedArray[ index ] = tempNumber % baseForAdding;
                carry = 1;
            }
            addedArray[ index ] = tempNumber;
            carry = 0;
        }   
        return theSumOfAddingTwoRegisters;
    }
        
  /**
    * Method DigitClass subtractRegisters takes in two DigitClasses and 
    * subtracts their digitArrays and puts that into a new DigitClass, however
    * if the second array is bigger than the first, it returns a null because 
    * this program does not compute negatives. 
    * <p>
    * @param register_1 is a DigitClass that holds an array
    * <p>
    * @param register_2 is a second DigitClass that holds another array
    * <p>
    * @return a DigitClass holding the array that equals the subtracted number
    */
//    public DigitClass subtractRegisters
//        ( 
//        DigitClass register_1, 
//        DigitClass register_2
//        )
//    {
//        DigitClass temporaryRegisterOne = new DigitClass( register_1 );
//        DigitClass temporaryRegisterTwo = new DigitClass( register_2 );
//        int registerOneBase = temporaryRegisterOne.base;
//        int registerTwoBase = temporaryRegisterTwo.base;
//        int registerBase = registerOneBase;
//        int biggestNumber = getMax( temporaryRegisterOne.getValueAsDecimal(), 
//                                  temporaryRegisterTwo.getValueAsDecimal() );
//        int numOfDigitsForFinalArray = getMax( temporaryRegisterOne.numDigits, 
//                                             temporaryRegisterTwo.numDigits );
//        int index;
//        int subAtStart = 0;
//        int tempNumber;
//        boolean overflow = false;
//        DigitClass theSumOfSubTwoRegisters = new DigitClass( registerBase, 
//                                                 numOfDigitsForFinalArray, 
//                                                             subAtStart );
//        int[] subtractArray = theSumOfSubTwoRegisters.digitArray;
//        if ( registerOneBase != registerTwoBase )
//        {
//            return null;
//        }
//        if( biggestNumber != temporaryRegisterOne.getValueAsDecimal() )
//        {
//            return null;
//        }
//        for ( index = 0; index < numOfDigitsForFinalArray; index++ )
//        {
//            if (temporaryRegisterOne.digitArray[ index ] 
//              < temporaryRegisterTwo.digitArray[ index ])
//            {
//                if (overflow == true)
//                {
//                   tempNumber = (temporaryRegisterOne.digitArray[ index ] 
//                                                   +  registerBase - 1) ;
//                   subtractArray[ index ] = tempNumber 
//                                  - temporaryRegisterTwo.digitArray[ index ];
//                   overflow = true;
//                }
//                tempNumber = (temporaryRegisterOne.digitArray[ index ] 
//                                                      + registerBase);
//                subtractArray[ index ] = tempNumber 
//                                   - temporaryRegisterTwo.digitArray[ index ];
//                overflow = true;
//            }
//            subtractArray[ index ] = temporaryRegisterOne.digitArray[ index ] 
//                                   - temporaryRegisterTwo.digitArray[ index ];
//            overflow = false;
//        }
//        return theSumOfSubTwoRegisters;
//    }
    
  /**
    * Method getMax takes in two integer values and checks which ones is
    * the bigger out of the two
    * <p>
    * @param valOne holds an integer that will later be compared to valTwo
    * <p>
    * @param valTwo holds an integer that will be compared to valOne
    * <p>
    * @return the integer of the greater number 
    */
    private int getMax ( int valOne, int valTwo )
    {
        if( valOne > valTwo )
        {
           return valOne;
        }
        return valTwo;
    }
    
    public DigitClass subtractRegisters( DigitClass register_1,
        DigitClass register_2 )
        {
        DigitClass registerOneCopy = new DigitClass( register_1 );
        DigitClass registerTwoCopy = new DigitClass( register_2 );
        DigitClass differenceOfRegisters = new DigitClass( registerOneCopy );
        
        if( ( registerOneCopy.base != registerTwoCopy.base ) ||
            ( registerOneCopy.maxDigits < registerTwoCopy.maxDigits ) )
            {
            return null;    
            }
        
        int maxDigits = getMax( registerOneCopy.maxDigits,
            registerTwoCopy.maxDigits );
        //int minDigits = getMin( registerOneCopy.maxDigits,
            //registerTwoCopy.maxDigits ) + 1;
        differenceOfRegisters.maxDigits = maxDigits;
        int[] arrayOne = registerOneCopy.digitArray;
        int[] arrayTwo = registerTwoCopy.digitArray;
        differenceOfRegisters.digitArray =
            differenceOfRegisters.initializeDigits();
        int[] differenceArray = differenceOfRegisters.digitArray;
        int base = differenceOfRegisters.base;
        int index;
        int tempIndex;
        int difference;
        boolean borrowFlag;
        for( index = 0; index < maxDigits; index++ )
            {
            tempIndex = index;
            
            if( arrayOne[ index ] < arrayTwo[ index ] )
                {
                borrowFlag = true;
                while( borrowFlag == true )
                    {
                    arrayOne[ tempIndex ] = arrayOne[ tempIndex ] + base;
                    tempIndex++;
                    
                    if( registerOneCopy.maxDigits - 1 < tempIndex ) 
                        {
                        return null;
                        }
                    
                    arrayOne[ tempIndex ]--;
                    
                    if( tempIndex > maxDigits )
                        {
                        return null;
                        }
                    
                    if( arrayOne[ tempIndex ] >= 0 )
                        {
                        borrowFlag = false;    
                        }
                    
                    }
                }
            difference = arrayOne[ index ]-arrayTwo[ index ];
            differenceArray[ index ] = difference;
            }
        differenceOfRegisters.digitArray = differenceArray;

        return differenceOfRegisters;
        }
}