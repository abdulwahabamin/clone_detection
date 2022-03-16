   public static String htmlSafe(String in) {
       if(in!=null) {
           in=in.replaceAll("<", "&lt;");
           in=in.replaceAll(">", "&gt;");
           return in;
       } else
           return "";
   }

