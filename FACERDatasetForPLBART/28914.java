        /**
         * @see IProcessHttpRequest#processSuccessScenario(String)
         */
        @Override
        public void processSuccessScenario(String response) {
            // Retrieve all weather information
            List<RadiusSearchItem> radiusItems = new ArrayList<>();
            IDataExtractor extractor = new OwmDataExtractor();
            try {
                JSONObject json = new JSONObject(response);
                JSONArray list = json.getJSONArray("list");
                for (int i = 0; i < list.length(); i++) {
                    String currentItem = list.get(i).toString();
                    RadiusSearchItem searchItem = extractor.extractRadiusSearchItemData(currentItem);
                    // Data were not well-formed, abort
                    if (searchItem == null) {
                        final String ERROR_MSG = context.getResources().getString(R.string.convert_to_json_error);
                        Toast.makeText(context, ERROR_MSG, Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        radiusItems.add(searchItem);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Sort the weather and get the items to display
            Collections.sort(radiusItems, new RadiusSearchItemComparator());
            int endIndex = radiusItems.size() > resultCount ? resultCount : radiusItems.size();
            ArrayList<RadiusSearchItem> resultList = new ArrayList<>();
            for (int i = 0; i < endIndex; i++) {
                resultList.add(radiusItems.get(i));
            }

            // Finally, load the activity to show the result
            Intent intent = new Intent(context, RadiusSearchResultActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("resultList", resultList);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

