    @SuppressLint("SetTextI18n")
    @Override
    public void getAlarm(Alarm bean) {
        if (bean != null && bean.getAlarm().size() > 0 && bean.getAlarm().get(0) != null) {
            tvAlarm.setVisibility(View.VISIBLE);
            AlarmBase alarmBase = bean.getAlarm().get(0);
            String level = alarmBase.getLevel();
            String type = alarmBase.getType();
            if (ContentUtil.SYS_LANG.equals("en")) {
                tvAlarm.setText(type);
            } else {
                tvAlarm.setText(type + "预警");
            }
            if (!TextUtils.isEmpty(level)) {
                switch (level) {
                    case "�?色":
                    case "Blue":
                        tvAlarm.setBackground(getResources().getDrawable(R.drawable.shape_blue_alarm));
                        tvAlarm.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case "黄色":
                    case "Yellow":
                        tvAlarm.setBackground(getResources().getDrawable(R.drawable.shape_yellow_alarm));
                        tvAlarm.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case "橙色":
                    case "Orange":
                        tvAlarm.setBackground(getResources().getDrawable(R.drawable.shape_orange_alarm));
                        tvAlarm.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case "红色":
                    case "Red":
                        tvAlarm.setBackground(getResources().getDrawable(R.drawable.shape_red_alarm));
                        tvAlarm.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case "白色":
                    case "White":
                        tvAlarm.setBackground(getResources().getDrawable(R.drawable.shape_white_alarm));
                        tvAlarm.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
            }
        } else {
            tvAlarm.setVisibility(View.GONE);
        }
    }

