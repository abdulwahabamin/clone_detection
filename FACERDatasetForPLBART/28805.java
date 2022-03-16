    /**
     * @see ItemTouchHelperAdapter#onItemMove(int, int)
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        // For updating the database records
//        int fromCurrentWeatherDataID = listItems.get(fromPosition).getCurrentWeatherDataID();
//        int toCurrentWeatherDataID = listItems.get(toPosition).getCurrentWeatherDataID();
//        CityToWatch fromCityToWatch = null;
//        CityToWatch toCityToWatch = null;
//        try {
//            CurrentWeatherData fromCurrentWeatherData = dbHelper.getCurrentWeatherDataByID(fromCurrentWeatherDataID);
//            CurrentWeatherData toCurrentWeatherData = dbHelper.getCurrentWeatherDataByID(toCurrentWeatherDataID);
//            fromCityToWatch = dbHelper.getCityToWatchByCityId(fromCurrentWeatherData.getCity().getId());
//            toCityToWatch = dbHelper.getCityToWatchByCityId(toCurrentWeatherData.getCity().getId());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (fromPosition < toPosition) {
//            for (int i = fromPosition; i < toPosition; i++) {
//                if (fromCityToWatch != null && toCityToWatch != null) {
//                    dbHelper.swapRanksOfCitiesToWatch(fromCityToWatch, toCityToWatch);
//                }
//                Collections.swap(listItems, i, i + 1);
//            }
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                if (fromCityToWatch != null && toCityToWatch != null) {
//                    dbHelper.swapRanksOfCitiesToWatch(toCityToWatch, fromCityToWatch);
//                }
//                Collections.swap(listItems, i, i - 1);
//            }
//        }
//        notifyItemMoved(fromPosition, toPosition);
    }

