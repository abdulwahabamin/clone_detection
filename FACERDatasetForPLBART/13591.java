        @Override
        public int compare(AppModel a1, AppModel a2) {
            if (a1.getAppName() != null && a2.getAppName() != null) {
                return a1.getAppName().compareToIgnoreCase(a2.getAppName());
            } else if (a1.getAppName() != null) {
                return 1;
            } else if (a2.getAppName() != null) {
                return -1;
            }
            return 0;
        }

