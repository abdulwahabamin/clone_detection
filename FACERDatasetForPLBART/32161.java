    public ArrayList<MultiselectionItem> getSelectedItems() {
        ArrayList<MultiselectionItem> selectedItems = new ArrayList<>();
        for (int i = 0; i < items.size(); ++i) {
            if (selection[i]) {
                selectedItems.add(items.get(i));
            }
        }
        return selectedItems;
    }

