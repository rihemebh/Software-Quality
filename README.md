
- [Clean code](#clean-code) 
   - [SOLID](#solid)
- [Selenium](#selenium)
- [JUnit](#junit)


# Clean code 

## SOLID


# Selenium

Selenium is an open source automated testing suite for web applications across different browsers and platforms. 
=> It focuses on automating 

Selenium is not just a single tool but a suite of software's, each catering to different testing needs of an organization. 
It has 4 components: 
1. Selenium Integrated Development Environment (IDE)
2. Selenium Remote Control (RC)
3. WebDriver
4. Selenium Grid

## 1. Selenium IDE 
Selenium Integrated Development Environment (IDE) is the simplest framework
in the Selenium suite and is the easiest one to learn. (record) 

## 2. Selenium RC 

## 3. Webdriver
WebDriver is a web automation framework that allows you to execute your tests against different browsers, 
WebDriver also enables you to use a programming language in creating your test scripts (not possible in Selenium IDE).
It controls the browser from the OS level

WebDriver directly talks to the browser while Selenium RC needs the help of the RC Server in order to do so.

- Open Web Page
```Java
driver.get("https://google.com");
driver.navigate().to("http://www.insat.rnu.tn");
```
- Get URL 
```Java
driver .getCurrentUrl();
```
- Get title
```Java
driver.getTitle();
```
- Forward , back , refrech the page
```Java
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();
```
- Switch 
```Java
driver.switchTo().newWindow(WindowType.WINDOW);
driver.switchTo().newWindow(WindowType.TAB);
```

- Close 
```Java
driver.close(); driver.quit();
```

- Windows management 

```Java
// Size
driver.manage().getSize().getHeight();
driver.manage().getSize().getWidth();

//Position
driver.manage().setPosition(new Point(0,0));

driver.manage().window().maximize();
driver.manage().window().minimize();
driver.manage().window().fullscreen();

//Screenshots

File screeenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
```

## 4. Selenium Grid

Selenium grid is a tool used together with Selenium RC to run parallel tests across different machines and different browsers all at the same time. 
Parallele execution means running multiple test at one 


# JUnit 
JUnit is an open source framework for the development and execution of automatable unit tests. The main interest is to ensure that the code still meets the needs even after possible modifications. More generally, this type of tests is called unit non-regression tests.
