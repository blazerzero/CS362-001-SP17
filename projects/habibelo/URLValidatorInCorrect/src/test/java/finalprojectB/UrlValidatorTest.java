/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;

import java.util.*;
import java.lang.*;



/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   /* RESULTPAIR CLASS AND RESULTPAIR OBJECTS FROM PART A (URLVALIDATORCORRECT) */
   public class ResultPair {
      public String item;
      public boolean valid;

      public ResultPair(String item, boolean valid) {
         this.item = item;
         this.valid = valid;  //Weather the individual part of url is valid.
      }
   }

   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};
   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                             new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };
   /******************************************************/

   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
      System.out.println("/********************************/");
      System.out.println("/******** testManualTest ********/");
      System.out.println("/********************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      System.out.println("http://www.amazon.com, Expected: true, Actual: "+urlVal.isValid("http://www.amazon.com"));
      System.out.println("ftp://www.amazon.com, Expected: true, Actual: "+urlVal.isValid("ftp://www.amazon.com"));
      System.out.println("h3t://www.amazon.com, Expected: true, Actual: "+urlVal.isValid("h3t://www.amazon.com"));
      System.out.println("http:/www.amazon.com, Expected: false, Actual: "+urlVal.isValid("http:/www.amazon.com"));
      System.out.println("ftp:/www.amazon.com, Expected: false, Actual: "+urlVal.isValid("ftp:www.amazon.com"));
      System.out.println("h3t//www.amazon.com, Expected: false, Actual: "+urlVal.isValid("h3t//www.amazon.com"));
      System.out.println("www.amazon.com, Expected: true, Actual: "+urlVal.isValid("www.amazon.com"));
      System.out.println();

      assertTrue(urlVal.isValid("http://www.amazon.com"));      // correctly passes
      assertTrue(urlVal.isValid("ftp://www.amazon.com"));       // correctly passes
      assertTrue(urlVal.isValid("h3t://www.amazon.com"));       // correctly passes
      assertFalse(urlVal.isValid("http:/www.amazon.com"));  // correctly passes
      assertFalse(urlVal.isValid("ftp:www.amazon.com"));    // correctly passes
      assertFalse(urlVal.isValid("h3t//www.amazon.com"));   // correctly passes
      assertTrue(urlVal.isValid("www.amazon.com"));         // this is a valid URL but it returns false;
                                                            // FAILURE: isValid returns false for any URL with scheme ""
       System.out.println();
   }

   public void testPortValidatorManually() {

       System.out.println("/*******************************************/");
       System.out.println("/******** testPortValidatorManually ********/");
       System.out.println("/*******************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String url1 = "http://www.google.com:1";
      String url2 = "http://www.google.com:80";
      String url3 = "http://www.google.com:123";
      String url4 = "http://www.google.com:1234";
      String url5 = "http://www.google.com:65535";
      System.out.println(url1 + ", Expected: true, Actual: " + urlVal.isValid(url1));
      System.out.println(url2 + ", Expected: true, Actual: " + urlVal.isValid(url2));
      System.out.println(url3 + ", Expected: true, Actual: " + urlVal.isValid(url3));
      System.out.println(url4 + ", Expected: true, Actual: " + urlVal.isValid(url4));
      System.out.println(url5 + ", Expected: true, Actual: " + urlVal.isValid(url5));
      assertTrue(urlVal.isValid(url1));
      assertTrue(urlVal.isValid(url2));
      assertTrue(urlVal.isValid(url3));
      assertTrue(urlVal.isValid(url4));
      assertTrue(urlVal.isValid(url5));

       System.out.println();
   }

   public void testQueryValidatorManually() {

       System.out.println("/********************************************/");
       System.out.println("/******** testQueryValidatorManually ********/");
       System.out.println("/********************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String url1 = "http://www.google.com?actionview";
      String url2 = "http://www.google.com";
      String url3 = "http://www.google.com?action=view";
      String url4 = "http://www.google.com?action=edit&mode=up";
      System.out.println(url1 + ", Expected: false, Actual: " + urlVal.isValid(url1));
      System.out.println(url2 + ", Expected: true, Actual: " + urlVal.isValid(url2));
      System.out.println(url3 + ", Expected: true, Actual: " + urlVal.isValid(url3));
      System.out.println(url4 + ", Expected: true, Actual: " + urlVal.isValid(url4));
      assertFalse(urlVal.isValid(url1));
      assertTrue(urlVal.isValid(url2));
      assertTrue(urlVal.isValid(url3));
      assertTrue(urlVal.isValid(url4));

       System.out.println();
   }

   public void testCountryCodeTLDManually() {

       System.out.println("/********************************************/");
       System.out.println("/******** testCountryCodeTLDManually ********/");
       System.out.println("/********************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String url1 = "http://www.google.com.ac";
      String url2 = "http://www.google.com.aq";
      String url3 = "http://www.google.com.bn";
      String url4 = "http://www.google.com.co";
      String url5 = "http://www.google.com.gb";
      String url6 = "http://www.google.com.ir";
      String url7 = "http://www.google.com.it";    // last accepted country code TLD in the buggy version
      String url8 = "http://www.google.com.lv";    // starting here, these will all fail in the buggy version
      String url9 = "http://www.google.com.mo";
      String url10 = "http://www.google.com.rs";
      String url11 = "http://www.google.com.tp";
      String url12 = "http://www.google.com.tw";
      String url13 = "http://www.google.com.us";
      String url14 = "http://www.google.com.zw";
      String[] urls = {url1, url2, url3, url4, url5, url6, url7, url8, url9, url10, url11, url12, url13, url14};
      for (int i = 0; i < urls.length; i++) System.out.println(urls[i] + ", Expected: true, Actual: " + urlVal.isValid(urls[i]));
      for (int i = 0; i < urls.length; i++) assertTrue(urlVal.isValid(urls[i]));

       System.out.println();
   }

   public void testIPSegmentManually() {

       System.out.println("/***************************************/");
       System.out.println("/******** testIPSegmentManually ********/");
       System.out.println("/***************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String url1 = "http://0.0.0.0";
      String url2 = "http://80.80.80.80";
      String url3 = "http://255.255.255.255";
      String url4 = "http://256.256.256.256";
      String url5 = "http://500.500.500.500";
      System.out.println(url1 + ", Expected: true, Actual: " + urlVal.isValid(url1));
      System.out.println(url2 + ", Expected: true, Actual: " + urlVal.isValid(url2));
      System.out.println(url3 + ", Expected: true, Actual: " + urlVal.isValid(url3));
      System.out.println(url4 + ", Expected: false, Actual: " + urlVal.isValid(url4));
      System.out.println(url5 + ", Expected: false, Actual: " + urlVal.isValid(url5));
      assertTrue(urlVal.isValid(url1));
      assertTrue(urlVal.isValid(url2));
      assertTrue(urlVal.isValid(url3));
      assertFalse(urlVal.isValid(url4));
      assertFalse(urlVal.isValid(url5));

       System.out.println();
   }

   public void testHostnameManually() {

       System.out.println("/**************************************/");
       System.out.println("/******** testHostnameManually ********/");
       System.out.println("/**************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String url1 = "http://localhost";
      String url2 = "http://localdomain";
      System.out.println(url1 + ", Expected: true, Actual: " + urlVal.isValid(url1));
      System.out.println(url2 + ", Expected: true, Actual: " + urlVal.isValid(url2));
      assertTrue(urlVal.isValid(url1));
      assertTrue(urlVal.isValid(url2));

       System.out.println();
   }

   public void testAllTrue()      // all pieces true
                                  /* Uncovers the query problem or a bug reading full URLs */
   {
      System.out.println("/*****************************/");
      System.out.println("/******** testAllTrue ********/");
      System.out.println("/*****************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=view"));
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  for (int e = 0; e < testUrlQuery.length; e++) {
                     if (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == true) {
                        String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + testUrlQuery[e].item;
                        if (urlVal.isValid(url) != true) flag = " **************\n\n";
                        System.out.println(url + ", Expected: true, Actual: " + urlVal.isValid(url) + flag);
                        assertTrue(urlVal.isValid(url));
                     }
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testAllFalse()      // all pieces false
   {
      System.out.println("/******************************/");
      System.out.println("/******** testAllFalse ********/");
      System.out.println("/******************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  if (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == false) {
                     String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + "?badQuery";
                     if (urlVal.isValid(url) != false) flag = " **************\n\n";
                     System.out.println(url + ", Expected: false, Actual: " + urlVal.isValid(url) + flag);
                     assertFalse(urlVal.isValid(url));
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testOnePieceFalse()     // one piece false
                                       /* Uncovers query bug */
   {
      System.out.println("/***********************************/");
      System.out.println("/******** testOnePieceFalse ********/");
      System.out.println("/***********************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  for (int e = 0; e < testUrlQuery.length; e++) {
                     if ((testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == false)) {
                        String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + testUrlQuery[e].item;
                        if (urlVal.isValid(url) != false) flag = " **************\n\n";
                        System.out.println(url + ", Expected: false, Actual: " + urlVal.isValid(url) + flag);
                        assertFalse(urlVal.isValid(url));
                     }
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testTwoPiecesFalse()      // two pieces false
   {
      System.out.println("/************************************/");
      System.out.println("/******** testTwoPiecesFalse ********/");
      System.out.println("/************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  for (int e = 0; e < testUrlQuery.length; e++) {
                     if ((testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == false)) {
                        String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + testUrlQuery[e].item;
                        if (urlVal.isValid(url) != false) flag = " **************\n\n";
                        System.out.println(url + ", Expected: false, Actual: " + urlVal.isValid(url) + flag);
                        assertFalse(urlVal.isValid(url));
                     }
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testThreePiecesFalse()      // three pieces false
   {
      System.out.println("/**************************************/");
      System.out.println("/******** testThreePiecesFalse ********/");
      System.out.println("/**************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  for (int e = 0; e < testUrlQuery.length; e++) {
                     if ((testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == true)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == true && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == false)) {
                        String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + testUrlQuery[e].item;
                        if (urlVal.isValid(url) != false) flag = " **************\n\n";
                        System.out.println(url + ", Expected: false, Actual: " + urlVal.isValid(url) + flag);
                        assertFalse(urlVal.isValid(url));
                     }
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testFourPiecesFalse()      // four pieces false
   {
      System.out.println("/*************************************/");
      System.out.println("/******** testFourPiecesFalse ********/");
      System.out.println("/*************************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String flag = "";
      for (int a = 0; a < testUrlScheme.length; a++) {
         for (int b = 0; b < testUrlAuthority.length; b++) {
            for (int c = 0; c < testUrlPort.length; c++) {
               for (int d = 0; d < testPath.length; d++) {
                  for (int e = 0; e < testUrlQuery.length; e++) {
                     if ((testUrlScheme[a].valid == true && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == true && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == true && testPath[d].valid == false && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == true && testUrlQuery[e].valid == false)
                      || (testUrlScheme[a].valid == false && testUrlAuthority[b].valid == false && testUrlPort[c].valid == false && testPath[d].valid == false && testUrlQuery[e].valid == true)) {
                        String url = testUrlScheme[a].item + testUrlAuthority[b].item + testUrlPort[c].item + testPath[d].item + testUrlQuery[e].item;
                        if (urlVal.isValid(url) != false) flag = " **************\n\n";
                        System.out.println(url + ", Expected: false, Actual: " + urlVal.isValid(url) + flag);
                        assertFalse(urlVal.isValid(url));
                     }
                  }
               }
            }
         }
      }
      System.out.println();
   }

   public void testIsValid1()
   {
      System.out.println("/******************************/");
      System.out.println("/******** testIsValid1 ********/");
      System.out.println("/******************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      for(int i = 0; i < 10000; i++)
      {
         Boolean valid = true;
         Random random = new Random();
         int schemepick = random.nextInt(9);
         int authoritypick = random.nextInt(19);
         String url = testUrlScheme[schemepick].item
                      + testUrlAuthority[authoritypick].item;
         System.out.println(url + " valids: "
                      + testUrlScheme[schemepick].valid
                      + ", " + testUrlAuthority[authoritypick].valid);

         if (testUrlScheme[schemepick].valid == false
          || testUrlAuthority[authoritypick].valid == false) {
            valid = false;
         }

         System.out.println(url + ", " + urlVal.isValid(url));    // FAILURE: isValid at times returns true when the URL is invalid
         System.out.println();

         if (valid == true) assertTrue(urlVal.isValid(url));
         else assertFalse(urlVal.isValid(url));
      }
      System.out.println();
   }

   public void testIsValid2()       /* Uncovers port bug */
   {
      System.out.println("/******************************/");
      System.out.println("/******** testIsValid2 ********/");
      System.out.println("/******************************/");

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   for(int i = 0; i < 10000; i++)
	   {
         Boolean valid = true;
         Random random = new Random();
         int schemepick = random.nextInt(9);
         int authoritypick = random.nextInt(19);
         int portpick = random.nextInt(7);
         int pathpick = random.nextInt(10);
         int querypick = random.nextInt(3);
         String url = testUrlScheme[schemepick].item
                      + testUrlAuthority[authoritypick].item
                      + testUrlPort[portpick].item
                      + testPath[pathpick].item
                      + testUrlQuery[querypick].item;
         System.out.println(url + " valids: "
                      + testUrlScheme[schemepick].valid
                      + ", " + testUrlAuthority[authoritypick].valid
                      + ", " + testUrlPort[portpick].valid
                      + ", " + testPath[pathpick].valid
                      + ", " + testUrlQuery[querypick].valid);

         if (testUrlScheme[schemepick].valid == false
          || testUrlAuthority[authoritypick].valid == false
          || testUrlPort[portpick].valid == false
          || testPath[pathpick].valid == false
          || testUrlQuery[querypick].valid == false) {
             valid = false;
         }

         System.out.println(url + ", " + urlVal.isValid(url));    // always returns false for these complete URLs
         System.out.println();

         if (valid == true) assertTrue(urlVal.isValid(url));
         else assertFalse(urlVal.isValid(url));
	   }
      System.out.println();
   }




   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */


}
