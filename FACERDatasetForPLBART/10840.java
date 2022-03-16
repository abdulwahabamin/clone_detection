    /**
     * {@inheritDoc}
     */
    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 8) {
            try {
                setColor(toARGB(s.toString()), true);
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

