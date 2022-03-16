    public void updateCurrentStyle() {
        if (selectorFragment != null) {
            adapter.notifyDataSetChanged();
            scrollToCurrentStyle();
        }

    }

