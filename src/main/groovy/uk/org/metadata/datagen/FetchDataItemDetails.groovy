package uk.org.metadata.datagen

import groovy.transform.CompileStatic
//import groovy.util.logging.Log4j
import okhttp3.Credentials
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

//@Log4j
@CompileStatic
class FetchDataItemDetails {

   // localhost:8080/catalogue/dataType/3378@1.0.0/export
    final OkHttpClient client = new OkHttpClient()


    String getDataItemDetail(){

        String metadataUrl = "http://localhost:8080"
        final String url = "${metadataUrl}/api/modelCatalogue/core/catalogueElement/dataType/3378@1.0.0/export"
        final String credential =  Credentials.basic("admin", "MTM5MDgyYTgtOThhYS00YmVkLTkzODMtNThlNjAxNjZiYjJh")

        Request request = new Request.Builder()
                .url("http://localhost:8080/catalogue/dataType/3378@1.0.0/export")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "1f694d19-efbd-406c-be31-9463b33182b2")
                .build()


        try {
            Response response = client.newCall(request).execute()

            if ( response.isSuccessful()  ) {

                response.body().source()


            } else {
                println "Response {}. Could not fetch Data Models at {}"
            }
            response.close()
        } catch (IOException ioexception) {
            println "unable to connect to server {}', metadataUrl"
        }

    }



}


//curl -L -u admin:MTM5MDgyYTgtOThhYS00YmVkLTkzODMtNThlNjAxNjZiYjJh http://localhost:8080/catalogue/dataType/3378@1.0.0/export