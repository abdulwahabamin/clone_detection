	private List<String> getAvailableGovernors() {
		if (availableGovernors != null)
			return availableGovernors;
		else {
			BufferedReader in = null;
			try {
				Process process;
				// Read list of available governors from file
				// /sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors
				process = Runtime.getRuntime().exec(
						"cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors");
				in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				ArrayList<String> governors = new ArrayList<String>();
				String line;
				while ((line = in.readLine()) != null) {
					String[] lines = line.split(" ");
					for (int i = 0; i < lines.length; i++) {
						String governor = lines[i].trim();
						if (governor.length() > 0)
							governors.add(governor);
					}
				}
				if (governors.size() <= 0)
					return null;
				else {
					availableGovernors = governors;
					return governors;
				}
			} catch (Exception e) {
				Log.e(e.getClass().getName(), e.getMessage(), e);
				return null;
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (IOException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				}
			}
		}
	}

