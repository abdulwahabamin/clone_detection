   public static boolean toBoolean(String in) {
       if(in==null || in.equals("0") || in.equals("") || in.equals("false"))
           return false;
       else
           return true;
   }

