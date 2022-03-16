    /**
     *  Method that sets the percentage (from 0 to 1) of the item view width on which
     * an OnItemFlinger event occurs
     *
     * @param flingRemovePercentaje The percentage (from 0 to 1) of the item view width
     */
    public void setFlingRemovePercentaje(float flingRemovePercentaje) {
        if (flingRemovePercentaje < 0) {
            this.mFlingRemovePercentaje = 0;
        } else if (flingRemovePercentaje > 1) {
            this.mFlingRemovePercentaje = 1;
        } else {
            this.mFlingRemovePercentaje = flingRemovePercentaje;
        }
    }

