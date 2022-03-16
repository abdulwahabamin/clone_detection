   public static String reverseDbSafe(String makeSafe)    {
       if(makeSafe!=null)  {
           makeSafe=makeSafe.replaceAll("&#27;","'");
           return makeSafe.replaceAll("&#26;","&");
       } else  {
           return "";
       }
   }

