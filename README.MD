since I got 1 day for the tests I finished only the Web part

for the api I will just list out the test case. I you want it fully automated please give a another weekends

For Web:
* Technology used:
  * Playwright
  * TestNg
  * Spring Boot

Framework Structure: POM + Dependencies injection

For API:
* Technology use:
  * RestAssured
  * TestNg
  * Multi threaded for performance check

Framework Structure: Model - Controller + Depenencies injection


Test-cases for API:
1. Parse Function:
   * Verify that POST image (full data) and data correctly Parsed
   * Verify that POST image have special character for name or address
   * Verify that POST image have incorrect DOB format
   * Verify that POST image (missing data) and data still correctly parsed
   * Verify that POST image have a long String
2. Verify  POST image with different headers (diffrent content type) - verify error 500
6. Verify  POST image with incorrect image-dataType - verify error 500
8. Verify  POST huge image - should return error (Can only process image below 100MB)
9. Verify  POST a null image
10. Verify POST a image that is not an ID
7. Verify that performance is as expected when sending huge number of requests