    public static String createLogFileName(int year, int month, int day, int hour) {
        StringBuffer buffer = new StringBuffer(getOptions().logIdentifier+"_"+year);
        if(month > 9) {
            buffer.append("_");
            buffer.append(month);
        } else {
            buffer.append("_0");
            buffer.append(month);
        }
        if(day > 9) {
            buffer.append("_");
            buffer.append(day);
        } else {
            buffer.append("_0");
            buffer.append(day);
        }
        if(hour > 9) {
            buffer.append("_");
            buffer.append(hour);
        } else {
            buffer.append("_0");
            buffer.append(hour);
        }
        buffer.append(".txt");
        return buffer.toString();
    }

