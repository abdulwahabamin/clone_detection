    /**
     * {@inheritDoc}
     */
    @Override
    public void afterTextChanged(Editable s) {
        String name = s.toString().trim();
        checkName(name);
    }

