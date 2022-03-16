   public static List<String> getBannedWords(String fromText) {
       ArrayList<String> ban=new ArrayList();

       if(fromText!=null) {
           String useText=fromText;
           // this is only designed to process short messages, so if it's longer than 140 char then ignore all after 140 char and cover the first part of message.
           if(useText.length()>140)
               useText=useText.substring(0,139);

           useText=useText.toLowerCase()+" ";
           String nowhite=useText.replaceAll("[^A-Za-z0-9]", "");

           for(int i=0; i<banned.length; i++) {
               if(useText.indexOf(banned[i])!=-1) {
                   ban.add(banned[i]);
               }
           }

           for(int i=0; i<bannedNoWhitespace.length; i++) {
               if(nowhite.indexOf(bannedNoWhitespace[i])!=-1) {
                   ban.add(bannedNoWhitespace[i]);
               }
           }
       }
       return ban;
   }

