	private String getCPUGovernor() {
		BufferedReader in = null;
		try {
			Process process;
			process = Runtime.getRuntime().exec("cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor");
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			if ((line = in.readLine()) != null) {
				line = line.trim();
				if (getAvailableGovernors().contains(line))
					return line;
				Log.e(getClass().getName(),
						"The value reading from /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor is not a valid governor");
			} else
				Log.e(getClass().getName(), "Error reading scaling_governor, in.readLine() is null");

		} catch (Exception e) {
			Log.e(e.getClass().getName(), e.getMessage(), e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				Log.e(e.getClass().getName(), e.getMessage(), e);
			}
		}
		return null;
	}

