    public static String getFriendlyDateString(Date date, boolean showDayOfWeek) {
        if (date == null) {
            if (showDayOfWeek)
                return "--.--. 周--";
            else
                return "--.--.";
        }

        GregorianCalendar nowCalender = new GregorianCalendar();
        GregorianCalendar dstCalender = new GregorianCalendar();
        dstCalender.setTime(date);

        int now = nowCalender.get(GregorianCalendar.DAY_OF_YEAR);
        int dst = dstCalender.get(GregorianCalendar.DAY_OF_YEAR);
        int dstDayOfWeek = dstCalender.get(GregorianCalendar.DAY_OF_WEEK);
        String dstDayOfWeekString = "周--";
        if (showDayOfWeek) {
            switch (dstDayOfWeek) {
                case 1: {
                    dstDayOfWeekString = "周日";
                } break;
                case 2: {
                    dstDayOfWeekString = "周一";
                } break;
                case 3: {
                    dstDayOfWeekString = "周二";
                } break;
                case 4: {
                    dstDayOfWeekString = "周三";
                } break;
                case 5: {
                    dstDayOfWeekString = "周四";
                } break;
                case 6: {
                    dstDayOfWeekString = "周五";
                } break;
                case 7: {
                    dstDayOfWeekString = "周六";
                } break;
            }
        }

        if (dst - now == 0) {
            if (showDayOfWeek)
                return "今天" + " " + dstDayOfWeekString;
            else
                return "今天";
        } else if (dst - now == 1) {
            if (showDayOfWeek)
                return "明天" + " " + dstDayOfWeekString;
            else
                return "明天";
        } else if (dst - now == 2) {
            if (showDayOfWeek)
                return "�?�天" + " " + dstDayOfWeekString;
            else
                return "�?�天";
        } else if (dst - now == -1) {
            if (showDayOfWeek)
                return "昨天" + " " + dstDayOfWeekString;
            else
                return "昨天";
        } else if (dst - now == -2) {
            if (showDayOfWeek)
                return "�?天" + " " + dstDayOfWeekString;
            else
                return "�?天";
        } else {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat)SimpleDateFormat.getDateInstance();
            if (showDayOfWeek)
                simpleDateFormat.applyPattern("M.d EE");
            else
                simpleDateFormat.applyPattern("M.d");
            return simpleDateFormat.format(date);
        }
    }

