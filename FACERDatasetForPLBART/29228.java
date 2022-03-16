    public void initDate(){
        Date dt = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        String tmp=df.format(dt);
        String[] tmpArray=tmp.split("年");
        int solarYear=Integer.parseInt(tmpArray[0]);
        tmp=tmpArray[0]+"-";
        tmpArray=tmpArray[1].split("月");
        int solarMonth=Integer.parseInt(tmpArray[0]);
        tmp=tmp+tmpArray[0]+"-";
        tmpArray=tmpArray[1].split("日");
        int solarDay=Integer.parseInt(tmpArray[0]);
        tmp=tmp+tmpArray[0];
        String date_flag=wnl_spf.getString("date_flag","");
        //to ensure the call of method dateTransformation() no more than
        //once a day.
        if(!date_flag.equals(tmp)){
            date_flag=tmp;
            SharedPreferences.Editor wnl_editor=wnl_spf.edit();
            wnl_editor.putString("date_flag",date_flag);
            String nongLi= LunarCalendar.solarToLunar(solarYear,solarMonth,solarDay);
            wnl_editor.putString("nongLi",nongLi);
            df=DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
            tmp=df.format(dt);
            tmpArray=tmp.split("星期");
            wnl_editor.putString("weekDay","周"+tmpArray[1]);
            wnl_editor.apply();
            weekDayTransformation();
        }
    }

