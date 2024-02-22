  package testDataKlasoru;

  import org.json.JSONObject;

  import java.util.HashMap;
  import java.util.Map;
  import java.util.Objects;

  public class JsonObjeleriTestDatalari {

      public static int basariliStatusCode = 200;
      public static String contentType = "application/json; charset=utf-8";
      public static String connectionHeaderDeğeri = "keep-alive";

      public static JSONObject putRequestBodyOlusturma() {

          /*
          Asagidaki JSON Objesini olusturup konsolda yazdirin.
  {
  "firstname":"Jim",
  "additionalneeds":"Breakfast",
  "bookingdates": {
  "checkin":"2018-01-01",
  "checkout":"2019-01-01"
  },
  "totalprice":111,
  "depositpaid":true,
  "lastname":"Brown"
  }
           */

          JSONObject innerJsonObjBody = new JSONObject();
          innerJsonObjBody.put("checkin", "2018-01-01");
          innerJsonObjBody.put("checkout", "2019-01-01");

          JSONObject jsonObjReqBody = new JSONObject();
          jsonObjReqBody.put("firstname", "Jim");
          jsonObjReqBody.put("lastname", "Brown");
          jsonObjReqBody.put("totalprice", 111);
          jsonObjReqBody.put("depositpaid", true);
          jsonObjReqBody.put("bookingdates", innerJsonObjBody);
          jsonObjReqBody.put("additionalneeds", "Breakfast");


          return jsonObjReqBody;
      }

      public static JSONObject putReqOlusturma() {
            /*
          C4_Put_ResponseBilgileriAssertion
  https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
  PUT request gonderdigimizde
  {
  "title": "Ahmet",
  "body": "Merhaba",
  "userId": 10,
  "id": 70
  }
  donen Response’un,
  status code’unun 200,
  ve content type’inin application/json; charset=utf-8,
  ve Server isimli Header’in degerinin cloudflare,
  ve status Line’in HTTP/1.1 200 OK
         */

          JSONObject jsonReq = new JSONObject();
          jsonReq.put("title", "Ahmet");
          jsonReq.put("body", "Merhaba");
          jsonReq.put("userId", 10);
          jsonReq.put("id", 70);


          return jsonReq;
      }

      /*
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladigimizda donen response'in status kodunun 200 ve
response body'sinin asagida verilen ile ayni oldugunu test ediniz
 Response body :
  {
  "userId":3,
  "id":22,
  "title":"dolor sint quo a velit explicabo quia nam",
  "body":"eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita earum mollitia molestiae aut atque rem suscipitnam impedit esse"
  }
   */

      public static JSONObject expectedBodyOlusturJSON() {

          JSONObject expBodyJSON = new JSONObject();

          expBodyJSON.put("userId", 3);
          expBodyJSON.put("id", 22);
          expBodyJSON.put("title", "dolor sint quo a velit explicabo quia nam");
          expBodyJSON.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

          return expBodyJSON;
      }


      public static Map<String,Object> putReqOlusturmaMap() {
            /*
          C4_Put_ResponseBilgileriAssertion
  https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
  PUT request gonderdigimizde
  {
  "title": "Ahmet",
  "body": "Merhaba",
  "userId": 10,
  "id": 70
  }
  donen Response’un,
  status code’unun 200,
  ve content type’inin application/json; charset=utf-8,
  ve Server isimli Header’in degerinin cloudflare,
  ve status Line’in HTTP/1.1 200 OK
         */
          Map<String, Object> jsonReq = new HashMap<>();

          jsonReq.put("title", "Ahmet");
          jsonReq.put("body", "Merhaba");
          jsonReq.put("userId", 10.0);
          jsonReq.put("id", 70.0);
return jsonReq;
      }
  }