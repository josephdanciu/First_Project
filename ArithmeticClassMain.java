public class ArithmeticClassMain extends ArithmeticClass
{

    public static void main(String[] args) 
    {    
          DigitClass digitclass10 = new DigitClass(10,10,10);
          System.out.println("value as decimal");
          System.out.println(digitclass10.getValueAsDecimal());
          System.out.println("value as base (flipped array)");
          System.out.println(digitclass10.getValueAsBase());
          System.out.println("is this value zero?");
          System.out.println(digitclass10.isZero());
          System.out.println("number of digits");
          System.out.println(digitclass10.numDigits);
          System.out.println("base is");
          System.out.println(digitclass10.base);
          System.out.println("maxDigts = ");
          System.out.println(digitclass10.maxDigits);
          System.out.println("digit array");
          for(int i: digitclass10.digitArray)
          {
          System.out.print(i);
          }
//          System.out.println("");
//          System.out.println("NEXT DIGITCLASS");
          DigitClass digitclass100 = new DigitClass(10,10,2);
//          System.out.println("value as decimal");
//          System.out.println(digitclass100.getValueAsDecimal());
//          System.out.println("value as base (flipped array)");
//          System.out.println(digitclass100.getValueAsBase());
//          System.out.println("is this value zero?");
//          System.out.println(digitclass100.isZero());
//          System.out.println("number of digits");
//          System.out.println(digitclass100.numDigits);
//          System.out.println("base is");
//          System.out.println(digitclass100.base);
//          System.out.println("maxDigts = ");
//          System.out.println(digitclass100.maxDigits);
//          System.out.println("digit array");
//          for(int i: digitclass100.digitArray)
//              
//          {
//          System.out.print(i);
//          }
//          
//          System.out.println("");
          ArithmeticClass testing1 = new ArithmeticClass();
//          testing1.addRegisters(digitclass10, digitclass100);
          testing1.subtractRegisters(digitclass10, digitclass100);
//          
//          
//          System.out.println("Values for addition array. First = the array. Second = Value as Decimal");          
//          DigitClass sum = testing1.addRegisters(digitclass10, digitclass100);
//          //System.out.println(sum.digitArray);
//          for(int i: sum.digitArray)
//          {
//          System.out.print(i);
//          }  
//
//          
//          
//          
          System.out.println("Values for subtraction array. First = the array. Second = Value as Decimal");
          DigitClass sub = testing1.subtractRegisters(digitclass10, digitclass100);
          System.out.println(sub.digitArray);
          for(int i: sub.digitArray)
          {
          System.out.print(i);
          }     
 //         System.out.println(sub.digitArray[0]);
 //         System.out.println(sub.digitArray[1]);
//          System.out.println(sub.digitArray[2]);


          
          
          
          
          
          
//          int[] array2 = digitclass10.digitArray;
//          for (int i: array2)
//          {
//          System.out.print(i);
//          }
        
//        DigitClass test1 = new DigitClass(10, 10, 201);
//        System.out.println(test1.numDigits);
    }
    
}
