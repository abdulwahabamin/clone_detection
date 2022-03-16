    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        checked = isChecked;
        int switchedCounter = 0;
        for (Switch dependentSwitch: dependentSwitches) {
          if (dependentSwitch.isChecked()) {
            switchedCounter++;
          }
        }
        if (switchedCounter >= numberOfAvailableDetailsInWidget) {
          for (Switch dependentSwitch: dependentSwitches) {
            if (!dependentSwitch.isChecked()) {
              dependentSwitch.setEnabled(false);
            }
          }
        } else {
          for (Switch dependentSwitch: dependentSwitches) {
            dependentSwitch.setEnabled(true);
          }
        }
    }

