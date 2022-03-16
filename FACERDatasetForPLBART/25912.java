	/**
	 * <p>
	 * Initializes the instance for first use.
	 * </p>
	 */
	private void init() {
		List<Rule> rulesList = parsePattern();
		mRules = rulesList.toArray(new Rule[rulesList.size()]);

		int len = 0;
		for (int i = mRules.length; --i >= 0;) {
			len += mRules[i].estimateLength();
		}

		mMaxLengthEstimate = len;
	}

