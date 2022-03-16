    public ArrayList<MultiselectionLocationItem> getSelectedItems() {
        ArrayList<MultiselectionLocationItem> selectedItems = new ArrayList<>();
        for (int i = 0; i < items.size(); ++i) {
            if (selection[i]) {
                selectedItems.add(items.get(i));
            }
        }
        return selectedItems;
    }

