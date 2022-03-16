    private void toggleValues() {
        toggleValuesForGraph(mTemperatureChart.getData());
        toggleValuesForGraph(mWindChart.getData());
        toggleValuesForGraph(mRainChart.getData());
        toggleValuesForGraph(mSnowChart.getData());
        toggleValuesForGraph(mPressureChart.getData());
        mTemperatureChart.invalidate();
        mWindChart.invalidate();
        mRainChart.invalidate();
        mSnowChart.invalidate();
        mPressureChart.invalidate();
    }

