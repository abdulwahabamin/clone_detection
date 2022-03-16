    private static String createLogFileName() {
        int year, month, day, hour;
        boolean needChangeName = false;
        Calendar c = LogToES.getThreadCalendar();//�?少创建对象
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        if(year != mTimes[0]) {
            mTimes[0] = year;
            needChangeName = true;
        }
        if(month != mTimes[1]) {
            mTimes[1] = month;
            needChangeName = true;
        }
        if(day != mTimes[2]) {
            mTimes[2] = day;
            needChangeName = true;
        }
        if(hour != mTimes[3]) {
            mTimes[3] = hour;
            needChangeName = true;
        }
        if(needChangeName) {
            mLogFileNameByHour = createLogFileName(year,month,day,hour);
        }
        return mLogFileNameByHour;
    }

