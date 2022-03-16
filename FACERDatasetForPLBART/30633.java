    /**
     * 根�?�日出和日�?�时间计算出一天总共的时间:�?��?为分钟
     *
     * @param startTime 日出时间
     * @param endTime   日�?�时间
     * @return
     */
    private float calculateTime(String startTime, String endTime, boolean isCurrent) {
        String startTimes[] = startTime.split(":");
        String endTimes[] = endTime.split(":");
        float startHour = Float.parseFloat(startTimes[0]);
        float startMinute = Float.parseFloat(startTimes[1]);

        float endHour = Float.parseFloat(endTimes[0]);
        float endMinute = Float.parseFloat(endTimes[1]);

        if (!isCurrent && !isSun && endHour < startHour) {
            endHour += 24;
        }

        if (isSun) {
            if (startHour > endHour) {
                return 0;
            } else if (startHour == endHour && startMinute >= endMinute) {
                return 0;
            }
        } else {
            if (isCurrent) {
                if (startHour > endHour) {
                    return 0;
                } else if (startHour == endHour && startMinute >= endMinute) {
                    return 0;
                }
            } else {
                if (startHour >= endHour + 24) {
                    return 0;
                }
            }
        }

        if (checkTime(startTime, endTime)) {
            return (endHour - startHour - 1) * 60 + (60 - startMinute) + endMinute;
        }
        return 0;
    }

