   public static long toLong(String in)  {
       long out = 0;
       try {
           out= Long.valueOf(in).longValue();
       } catch(Exception e)    {
           
       }
       return out;
   }

