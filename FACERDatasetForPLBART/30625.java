    public void setTimes(String startTime, String endTime, String currentTime) {
        mStartTime = startTime;
        mEndTime = endTime;
        mCurrentTime = currentTime;

        String currentTimes[] = currentTime.split(":");
        String startTimes[] = startTime.split(":");
        String endTimes[] = endTime.split(":");
        float currentHour = Float.parseFloat(currentTimes[0]);
        float currentMinute = Float.parseFloat(currentTimes[1]);

        float startHour = Float.parseFloat(startTimes[0]);
        endHour = Float.parseFloat(endTimes[0]);
        if (!isSun && endHour < startHour) {
            endHour += 24;
        }
        float endMinute = Float.parseFloat(endTimes[1]);

        if (isSun) {
            if (currentHour > endHour) {
                mCurrentTime = endTime;
            } else if (currentHour == endHour && currentMinute >= endMinute) {
                mCurrentTime = endTime;
            }
        }

        mTotalMinute = calculateTime(mStartTime, mEndTime, false);//计算总时间，�?��?：分钟
        mNeedMinute = calculateTime(mStartTime, mCurrentTime, true);//计算当�?所给的时间 �?��?：分钟
        mPercentage = Float.parseFloat(formatTime(mTotalMinute, mNeedMinute));//当�?时间的总分钟数�?�日出日�?�总分钟数的百分比
        mCurrentAngle = 180 * mPercentage;

        setAnimation(0, mCurrentAngle, 2000);

    }

