package com.jonathanhaslop.pom;

import org.openqa.selenium.WebDriver;

public class Page extends Layer {

	public HomePage homePage;

	public Page(WebDriver driver) {
		super(driver);
		this.homePage = new HomePage(driver);
	}

}
