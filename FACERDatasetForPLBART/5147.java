   public static String urlSafe(String in) {
       if(in==null)
           return "";
       else
           return in.replaceFirst(" ", "%20");
   }

