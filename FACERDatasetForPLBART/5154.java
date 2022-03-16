   public static String makeDbSafe(String makeSafe)    {
       if(makeSafe!=null)  {
           //makeSafe=makeSafe.replaceAll("'","");
           //makeSafe.replaceAll(";","&#59;");
           makeSafe=makeSafe.replaceAll("&","&#26;");
           makeSafe=makeSafe.replaceAll("'","&#27;");
           return makeSafe;
       } else  {
           return "";
       }
   }

