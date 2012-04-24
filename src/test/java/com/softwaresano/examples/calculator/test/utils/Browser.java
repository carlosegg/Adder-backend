package com.softwaresano.examples.calculator.test.utils;

public class Browser{
	public Browser(String name, String version, String platform) {
		this.name = name;
		this.version = version;
		this.platform = platform;
	}
	public Browser(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Browser [name=" + name + ", version=" + version
				+ ", platform=" + platform + "]";
	}
	private String name = null;
	private String version = null;
	private String platform = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
}