        private void checkAndDeleteLocations() {
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getActivity());
            List<Location> allLocations = locationsDbHelper.getAllRows();
            if (allLocations.size() <= ApiKeys.getAvailableLocations(getActivity())) {
                return;
            }
            for (Location location: allLocations) {
                if (location.getOrderId() >= ApiKeys.getAvailableLocations(getActivity())) {
                    locationsDbHelper.deleteRecordFromTable(location);
                }
            }
            sendMessageToReconciliationDbService(true);
        }

