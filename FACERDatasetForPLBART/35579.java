    public static String dayForWeek(String pTime){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tmpDate = null;
        try {
            tmpDate = format.parse(pTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = new GregorianCalendar();
        cal.set(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());
        switch (cal.get(Calendar.DAY_OF_WEEK)){
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
        }
        return "Error";
    }

