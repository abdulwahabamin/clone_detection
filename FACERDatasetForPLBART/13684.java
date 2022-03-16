    @Override
    public void performBackPressedOperation() {
        if (CURRENT_DIR_PATH.equalsIgnoreCase(CURRENT_DIR)) {
            super.performBackPressedOperation();
        } else {
            presenter.loadParentModelData(CURRENT_DIR);
        }
    }

