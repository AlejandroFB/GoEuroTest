package com.goeuro.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the coordinates from a concrete position.
 * <p/>
 * Note that this object will be parsed from the JSON data retrieved using
 * Location JSON API.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {

	private Double latitude;
	private Double longitude;
	
	public GeoPosition() {	
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
}
