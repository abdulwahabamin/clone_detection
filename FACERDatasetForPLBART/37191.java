    public static String timeFormat(String source) {
        SimpleDateFormat sourceSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date now = new Date();
        try {
            Date date = sourceSdf.parse(source);
            if (date.getYear() != now.getYear()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                return sdf.format(date);
            } else if (date.getMonth() != now.getMonth()) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                return sdf.format(date);
            } else if (date.getDay() != now.getDay()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                if (sdf.parse(sdf.format(now)).getTime() - sdf.parse(sdf.format(date)).getTime() == DateUtils.DAY_IN_MILLIS) {
                    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
                    return "昨天 " + sdf2.format(date);
                } else {
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                    return sdf2.format(date);
                }
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                return sdf.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return source;
    }

