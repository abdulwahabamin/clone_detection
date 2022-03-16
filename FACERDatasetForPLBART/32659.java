        private int getLogFileLastingLabel(int logFileLastingValue) {
            int logFileLastingId;
            switch (logFileLastingValue) {
                case 12:
                    logFileLastingId = R.string.log_file_12_label;
                    break;
                case 48:
                    logFileLastingId = R.string.log_file_48_label;
                    break;
                case 72:
                    logFileLastingId = R.string.log_file_72_label;
                    break;
                case 168:
                    logFileLastingId = R.string.log_file_168_label;
                    break;
                case 720:
                    logFileLastingId = R.string.log_file_720_label;
                    break;
                case 24:
                default:
                    logFileLastingId = R.string.log_file_24_label;
                    break;
            }
            return logFileLastingId;
        }

