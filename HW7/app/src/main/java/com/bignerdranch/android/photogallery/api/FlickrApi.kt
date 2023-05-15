package com.bignerdranch.android.photogallery.api

import retrofit2.Response
import retrofit2.http.GET

private const val API_KEY = "3cbb644ec27743bad133c9c4baa801f1"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}