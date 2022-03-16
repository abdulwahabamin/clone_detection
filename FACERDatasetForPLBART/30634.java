    /**
     * 对所给的时间�?�一下简�?�的数�?�校验
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private boolean checkTime(String startTime, String endTime) {
        if (TextUtils.isEmpty(startTime) || TextUtils.isEmpty(endTime)
                || !startTime.contains(":") || !endTime.contains(":")) {
            return false;
        }

        String startTimes[] = startTime.split(":");
        String endTimes[] = endTime.split(":");
        float startHour = Float.parseFloat(startTimes[0]);
        float startMinute = Float.parseFloat(startTimes[1]);

        float endHour = Float.parseFloat(endTimes[0]);
        float endMinute = Float.parseFloat(endTimes[1]);

        //如果所给的时间(hour)�?于日出时间（hour）或者大于日�?�时间（hour）
        if ((startHour < Float.parseFloat(mStartTime.split(":")[0]))
                || (endHour > this.endHour)) {
            return false;
        }

        //如果所给时间与日出时间：hour相等，minute�?于日出时间
        if ((startHour == Float.parseFloat(mStartTime.split(":")[0]))
                && (startMinute < Float.parseFloat(mStartTime.split(":")[1]))) {
            return false;
        }

        //如果所给时间与日�?�时间：hour相等，minute大于日�?�时间
        if ((startHour == this.endHour)
                && (endMinute > Float.parseFloat(mEndTime.split(":")[1]))) {
            return false;
        }

        if (startHour < 0 || endHour < 0
                || startHour > 23 || endHour > 23
                || startMinute < 0 || endMinute < 0
                || startMinute > 60 || endMinute > 60) {
            return false;
        }
        return true;
    }

