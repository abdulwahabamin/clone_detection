   public static String getFirstWord(String in) {
       if(in!=null && in.indexOf(" ")!=-1) {
           return in.split(" ")[0];
       } else {
           return in;
       }
   }

