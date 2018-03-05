//Digit Class Header Information//////////////////////////
/**
 * DigitClass class for Java array operations
 * such as decToBase, getValueAsDecimal, etc..
 * 
 * @author J.Danciu
 */
public class DigitClass extends java.lang.Object
{
    protected int maxDigits;
    protected int numDigits;
    protected boolean overFlow;
    protected int[] digitArray;
    protected int base;
    
  /**
    * Method creates a DigitClass object
    * <p>
    * @param baseSet holds the base number for calculations 
    * <p>
    * @param maxDigitSet holds the number of max digits the array can have
    * <p>
    * @param decValSet holds the decimal value of the inputed number
    * <p>
    */
    public DigitClass
        (
        int baseSet,
        int maxDigitSet,
        int decValSet
        )
    {
        base = baseSet;
        maxDigits = maxDigitSet;
        digitArray = decToBase( decValSet ); 
    }
        
  /**
    * Method creates a DigitClass object copy
    * <p>
    */    
    public DigitClass( DigitClass copied )  
        {
            base = copied.base;
            maxDigits = copied.maxDigits;
            numDigits = copied.numDigits;
            overFlow = copied.overFlow;
            digitArray = new int[ maxDigits ];
            int index;
            for ( index = 0; index < numDigits; index++ )
            {
               digitArray[ index ] = copied.digitArray[ index ];
            }
        }
    
    /**
      *Method converts decimal number to the given base and then 
      *puts that number back into an array
      * <p>
      * @param decValue holds the decimal value of what number needs to be 
      * converted to the given base
      * <p>
      * @return integer array of converted decimal value
      * <p>
      */ 
    private int[] decToBase( int decValue )
    {
        int decimalValue = decValue;
        int givenBase = base;
        int[] baseArray = initializeDigits();;
        int index = 0;
        int minBase = 2;
        int maxBase = 10;
        if ( ( givenBase < minBase ) 
           || ( givenBase > maxBase ) )
        {
           overFlow = true;
           return null;
        }
        while ( decimalValue > 0 )
        {
            baseArray[ index ]= decimalValue % givenBase;
            decimalValue /= givenBase;
            index++;
            if( index >= maxDigits )
            {
               return null;
            }
        }
        numDigits = index; 
        return baseArray;
    }
    
    /**
      *Method converts an integer array (any base) to a decimal (base 10) 
      *and then puts it back into an array
      * <p>
      * @return integer of the total value
      * <p>
      */     
    public int getValueAsDecimal()
    {
       int index;
       int totalValue = 0;
       for ( index = 0; index < maxDigits; index++ )
       {
          totalValue += digitArray[ index ] * intToPower( base, index );
       }
       return totalValue;
    }
    
    /**
      *Method converts an integer array to a readable string
      * <p>
      * @return string of converted flipped array that was given
      * <p>
      */     
    public String getValueAsBase()
    { 
       int index;
       int [] givenArray = digitArray;
       int [] flippedArray = new int[ maxDigits ];
       int maxDig = maxDigits - 1;
       String output = "";
       int tempNumber = 0;
       for( index = 0; index <= maxDig; index++ )
       {
          flippedArray[ maxDig - index ] = digitArray[ index ];
          tempNumber = flippedArray[ index ];
          output += Integer.toString( tempNumber );
       }
       return output;
    }
    
    /**
      *Method creates an all zeroed out integer array
      * <p>
      * @return the created zeroed out array
      * <p>
      */    
    public int[] initializeDigits()
    {
       int[] newAllZeroedOutArray = new int[ maxDigits ];
       return newAllZeroedOutArray;
    }
    
    /**
      *Method checks to see if DigitClass.digitArray is zero or if it has
      *something inside of it
      * <p>
      * @return Boolean of true of false if the given array has nothing in it
      * <p>
      */     
    public boolean isZero()
    {
       return( numDigits <= 1 && digitArray[ 0 ] == 0 );
    }
    
    /**
      *Method calculates base^exponent through a recursive function
      * <p>
      * @param base holds the base value: the number that will be raised 
      *to something
      * <p>
      * @param exponent holds the value of what the base is raised to
      * <p>
      * @return integer value of the operation
      */     
    int intToPower( int base, int exponent )
    {
       int baseGiven = base;
       int exponentGiven = exponent;
       if ( exponentGiven > 0 )
       {
          return baseGiven * intToPower( baseGiven, exponentGiven-1 );
       }
       return 1; 
    }
}