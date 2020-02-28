package io.github.mngsk.devicedetector.device;

import java.util.Optional;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TelevisionDeviceParser extends AbstractDeviceParser {

	private Pattern hbbtvPattern = Pattern.compile(
			"HbbTV/([1-9]{1}(?:\\.[0-9]{1}){1,2})", Pattern.CASE_INSENSITIVE);

	public TelevisionDeviceParser() {
		super("regexes/device/televisions.yml");
	}

	public TelevisionDeviceParser(ObjectMapper objectMapper) {
		super("regexes/device/televisions.yml", objectMapper);
	}

	@Override
	public Optional<Device> parse(String userAgent) {
		if (!this.hbbtvPattern.matcher(userAgent).find()) {
			return Optional.empty();
		}

		return Optional.of(
				super.parse(userAgent).orElse(new Device("tv", null, null)));
	}

}
