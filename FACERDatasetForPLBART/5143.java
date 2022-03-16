   public static String getPositionNumber(int position) {
       String pos="th";
       if(position%10==1 && position!=11) pos="st";
       if(position%10==2 && position!=12) pos="nd";
       else if(position%10==3 && position!=13) pos="rd";
       return position+pos;
   }

