 		@Override
		protected FilterResults performFiltering(CharSequence arg0) {
	
			lastFilter = (arg0 != null) ? arg0.toString() : null;
			
			Filter.FilterResults results = new Filter.FilterResults();

			// No results yet?
			if (mOriginalItems == null) {
				results.count = 0;
				results.values = null;
				return results;
			}
			
			int count = mOriginalItems.size();

			if (arg0 == null || arg0.length() == 0) {
				results.count = count;
				results.values = mOriginalItems;
				return results;
			}
			
			
			List<IconifiedText> filteredItems = new ArrayList<IconifiedText>(count);
			
			int outCount = 0;
			CharSequence lowerCs = arg0.toString().toLowerCase();
			
			
			for (int x=0; x<count; x++) {
				IconifiedText text = mOriginalItems.get(x);
				
				if (text.getText().toLowerCase().contains(lowerCs)) {
					// This one matches.
					filteredItems.add(text);
					outCount++;
				}
			}
			
			results.count = outCount;
			results.values = filteredItems;
			return results;
		}

