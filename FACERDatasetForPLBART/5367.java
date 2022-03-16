    public static String getCompleteDate(String date){
        String finalDate="";
        try {
            Date d = completeDateFormat.parse(date);
            finalDate=completeDateFormat.format(d);
            //finalDate=calendar.get(Calendar.DAY_OF_MONTH)+" "+calendar.get(Calendar.)+" "+calendar.get(Calendar.YEAR);
        }catch (Exception e){
            Log.e(TAG,"date error: "+e.getMessage());
            e.printStackTrace();
        }
        return finalDate;
    }

