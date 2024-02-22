package pojos;

public class JsonPlaceReqBodyPojo {

/*

"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
 */

    //1- obje içindeki tüm key değerlerini private olarak hazırlama
    private String title;
    private String body;
    private int userId;
    private int id;

    //2- getter setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3- tüm parametleri içeren constractr


    public JsonPlaceReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4- Parametresiz constractor

    public JsonPlaceReqBodyPojo() {
    }

    //5- toString


    @Override
    public String toString() {
        return "JsonPlaceReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
