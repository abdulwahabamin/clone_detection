   public static int toInt(String in)  {
       int out = 0;
       try {
           out= Integer.valueOf(in).intValue();
       } catch(Exception e)    {
           
       }
       return out;
   }

