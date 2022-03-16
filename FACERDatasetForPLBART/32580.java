    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        checked = isChecked;
        if (dependentSwitch != null) {
            if (isChecked) {
                dependentSwitch.setChecked(false);
                dependentSwitch.setEnabled(false);
            } else {
                dependentSwitch.setEnabled(true);
            }
        }
    }

