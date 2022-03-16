   public static String restrictLength(String content, int length) {
       if(content==null)
           return "";
       if(content.length()>=length)
           return content.substring(0,length);
       else
           return content;
   }

