    @Override
    public int getInt(int columnIndex) {
        if (columnIndex == super.getColumnCount())
            return counts[getPosition()];
        else
            return super.getInt(columnIndex);
    }

