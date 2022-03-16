   public static double toDouble(String in)  {
       double out = 0;
       try {
           out= Double.valueOf(in).doubleValue();
       } catch(Exception e)    {
           
       }
       return out;
   }

