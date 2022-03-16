    /**
     * @see Comparator#compare(Object, Object)
     * Return < 0 if lhs has a nicer weather than rhs.
     */
    @Override
    public int compare(RadiusSearchItem lhs, RadiusSearchItem rhs) {
        int categoryDifference = lhs.getWeatherCategory() - rhs.getWeatherCategory();
        if (categoryDifference == 0) {
            double temperatureDifference = lhs.getTemperature() - rhs.getTemperature();
            if (temperatureDifference == 0) {
                return 0;
            } else if (temperatureDifference < 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return categoryDifference;
        }
    }

