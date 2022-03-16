   public static String makeDbSafe(String makeSafe, int maxLength)    {
       if(makeSafe!=null)  {
           makeSafe=makeSafe.replaceAll("&","&#26;");
           makeSafe=makeSafe.replaceAll("'","&#27;");
           return restrictLength(makeSafe,maxLength);
       } else  {
           return "";
       }
   }

