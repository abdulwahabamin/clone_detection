    /**
     * Method that hide the software when the software showing.
     *
     * */
    private void hideSoftInput(View view){
        if (mImm != null) {
            mImm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

