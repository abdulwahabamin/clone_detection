    /**
     * @param editField    The component to "transform" into one that shows a city drop down list
     *                     based on the current input. Make sure to pass an initialized object,
     *                     else a java.lang.NullPointerException will be thrown.
     * @param listLimit    Determines how many items shall be shown in the drop down list at most.
     */
    public void generate(AutoCompleteTextView editField, int listLimit, final int enterActionId, final MyConsumer<City> cityConsumer, final Runnable selectAction) {
        cityAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, new ArrayList<City>());
        this.editField = editField;
        this.cityConsumer = cityConsumer;
        this.listLimit = listLimit;
        editField.setAdapter(cityAdapter);
        editField.addTextChangedListener(new TextChangeListener());

        editField.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = (City) parent.getItemAtPosition(position);
                cityConsumer.accept(selectedCity);
            }
        });

        editField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == enterActionId) {
                    Boolean checkCity = checkCity();
                    if (checkCity) {
                        selectAction.run();
                    }
                    return true;
                }
                return false;
            }
        });
    }

