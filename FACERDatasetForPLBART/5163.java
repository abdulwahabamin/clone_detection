   public static String removeNewLines(String content) {
       if(content!=null) {
           content = content.replaceAll("\r\n","");
           content = content.replaceAll("\n","");
           content = content.replaceAll("\r","");
       }
       return content;
   }

