    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        if (axis.mEntries[axis.mEntries.length -1] == value) {
            return unit;
        }
        return decimalFormat.format(value);
    }

