   public static String getIfBannedWords(String fromText) {
       List<String> bwords=getBannedWords(fromText);
       if(!bwords.isEmpty()) {
           StringBuilder words=new StringBuilder();
           String app=", ";
           boolean first=false;
           for(String w:bwords) {
               words.append(w);
               if(first)
                   first=false;
               else
                   words.append(app);
           }
           return words.toString();
       }
       return null;
   }

