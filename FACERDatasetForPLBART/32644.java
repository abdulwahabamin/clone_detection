        private int getWakeUpStrategyLabel(String wakeUpStrategyValue) {
            int wakeUpStrategyId;
            switch (wakeUpStrategyValue) {
                case "wakeuppartial":
                    wakeUpStrategyId = R.string.wakeuppartial_label;
                    break;
                case "wakeupfull":
                    wakeUpStrategyId = R.string.wakeupfull_label;
                    break;
                case "nowakeup":
                default:
                    wakeUpStrategyId = R.string.nowakeup_label;
                    break;
            }
            return wakeUpStrategyId;
        }

