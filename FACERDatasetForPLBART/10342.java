    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        //Configure the paints
        float density = getResources().getDisplayMetrics().density;
        this.mBorderPaint.setColor(getResources().getColor(R.color.relevance_border));
        this.mBorderPaint.setStrokeWidth((1 * density) + 0.5f);
        this.mRelevancePaint.setColor(Color.TRANSPARENT);

        //Create the color map
        this.mColors = new TreeMap<Integer, Integer>();
        this.mColors.put(Integer.valueOf(25),
                Integer.valueOf(getResources().getColor(R.color.relevance_percentil_25)));
        this.mColors.put(Integer.valueOf(50),
                Integer.valueOf(getResources().getColor(R.color.relevance_percentil_50)));
        this.mColors.put(Integer.valueOf(75),
                Integer.valueOf(getResources().getColor(R.color.relevance_percentil_75)));
        this.mColors.put(Integer.valueOf(100),
                Integer.valueOf(getResources().getColor(R.color.relevance_percentil_100)));

        //Relevance is 0 until is sets
        this.mRelevance = 0.0f;
    }

