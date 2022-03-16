    public CurrentWeatherDetailSwitchListener(boolean initialValue, Switch[] dependentSwitches, int switchIndex, int numberOfAvailableDetailsInWidget) {
        checked = initialValue;
        this.dependentSwitches = dependentSwitches;
        this.switchIndex = switchIndex;
        this.numberOfAvailableDetailsInWidget = numberOfAvailableDetailsInWidget;
    }

