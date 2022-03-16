    public String getTag() {
        for (View tag : tagViews) {
            if (tag.isSelected()) {
                return ((TextView) tag).getText().toString();
            }
        }
        return ((TextView) tagViews.get(2)).getText().toString();
    }

