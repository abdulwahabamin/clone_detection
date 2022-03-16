        private void updateSummary(String key, boolean changing) {
            entrySummary(key);
            if (changing) {
                Intent intent = new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE);
                intent.setPackage("org.thosp.yourlocalweather");
                getActivity().sendBroadcast(intent);
            }
        }

