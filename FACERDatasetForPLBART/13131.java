    /**
     * Set the relevance of the widget.
     *
     * @param relevance the mRelevance to set
     */
    public void setRelevance(float relevance) {
        this.mRelevance = relevance;
        if (relevance < 0) {
            this.mRelevance = 0.0f;
        }
        if (relevance > 100) {
            this.mRelevance = 100.0f;
        }

        //Change the color of the relevance depending on his percentage
        Iterator<Integer> it = this.mColors.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            if (this.mRelevance <= key.intValue()) {
                this.mRelevancePaint.setColor(this.mColors.get(key).intValue());
                break;
            }
        }

        //Invalidate the widget for drawing again
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

