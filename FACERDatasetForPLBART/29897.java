    public void toggleValues() {
        if (i == 1) {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(context() , R.drawable.ic_radio_button_unchecked_white_24dp));
            i = 0;
        }
        else {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(context() , R.drawable.ic_radio_button_checked_white_24dp));
            i = 1;
        }
        for (IDataSet set : temperatureChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
            set.setValueTextColor(Color.WHITE);
        }
        temperatureChart.invalidate();
        for (IDataSet set : rainChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
            set.setValueTextColor(Color.WHITE);
        }
        for (IDataSet set : pressureChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
            set.setValueTextColor(Color.WHITE);
        }
        for (IDataSet set : snowChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
            set.setValueTextColor(Color.WHITE);
        }
        for (IDataSet set : windChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
            set.setValueTextColor(Color.WHITE);
        }
        temperatureChart.invalidate();
        rainChart.invalidate();
        pressureChart.invalidate();
        snowChart.invalidate();
        windChart.invalidate();
    }

